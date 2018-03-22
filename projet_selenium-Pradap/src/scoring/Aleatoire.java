package scoring;

import java.util.ArrayList;
import java.util.List;

import extraction.Lien;
import extraction.Page;

public class Aleatoire implements Ponderation {

	/**
	 * Récupère aléatoirement un lien
	 * @return Lien
	 */
	public Lien RecupLienAleatoire() {
		
		int max=0;
        int mini=1;
        
        max = Page.getLiensDansLaPage().size(); // récup le nombre de liens trouvés
        int random = (int)(Math.random()*(max-mini+1))+mini;
        Lien LinkChoice = Page.getLiensDansLaPage().get(random);
        
        return LinkChoice;
		        
	}


	@Override
	public int compte(String str, String chaine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Lien points(List<Lien> list, List<String> motcle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lien meilleur_lien(double[] tabPourcentage, ArrayList<Lien> allLinksWithKeyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombreMots(String href) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double pourcentage(int nombreMot, int nombreMotCle) {
		// TODO Auto-generated method stub
		return 0;
	}
}
