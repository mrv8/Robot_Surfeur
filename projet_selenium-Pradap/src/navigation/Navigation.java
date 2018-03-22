package navigation;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import extraction.Lien;
import extraction.Page;
import scoring.Aleatoire;
import scoring.Scoring;


public class Navigation{

    Page pageCourante = new Page();
    Lien lien = new Lien();
    Scoring score = new Scoring();
    Aleatoire alea = new Aleatoire();
    Historique hist = new Historique();
    
    ArrayList<String> visit = new ArrayList<String>();
    ArrayList<String> motCle = new ArrayList<String>();
    
    
    WebDriver driver = new FirefoxDriver();
    JavascriptExecutor js = (JavascriptExecutor)driver;

    /**
     * Ouvre une url dans selenium
     * @param url
     */
    public void OpenPage(String url){

        driver.get(url); //ouvre le navigateur avec l'url passé en parametre
        driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran
        new WebDriverWait(driver, 2);
    }

    /**
     * Navigation avec un score par mot clé
     * @param motCles
     */
    public void NavigationScore(String[] motCles){
    	
        int cpt = 0;
        boolean visite = false;
        
        for (String unMot : motCles) {
            motCle.add(unMot);
        }

        while (visite != true)
        {
            pageCourante.clearLiens();
             
            Lien.tocast(driver.findElements(By.xpath("//*[@href]")));  // recup tous les lien avec le tag "a"

            Lien lienFinal = score.points(Page.getLiensDansLaPage(), motCle); // appelle de la fonction qui va scorer les liens entre 0 et 1
            
            System.out.println(lienFinal.getUrl());
            System.out.println(lienFinal.getTexte());
            
            scrolling(lien.positionLienXY(lienFinal));
            
            driver.get(lienFinal.getUrl());
            new WebDriverWait(driver, 1, 500);

            if (cpt == 0) {
            	hist.addLinkInHistorique(lienFinal);
            } else {
                visite = hist.TestPageDejaVisite(lienFinal);
                hist.addLinkInHistorique(lienFinal);
            }
            cpt++;
        } 
        MessageFinSiBoucle(hist.getPageDejaVisite().get(cpt-2));
    }

    /**
     * Navigation aléatoire
     */
    public void NavigationRandom() {
    	 
    	int cpt = 0;
          boolean visite = false;

          while(cpt <10 && visite != true) {

              //int max=0;
              //int mini=1;

              Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// recup tous les lien avec le tag "a"
              
              Lien lienFinal = alea.RecupLienAleatoire();

              System.out.println(lienFinal.getUrl());

              scrolling(lien.positionLienXY(lienFinal));
              driver.get(lienFinal.getUrl());
              
              new WebDriverWait(driver, 500);

              if (cpt == 0) {
            	  hist.addLinkInHistorique(lienFinal);
              } else {
                  visite = hist.TestPageDejaVisite(lienFinal);
                  hist.addLinkInHistorique(lienFinal);
              }
              cpt++;
          }
          MessageFinSiBoucle(hist.getPageDejaVisite().get(cpt-1));
    }
    
    /**
     * Affiche un message en fin de programme
     * @param lien
     */
    public void MessageFinSiBoucle(Lien lien) {
    	//JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé à déjà été visité !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(lien.getUrl());
    }
     
    /**
     * Ralenti le scroll de la page pour faire une navigation "humaine"
     * @param cord
     */
    public void scrolling(int cord){

        int y2 = 0;

        for (@SuppressWarnings("unused")
		int sec = 0;; sec++) 
        {

            if(y2+200 >= cord)
                break;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", ""); //y value '200' can be altered
            y2 += 200;
            new WebDriverWait(driver, 2);
        }
            new WebDriverWait(driver, 2);
    }

    /**
     * 
     * @param time
     * @throws InterruptedException
     */
    public void sleep(int time) throws InterruptedException{
            new WebDriverWait(driver, time);
    }

/*    public boolean dejaVisite(String url) {

        for(String tmp : visit) {
            if (tmp.equals(url)) {
                return true;
            }
        }
        return false;
    }*/

    /**
     * Arrête le Gecko Driver
     */
    public void close()
    {
        System.out.println("Closing gecko driver");
        driver.quit();
    }

}