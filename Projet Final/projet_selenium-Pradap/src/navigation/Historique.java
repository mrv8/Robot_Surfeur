package navigation;

import java.util.ArrayList;
import java.util.Iterator;

import extraction.Lien;

public class Historique {

	private ArrayList<Lien> PageDejaVisite;
	
	/**
	 * Constructeur de l'historique
	 */
	public Historique() {
		PageDejaVisite = new ArrayList<Lien>();
	}
	
	/**
	 * Ajoute un lien dans l'historique
	 * @param lien
	 */
	public void addLinkInHistorique(Lien lien) {
		PageDejaVisite.add(lien);

	}

	/**
	 * Getter de l'historique
	 * @return ArrayList<Lien>
	 */
	public ArrayList<Lien> getPageDejaVisite() {
		return PageDejaVisite;
	}

	/**
	 * Parcours l'historique pour savoir si le lien courant à déjà été visité.
	 * @param LienCourant
	 * @return boolean
	 */
	public boolean TestPageDejaVisite(Lien LienCourant) {
		Iterator<Lien> it = PageDejaVisite.iterator();
		
		while(it.hasNext()) {
			if (it.next().getUrl().equals(LienCourant.getUrl())) //Compare l'url du lien courant à celui du lien de l'historique
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Parcours l'historique est récupére le score de chaque lien
	 * Comparaison du score du lien courant au score des liens stockés dans l'historique pour savoir si celui-ci est inférieure.
	 * @param LienCourant
	 * @return boolean
	 */
	public boolean TestScoreDiminue(Lien LienCourant) {
		Iterator<Lien> it = PageDejaVisite.iterator();
		
		while(it.hasNext()) {
			if (it.next().getScore()>(LienCourant.getScore())) //comparaison du score du lien courant à celui du lien de l'historique
			{
				return true;
			}
		}
		return false;
	}
}
