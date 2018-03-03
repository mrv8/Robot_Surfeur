package Application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class navigationScore implements DriverSelenium {
	
	public String MotCle = "methodes";
	
	public void OpenPage(String url) throws InterruptedException {

		driver.get(url); //ouvre le navigateur avec l'url passé en parametre		
		driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran 
		sleep(2000); // pause de 2 secondes pour que la page ce charge à 1000% 
	}
	
	public void findHref() throws InterruptedException{

		int cpt = 0;
		boolean visite = false;

		while(visite != true) {

			int i=0;

 			List<WebElement> AllLinks = driver.findElements(By.xpath("//*[@href]"));// recup tous les lien avec le tag "a"
			
			List<WebElement> pt = Scoring.points(AllLinks, MotCle);

			/*for(WebElement we : pt) {
				System.out.println(we.getAttribute("href"));
			}*/
			
		    WebElement LinkChoice = pt.get(0);  // choisit un lien au hasard dans la liste des liens
			String href = LinkChoice.getAttribute("href"); // recup la valeur href du lien 250
			
			System.out.println(href);
			
			scrolling(findPosition(LinkChoice));
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

