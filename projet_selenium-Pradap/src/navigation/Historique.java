package navigation;

import java.util.ArrayList;
import java.util.Iterator;

import extraction.Lien;

public class Historique {

	private ArrayList<Lien> PageDejaVisite;

	public Historique() {
		PageDejaVisite = new ArrayList<Lien>();
	}

	public void addLinkInHistorique(Lien lien) {
		PageDejaVisite.add(lien);

	}

	public ArrayList<Lien> getPageDejaVisite() {
		return PageDejaVisite;
	}

	public boolean TestPageDejaVisite(Lien LienCourant) {
		Iterator<Lien> it = PageDejaVisite.iterator();
		
		while(it.hasNext()) {
			if (it.next().getUrl().equals(LienCourant.getUrl())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param LienCourant
	 * @return
	 */
	public boolean TestScoreDiminue(Lien LienCourant) {
		Iterator<Lien> it = PageDejaVisite.iterator();
		
		while(it.hasNext()) {
			if (it.next().getScore()>(LienCourant.getScore())) {
				return true;
			}
		}
		return false;
	}
}
