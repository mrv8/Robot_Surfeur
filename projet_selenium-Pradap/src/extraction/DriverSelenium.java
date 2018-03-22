package extraction;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface DriverSelenium {
    WebDriver driver = new FirefoxDriver();
    JavascriptExecutor js = (JavascriptExecutor)driver;

    ArrayList<String> visit = new ArrayList<String>();
    ArrayList<String> motCle = new ArrayList<String>();

    public void OpenPage(String url) throws InterruptedException;

    public void sleep(int time)throws InterruptedException;

   /* public void findHref() throws InterruptedException;

    public void findHref(String [] motCles) throws InterruptedException;*/

    public void scrolling(int cord) throws InterruptedException;

    public int findPosition(Lien LinkChoice);

    public boolean dejaVisite(String url);

	public void NavigationScore(String[] motCles);
}
