package navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

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

    /**
     * Méthode qui va venir récupérer l'url et initialiser le navigateur.
     * @param url
     */
    public void OpenPage(String url){
    	
        driver.get(url); //ouvre le navigateur avec l'url
        driver.manage().window().maximize(); //permet de mettre la fenetre en plein écran
        new WebDriverWait(driver, 200);
    }
    
    /**
     * Fonction qui va exécuter la navigation pondérée
     * @param motCles
     */
    public void NavigationScore(String[] motCles){
    	
        int cpt = 0;
        boolean PageDejaVisite = false;
        boolean ScoreDeLienQuiDiminue = false;
        
        for (String unMot : motCles) {
            motCle.add(unMot);
        }
        
        //Boucle tant que le lien choisi ne possède pas un score inférieur au précendent ou que ce soit une page déjà visitée
        while (PageDejaVisite != true && ScoreDeLienQuiDiminue != true)
        {
            pageCourante.clearLiens(); //Vide la liste de liens qui avait été récupérée pour la page précédente
             
            Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// récupére tous les liens avec le tag href
            
            /*
             * méthode qui permet de retirer de la liste des liens récupérés tous les liens présents dans l'historique.
             * Cela permet d'éviter de tomber sur un lien déjà visité.
             */
            if(cpt !=0) {
            	List<Lien> l = Page.getLiensDansLaPage();
            	for(int j=0; j< l.size();j++){
            		Lien lienPage = l.get(j);
            		for(Lien lienHistorisque : hist.getPageDejaVisite())
            			if(lienPage.getUrl().equals(lienHistorisque.getUrl())) {
            				Page.removeLiens(lienPage);
            		} 	
            	}
            }
            
            Lien lienFinal = score.points(Page.getLiensDansLaPage(), motCle); // appelle de la méthode scoring définie dans la classe Scoring qui va renvoyer le lien avec le score max
            
            System.out.println(lienFinal.getUrl());
            System.out.println(lienFinal.getTexte());
            System.out.println(lienFinal.getScore());
            
            scrolling(lien.positionLienXY(lienFinal)); //Scroll de la page jusqu'à l'emplacement du lien choisi.
            
            sleep(2000);
            
            lienFinal.click();
            driver.get(lienFinal.getUrl()); //Exécution du lien dans le navigateur.
            sleep(2000);
            
            if (cpt == 0) {
            	hist.addLinkInHistorique(lienFinal);//Ajout du lien dans l'historique de navigation
            } else {
            	PageDejaVisite = hist.TestPageDejaVisite(lienFinal);//Appelle de la méthode pour savoir si le lien choisi est présent dans l'historique
            	ScoreDeLienQuiDiminue = hist.TestScoreDiminue(lienFinal);//Appelle de la méthode pour savoir si le lien choisi possède un score inférieur
                hist.addLinkInHistorique(lienFinal);//Ajout du lien dans l'historique de navigation
            }
            cpt++;
        } 
        
        if(PageDejaVisite == true)
        	MessageFinSiBoucle(hist.getPageDejaVisite().get(cpt-2));//Appel du panneau d'affichage de fin de programme.
        else
        	MessageSiScoreInf(hist.getPageDejaVisite().get(cpt-2));//Appel du panneau d'affichage de fin de programme.
    }
    
    /**
     * Fonction qui va venir exécuter la navigation aléatoire
     */
    public void NavigationRandom() {
    	 
    	int cpt = 0;
          boolean visite = false;

          while(cpt <10 && visite != true) {

              int max=0;
              int mini=1;

              Lien.tocast(driver.findElements(By.xpath("//*[@href]")));// recupére tous les liens href de la page et les cast en Lien
              
              Lien lienFinal = alea.RecupLienAleatoire(); //Appelle de la fonction qui va récupérer un lien aléatoirement

              System.out.println(lienFinal.getUrl());

              scrolling(lien.positionLienXY(lienFinal)); //Scroll de la page jusqu'à l'emplacement du lien choisi.
              
              sleep(2000); 
              
              driver.get(lienFinal.getUrl()); //Exécution du lien dans le navigateur.
              
              sleep(2000);

              if (cpt == 0) {
            	  hist.addLinkInHistorique(lienFinal); //Ajout du lien dans l'historique de navigation
              } else {
                  visite = hist.TestPageDejaVisite(lienFinal); //Appelle de la méthode pour savoir si le lien choisi est présent dans l'historique
                  hist.addLinkInHistorique(lienFinal); //Ajout du lien dans l'historique de navigation
              }
              cpt++;
          }
          MessageFinSiBoucle(hist.getPageDejaVisite().get(cpt-2)); //Appel du panneau d'affichage de fin de programme.
    }
    
    /**
     * Affiche un message dans le cas ou le programme tombe sur une page avec un score inférieure à la page précédente
     * Dans ce cas le programme revient sur la page précédente
     * @param lien
     */
    public void MessageSiScoreInf(Lien lien) {
    	JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé possède un score inférieur donc on revient en arrière !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(lien.getUrl());
    }
    
    /**
     * Affiche un message dans le cas ou le programme tombe sur une page déjà visitée
     * Dans ce cas le programme revient sur la page précédente
     * @param lien
     */
    public void MessageFinSiBoucle(Lien lien) {
    	JOptionPane jop1 = new JOptionPane();
        JOptionPane.showMessageDialog(null, "La page trouvé à déjà été visiter, vous allez être redirigé sur la page précédente !", "Message de Fin", JOptionPane.INFORMATION_MESSAGE);
        driver.get(lien.getUrl());
    }
     
    /**
     * Ralenti le scroll de la page pour faire une navigation "humaine"
     * @param cord
     */
    public void scrolling(int cord){

        int y2 = 0;

        for (int sec = 0;; sec++) {

            if(y2+200 >= cord)
                break;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", ""); //y value '200' can be altered
            y2 += 200;
            sleep(700);
        }
            sleep(700);
    }
    
    /**
     * Fonction qui permet de faire des temps de pause dans l'excution de l'application
     * @param time
     */
    public void sleep(int time){
            new WebDriverWait(driver, time);
    }
    
    /**
     * Fonction qui va venir fermer le navigateur et arreter l'application
     */
    public void close() {

        System.out.println("Closing driver");
        driver.quit();
    }

}