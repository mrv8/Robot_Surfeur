package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class main {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\FirefoxDrive\\geckodriver.exe");
		String url = "https://fr.wikipedia.org/wiki/Cheval";

		NavigationRandom NR = new NavigationRandom();
		NR.OpenPage(url);
		NR.findHref();
		
	}
}