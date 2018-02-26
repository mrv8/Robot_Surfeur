package Application;

import org.openqa.selenium.WebElement;

public interface DriverSelenium {

	
	public void OpenPage(String url) throws InterruptedException;
	
	public void sleep(int time)throws InterruptedException;
	
	public void findHref() throws InterruptedException;
	
	public void scrolling(int cord) throws InterruptedException;
	
	public int findPosition(WebElement LinkChoice);
	
	public boolean dejaVisite(String url);
}
