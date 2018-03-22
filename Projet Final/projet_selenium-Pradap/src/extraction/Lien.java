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

public class Lien implements WebElement{

    private String url;
    private double score;
    private Point position;
    private String texte;
    private int Xcord;
    private int Ycord;

    /**
     * Construceur d'un lien
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
        this.score = score;
    }
    
    /**
     * Constructeur vide
     */
    public Lien() {	}
    
    /**
     * Méthode de cast un lien de type WebElement en lien.
     * @param listLiensRecupDansLaPage
     */
	public static void tocast(List<WebElement> listLiensRecupDansLaPage) {
    	
    	for(WebElement unWebElement : listLiensRecupDansLaPage)
    	{
    		Lien unNouveauLien = new Lien(unWebElement.getAttribute("href"), unWebElement.getText(), unWebElement.getLocation(), 0, 0, 0);
    		Page.addLiens(unNouveauLien);
    	}
    }
	
	/**
	 * Getter de l'url du lien
	 * @return String
	 */
    public String getUrl(){
        return url;
    }

    /**
     * Getter du score du lien
     * @return double
     */
    public double getScore(){
        return score;
    }
    
    /**
     * Getter du texte du lien
     * @return String
     */
    public String getTexte() {
    	return texte;
    }
    
    /**
     * Getter de la position du lien
     * @return Point
     */
    public Point getPosition() {
    	return position;
    }
    
    /**
     * Setter du score
     * @param d
     */
    public void setScore(double d) {
    	score = d;
    }
    
    /**
     * Getter de la coordonée X du lien
     * @return int
     */
    public int getX() {
    	return Xcord;
    }
    
    /**
     * Setter de la coordonnée X
     * @param x
     */
    public void setX(int x) {
    	Xcord = x;
    }
    
    /**
     * Getter de la coordonnée Y du lien
     * @return int
     */
    public int getY() {
    	return Xcord;
    }
    
    /**
     * Setter De la coordonnée Y
     * @param y
     */
    public void setY(int y) {
    	Ycord = y;
    }
    
    /**
     * Renseigne la position X et Y du lien d'après les coordonées Point du lien
     * @param pt
     * @return int
     */
    public  int positionLienXY(Lien pt) {
    	Point pos = pt.getPosition();
    	Xcord = pos.getX();
    	Ycord = pos.getY();
    	System.out.println(Ycord);
    	return Ycord;
    }

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
}