package navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import extraction.DriverSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import extraction.Lien;
import extraction.Page;

import org.openqa.selenium.support.ui.WebDriverWait;
import scoring.*;
import extraction.Lien;
import navigation.*;


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

    
    public void OpenPage(String url){
    	
    	
        driver.get(url); //ouvre le navigateur avec l'url passé en parametre
        driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran
        new WebDriverWait(driver, 2);
    }

    public void NavigationScore(String[] motCles){
    	
        int cpt = 0;
        boolean PageDejaVisite = false;
        boolean ScoreDeLienQuiDiminue = false;
        
        for (String unMot : motCles) {
            motCle.add(unMot);
        }

        while (PageDejaVisite != true && ScoreDeLienQuiDiminue != true)
        {
        	
            pageCourante.clearLiens();
             
            Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// recup tous les lien avec le tag "a"

             Lien lienFinal = score.points(Page.getLiensDansLaPage(), motCle); // appelle de la fonction qui va scorer les liens entre 0 et 1
            
            System.out.println(lienFinal.getUrl());
            System.out.println(lienFinal.getTexte());
            System.out.println(lienFinal.getScore());
            
            scrolling(lien.positionLienXY(lienFinal));
            lienFinal.click();
            driver.get(lienFinal.getUrl());
            
            sleep(500);

            if (cpt == 0) {
            	hist.addLinkInHistorique(lienFinal);
            } else {
            	PageDejaVisite = hist.TestPageDejaVisite(lienFinal);
            	ScoreDeLienQuiDiminue = hist.TestScoreDiminue(lienFinal);
                hist.addLinkInHistorique(lienFinal);
            }
            cpt++;
        } 
        if(PageDejaVisite == true)
        	MessageFinSiBoucle(hist.getPageDejaVisite().get(cpt-2));
        else
        	MessageSiScoreInf(hist.getPageDejaVisite().get(cpt-2));
    }

    public void NavigationRandom() {
    	 
    	int cpt = 0;
          boolean visite = false;

          while(cpt <10 && visite != true) {

              int max=0;
              int mini=1;

              Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// recup tous les lien avec le tag "a"
              
              Lien lienFinal = alea.RecupLienAleatoire();

              System.out.println(lienFinal.getUrl());

              scrolling(lien.positionLienXY(lienFinal));
              driver.get(lienFinal.getUrl());
              
              sleep(500);

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
    
    public void MessageSiScoreInf(Lien lien) {
    	JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé possède un score inférieur donc on revient en arrière !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(lien.getUrl());
    }
    public void MessageFinSiBoucle(Lien lien) {
    	JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé à déjà été visiter, vous allez être redirigé sur la page précédente !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(lien.getUrl());
    }
     
    public void scrolling(int cord){

        int y2 = 0;

        for (int sec = 0;; sec++) {

            if(y2+200 >= cord)
                break;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", ""); //y value '200' can be altered
            y2 += 200;
            sleep(150);
        }
            sleep(100);
    }

    public void sleep(int time){
            new WebDriverWait(driver, time);
    }

    public void close() {

        System.out.println("Closing driver");
        driver.quit();
    }

}