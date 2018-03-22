package extraction;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * 
 * Classe Lien, un lien contient une url, un score, une position, un texte, et des coordonnées X et Y.
 *
 */
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
    
    /**
     * Constructeur
     * @param url
     * @param text
     * @param ptn
     * @param x
     * @param y
     * @param score
     */
    public Lien(String url, String text,  Point ptn , int x, int y, float score) {
        this.url = url;
        this.texte = text;
        this.position = ptn;
        this.Xcord = x;
        this.Ycord = y;
        Lien.score = score;
    }
    
    /**
     * Constructeur
     */
    public Lien() {	}

    /**
     * 
     * @param l
     */
	public static void tocast(List<WebElement> l) {
    	
    	for(WebElement unWebElement : l)
    	{
    		Lien unNouveauLien = new Lien(unWebElement.getAttribute("href"), unWebElement.getText(), unWebElement.getLocation(), 0, 0, 0);
    		Page.addLiens(unNouveauLien);
    	}
    }

	/**
	 * 
	 * @return
	 */
    public String getUrl(){
        return url;
    }
    
    /**
     * 
     * @return
     */
    public static double getScore(){
        return score;
    }
    
    /**
     * 
     * @return
     */
    public String getTexte() {
    	return texte;
    }
    
    /**
     * 
     * @return
     */
    public Point getPosition() {
    	return position;
    }
    
    /**
     * 
     * @param d
     */
    public static void setScore(double d) {
    	score = d;
    }
    
    /**
     * 
     * @return
     */
    public int getX() {
    	return Xcord;
    }
    
    /**
     * 
     * @param x
     */
    public void setX(int x) {
    	Xcord = x;
    }
    
    /**
     * 
     * @return
     */
    public int getY() {
    	return Xcord;
    }
    
    /**
     * 
     * @param y
     */
    public void setY(int y) {
    	Ycord = y;
    }
    
    /**
     * 
     * @param pt
     * @return
     */
    public  int positionLienXY(Lien pt) {
    	Xcord = pt.getX();
    	Ycord = pt.getY();
    	return Ycord;
    }
}