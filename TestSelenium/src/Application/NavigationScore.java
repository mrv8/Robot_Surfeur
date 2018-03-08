package application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationScore implements DriverSelenium {
	
	Liens lien = new Liens();
	
	public void OpenPage(String url) throws InterruptedException {

		driver.get(url); //ouvre le navigateur avec l'url passé en parametre		
		driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran 
		sleep(2000); // pause de 2 secondes pour que la page ce charge à 1000% 
	}
	
	
	
	public void findHref() throws InterruptedException{

		int cpt = 0;
		boolean visite = false;
		motCle.add("Dragon");
		motCle.add("Quest");
		motCle.add("Monsters");
		while(visite != true) {

			int i=0;

			lien.addLiens( driver.findElements(By.xpath("//*[@href]")));// recup tous les lien avec le tag "a"
			
			WebElement pt = Scoring.points(Liens.AllLinks, motCle); // appelle de la fonction qui va scorer les liens entre 0 et 1
			System.out.println(pt.getAttribute("href"));
			
			String href = pt.getAttribute("href"); // recup la valeur href du lien 250
			
			scrolling(findPosition(pt));
			driver.get(href);
			sleep(500);

			if(cpt == 0) {
				visit.add(href);
				cpt = 1;
			}
			else
				visite = dejaVisite(href);			
		}
		System.out.println("Page déjà visiter");
	}

	public int findPosition(WebElement LinkChoice) {
		Point point = LinkChoice.getLocation();
		int Xcord = point.getX();
		int Ycord = point.getY();
		return Ycord;
	}

	public void scrolling(int cord) throws InterruptedException {

		int y2 = 0;

		for (int sec = 0;; sec++) {

			if(y2+200 >= cord)
				break;
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", ""); //y value '200' can be altered
			y2 += 200;
			sleep(1000);
		}
		sleep(2000);
	}

	public void sleep(int time) throws InterruptedException{
		Thread.sleep(time);
	}

	public boolean dejaVisite(String url) {

		for(String tmp : visit) {
			if (tmp.equals(url)) {
				return true;
			}
			else {
				visit.add(url);
				return false;
			}
		}
		return false;
	}

	public void close() {

		System.out.println("Closing driver");
		driver.quit();		
	}
}

