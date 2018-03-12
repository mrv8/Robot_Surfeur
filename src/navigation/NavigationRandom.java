package navigation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import extraction.DriverSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import extraction.DriverSelenium;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationRandom implements DriverSelenium{

    private List<String> visit = new ArrayList<String>();


    /*
     * Fonction qui permet d'ouvir une page firefox avec l'url donner dans la console.
     * @see Navigation.DriverSelenium#OpenPage(java.lang.String)
     */
    public void OpenPage(String url) /*throws InterruptedException */{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sitha\\Documents\\MIAGE\\Projet\\geckodriver.exe");
        driver.get(url); //ouvre le navigateur avec l'url passé en parametre
        driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran
       // sleep(2000); // pause de 2 secondes pour que la page ce charge à 1000%
        new WebDriverWait(driver, 2);
    }

    /*
     * Fonction qui permet de recup tous les liens href de la page et de les stocker dans une liste
     * et dans récup un parmis cette liste.
     */
    public void findHref() /*throws InterruptedException*/{

        int cpt = 0;
        boolean visite = false;

        while(cpt <10 && visite != true) {

            int i=0;
            int max=0;
            int mini=1;

            List<WebElement> AllLinks = driver.findElements(By.xpath("//*[@href]"));// recup tous les lien avec le tag "a"

            max = AllLinks.size(); // récup le nombre de liens trouvés
            int random = (int)(Math.random()*(max-mini+1))+mini; // choisit un nombre aléatoire entre 0 et le nombre de liens

            WebElement LinkChoice = AllLinks.get(random);  // choisit un lien au hasard dans la liste des liens
            String href = LinkChoice.getAttribute("href"); // recup la valeur href du lien 250
            System.out.println(href);


            scrolling(findPosition(LinkChoice));
            driver.get(href);
           // sleep(500);
            new WebDriverWait(driver, 500);

            if(cpt == 0)
                visit.add(href);
            else
                visite = dejaVisite(href);

            cpt ++;
        }
        System.out.println("Page déjà visiter");
    }

    public int findPosition(WebElement LinkChoice) {
        Point point = LinkChoice.getLocation();
        int Xcord = point.getX();
        int Ycord = point.getY();
        return Ycord;
    }

    public void scrolling(int cord) /*throws InterruptedException*/ {

        int y2 = 0;

        for (int sec = 0;; sec++) {

            if(y2+200 >= cord)
                break;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", ""); //y value '200' can be altered
            y2 += 200;
          //  sleep(1000);
            new WebDriverWait(driver, 1);
        }
       // sleep(2000);
        new WebDriverWait(driver, 2);
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

     public void findHref(String [] motCles) throws InterruptedException {

     }
}
