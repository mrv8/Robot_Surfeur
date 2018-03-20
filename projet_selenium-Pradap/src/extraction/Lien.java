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

    public double getScore(){
        return score;
    }
    
    public String getTexte() {
    	return texte;
    }
    
    public Point getPosition() {
    	return position;
    }
    
    public void setScore(double d) {
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