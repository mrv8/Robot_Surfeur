package Application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface DriverSelenium {
	
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	List<String> visit = new ArrayList<String>();
	
	public void OpenPage(String url) throws InterruptedException;
	
	public void sleep(int time)throws InterruptedException;
	
	public void findHref() throws InterruptedException;
	
	public void scrolling(int cord) throws InterruptedException;
	
	public int findPosition(WebElement LinkChoice);
	
	public boolean dejaVisite(String url);
}
