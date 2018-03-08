package application;

import java.util.ArrayList;
//import Application.Lien;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;

import application.NavigationRandom;

public class Scoring {
	
	private static double[] tabPourcentage;
	private static ArrayList<Integer> positions;
	private static List<WebElement> AllLinks;
	private static ArrayList<String> MotCle;
	private int pos;
	
	public Scoring (List<WebElement> AllLinks, ArrayList<String> MotCle) {
		this.AllLinks = AllLinks;
		this.MotCle = MotCle;
		
	}
	
	public static int compte(String str, String chaine) {
		chaine = chaine+"i";
		String[] tab = chaine.split(str);
		return (tab.length-1);
	}
		
	public static WebElement points(List<WebElement> AllLinks, List<String> motcle){
		
		ArrayList<Integer> Points = new ArrayList<Integer>();
		tabPourcentage = new double[AllLinks.size()];
		WebElement FinalLink;
		//ArrayList<Integer> positionsDeChaqueMotCle = new ArrayList<Integer>();
		ArrayList<WebElement> AllLinksWithKeyWord = new ArrayList<WebElement>();
		//ArrayList<Integer> positions = new ArrayList<Integer>();
				
		for(int i =0; i<((List<WebElement>) AllLinks).size();i++)
		{
			WebElement LinkChoice = ((List<WebElement>) AllLinks).get(i);
			System.out.println(LinkChoice.getAttribute("href"));
			String href = LinkChoice.getAttribute("href");
			
			//int max = href.length(); // position max du premier mot cle du href
			Points.add(i,0);
			//positions.add(i,0);
			//positionsDeChaqueMotCle.add(i,0);
			
			for(int j=0;j<motcle.size();j++)
			{
				Points.set(i, Points.get(i)+compte(motcle.get(j),href));
				
				//positionsDeChaqueMotCle.set(i,href.indexOf(motcle.get(j)));
				//if(positionsDeChaqueMotCle.get(j) < max)
				//   max = positionsDeChaqueMotCle.get(j);		
			}
			tabPourcentage[i]=pourcentage(nombreMots(href),Points.get(i));
			AllLinksWithKeyWord.add(LinkChoice);
		}
		
		return FinalLink = meilleur_lien(tabPourcentage, AllLinksWithKeyWord);
	}
	
	public static WebElement meilleur_lien(double [] tabPourcentage, List<WebElement> AllLinksWithKeyWord )
	{
		double max = 0.0;
		int indice = 0;
		for(int i = 0; i<tabPourcentage.length; i++)
		{	
			if(tabPourcentage[i] > max) 
			{
				max = tabPourcentage[i];
				indice = i;
			}
		}
		return AllLinksWithKeyWord.get(indice);
	}
	
	/*calcule le nombre de mots dans une chaine*/
	public static int nombreMots(String href) {
		char[] x = new char[href.length()];
		int cmp=1;
		for(int l=0;l<href.length();l++) {
			x[l]=href.charAt(l);
		if((x[l]=='\\') || (x[l]=='*') || (x[l]=='.') || (x[l]=='+') || (x[l]==',') || (x[l]=='?') || (x[l]==']') || (x[l]=='[') 
				|| (x[l]==')') || (x[l]=='(') || (x[l]=='}') || (x[l]=='{') || (x[l]==':') || (x[l]=='_') || (x[l]=='#') || (x[l]=='-') 
				|| (x[l]=='&') || (x[l]=='!') || (x[l]=='=') || (x[l]=='/'))
			x[l]=' ';
		}
		for(int l=1;l<href.length();l++)
		{
			if((x[l]==' ')&&(x[l-1]!=' '))
				cmp++;
		}
		return cmp;
	}
	
	/*calcule le pourcentage*/
	public static double pourcentage(int nombreMot, int nombreMotCle)
	{
		double res = 0.0;
		res = ((double)nombreMotCle/(double)nombreMot)*100;
		return res;
	}
	
}