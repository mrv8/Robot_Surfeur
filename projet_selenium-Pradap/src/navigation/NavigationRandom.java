package navigation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import extraction.DriverSelenium;
import extraction.Lien;
import extraction.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import extraction.DriverSelenium;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationRandom {

    /*private List<String> visit = new ArrayList<String>();

    /*
     * Fonction qui permet d'ouvir une page firefox avec l'url donner dans la console.
     * @see Navigation.DriverSelenium#OpenPage(java.lang.String)
     
    public void OpenPage(String url) /*throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\FirefoxDrive\\geckodriver.exe");
        driver.get(url); //ouvre le navigateur avec l'url passé en parametre
        driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran
        new WebDriverWait(driver, 2); // pause de 2 secondes pour que la page ce charge à 1000%
    }

    /*
     * Fonction qui permet de recup tous les liens href de la page et de les stocker dans une liste
     * et dans récup un parmis cette liste.
     
    public void findHref() /*throws InterruptedException{

        int cpt = 0;
        boolean visite = false;

        while(cpt <10 && visite != true) {

            int i=0;
            int max=0;
            int mini=1;

            Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// recup tous les lien avec le tag "a"

            max = Page.getLiensDansLaPage().size(); // récup le nombre de liens trouvés
            
            int random = (int)(Math.random()*(max-mini+1))+mini; // choisit un nombre aléatoire entre 0 et le nombre de liens

            Lien LinkChoice = Page.getLiensDansLaPage().get(random);  // choisit un lien au hasard dans la liste des liens
            
           // String href = LinkChoice.getUrl(); // recup la valeur href du lien 250
            System.out.println(LinkChoice.getUrl());
            


            scrolling(findPosition(LinkChoice));
            driver.get(LinkChoice.getUrl());
           // sleep(500);
            new WebDriverWait(driver, 500);

            if(cpt == 0)
                visit.add(LinkChoice.getUrl());
            else {
                visite = dejaVisite(LinkChoice.getUrl());
                visit.add(LinkChoice.getUrl());
            }
            cpt ++;
        }
        JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé à déjà été visiter !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(visit.get(cpt-1));
    }

    public int findPosition(Lien LinkChoice) {
        Point point = LinkChoice.getLocation();
        int Xcord = point.getX();
        int Ycord = point.getY();
        return Ycord;
    }

    public void scrolling(int cord) /*throws InterruptedException {

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

     }*/

}
