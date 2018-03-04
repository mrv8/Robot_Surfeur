package Application;

import java.util.ArrayList;
//import Application.Lien;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;

import Application.NavigationRandom;

public class Scoring {
	
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
	
	/*public static List<WebElement> points(List<WebElement> AllLinks, String MotCle){
		ArrayList<Integer> Points = new ArrayList<Integer>();
		List<WebElement> AllLinksWithKeyWord = new ArrayList<WebElement>();
		WebElement LinkChoice;
		String href;
		
		for(int i=0;i<AllLinks.size();i++)
		{
			LinkChoice = AllLinks.get(i);
			href = LinkChoice.getAttribute("href");
			Points.add(i,compte(MotCle,href));
			//int f = Math.max(Points);
			if(Points.get(i)>=1){
				AllLinksWithKeyWord.add(LinkChoice);
			}
		}
		return AllLinksWithKeyWord;
	}*/
	
	public static List<WebElement> points2(List<WebElement> AllLinks, List<String> motcle2){
		
		ArrayList<Integer> Points = new ArrayList<Integer>();
		ArrayList<Integer> positionsDeChaqueMotCle = new ArrayList<Integer>();
		List<WebElement> AllLinksWithKeyWord = new ArrayList<WebElement>();
		positions = new ArrayList<Integer>();
		
		ListIterator<WebElement> it = AllLinks.listIterator() ;
		
		WebElement LinkChoice;	
		String href;
		int i =0;
		
		while(it.hasNext())
		{
			LinkChoice = AllLinks.get(i);
			href = LinkChoice.getAttribute("href");
			int max = href.length(); // position max du premier mot cle du href
			Points.add(i,0);
			positions.add(i,0);
			
			for(int j=0;j<motcle2.size();j++)
			{
				Points.set(i, Points.get(i)+compte(motcle2.get(j),href));
				
				if(Points.get(i)!=0) {
					positionsDeChaqueMotCle.add(i,href.indexOf(motcle2.get(j)));
					if(positionsDeChaqueMotCle.get(j) < max)
						max = positionsDeChaqueMotCle.get(j);

					positions.set(i,max);
				}		
			}
			i++;
		}
		return AllLinksWithKeyWord;
	}

}