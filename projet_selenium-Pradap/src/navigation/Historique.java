package navigation;

import java.util.ArrayList;
import java.util.Iterator;

import extraction.Lien;

public class Historique {

	private ArrayList<Lien> PageDejaVisite;

	/**
	 * Constructeur
	 */
	public Historique() {
		PageDejaVisite = new ArrayList<Lien>();
	}
	
	/**
	 * Ajoute un lien dans l'hostorique de la page visité
	 * @param lien
	 */
	public void addLinkInHistorique(Lien lien) {
		PageDejaVisite.add(lien);
	}

	/**
	 * 
	 * @return ArrayList<Lien>
	 */
	public ArrayList<Lien> getPageDejaVisite() {
		return PageDejaVisite;
	}
	
	/**
	 * Vérifie si le lien a déjà été visité ou non.
	 * @param LienCourant
	 * @return bool, true = déjà visité, false = pas déjà visité
	 */
	public boolean TestPageDejaVisite(Lien LienCourant) {
		Iterator<Lien> it = PageDejaVisite.iterator();
		
		while(it.hasNext()) {
			if (it.next().getTexte().equals(LienCourant.getTexte())) {
				return true;
			}
		}
		return false;
	}
}
