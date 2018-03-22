package scoring;

import java.util.ArrayList;
import java.util.List;

import extraction.Lien;

public interface Ponderation {
	
	public int compte (String str, String chaine);
	
	public Lien points(List<Lien> list, List<String> motcle);
		
	public Lien meilleur_lien(double [] tabPourcentage, ArrayList<Lien> allLinksWithKeyWord);

	public int nombreMots(String href);
	
	public double pourcentage(int nombreMot, int nombreMotCle);
	
	public Lien RecupLienAleatoire();
}
