package Application;

import java.util.ArrayList;
//import Application.Lien;
import java.util.List;

import org.openqa.selenium.WebElement;

import Application.NavigationRandom;

public class Scoring {
	private static List<WebElement> AllLinks;
	private static String MotCle;
	private int pos;
	
	public Scoring (List<WebElement> AllLinks, String MotCle) {
		this.AllLinks = AllLinks;
		this.MotCle = MotCle;
	}
	
	public static int compte(String str, String chaine) {
		chaine = chaine+"i";
		String[] tab = chaine.split(str);
		return (tab.length-1);
	}
	
	public static List<WebElement> points(List<WebElement> AllLinks, String MotCle){
		ArrayList<Integer> Points = new ArrayList<Integer>();
		List<WebElement> AllLinksWithKeyWord = new ArrayList<WebElement>();;
		WebElement LinkChoice;
		String href;
		
		for(int i=0;i<AllLinks.size();i++)
		{
			LinkChoice = AllLinks.get(i);
			href = LinkChoice.getAttribute("href");
			Points.add(i,compte(MotCle,href));
			if(Points.get(i)>=1){
				AllLinksWithKeyWord.add(LinkChoice);
			}
		}
		return AllLinksWithKeyWord;
	}

}