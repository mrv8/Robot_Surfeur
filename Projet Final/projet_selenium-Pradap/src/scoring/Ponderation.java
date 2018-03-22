package scoring;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import extraction.Lien;

public interface Ponderation {
	
	/**
	 * 
	 * @param str
	 * @param chaine
	 * @return int
	 */
	public int compte (String str, String chaine);
	
	/**
	 * 
	 * @param list
	 * @param motcle
	 * @return Lien
	 */
	public Lien points(List<Lien> list, List<String> motcle);
	
	/**
	 * 	
	 * @param allLinksWithKeyWord
	 * @return Lien
	 */
	public Lien meilleur_lien(List<Lien> allLinksWithKeyWord);
	
	/**
	 * 
	 * @param href
	 * @return int
	 */
	public int nombreMots(String href);
	
	/**
	 * 
	 * @param nombreMot
	 * @param nombreMotCle
	 * @return double
	 */
	public double pourcentage(int nombreMot, int nombreMotCle);
	
	/**
	 * 
	 * @return Lien
	 */
	public Lien RecupLienAleatoire();
}
