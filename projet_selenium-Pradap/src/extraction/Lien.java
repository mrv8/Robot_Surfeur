package extraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Lien {

    private String url;
    private static double score;
    private Point position;
    private String texte;
    private int Xcord;
    private int Ycord;

   /* public Lien() {
        this.AllLinks =  new ArrayList<WebElement>();
    }*/
    
    public Lien(String url, String text,  Point ptn , int x, int y, float score) {
        this.url = url;
        this.texte = text;
        this.position = ptn;
        this.Xcord = x;
        this.Ycord = y;
        this.score = score;
    }
    
    public Lien() {	}

	public static void tocast(List<WebElement> l) {
    	
    	for(WebElement unWebElement : l)
    	{
    		Lien unNouveauLien = new Lien(unWebElement.getAttribute("href"), unWebElement.getText(), unWebElement.getLocation(), 0, 0, 0);
    		Page.addLiens(unNouveauLien);
    	}
    }

    public String getUrl(){
        return url;
    }

    public static double getScore(){
        return score;
    }
    
    public String getTexte() {
    	return texte;
    }
    
    public Point getPosition() {
    	return position;
    }
    
    public static void setScore(double d) {
    	score = d;
    }
    
    public int getX() {
    	return Xcord;
    }
    
    public void setX(int x) {
    	Xcord = x;
    }
    
    public int getY() {
    	return Xcord;
    }
    
    public void setY(int y) {
    	Ycord = y;
    }
    public  int positionLienXY(Lien pt) {
    	Xcord = pt.getX();
    	Ycord = pt.getY();
    	return Ycord;
    }
}