package navigation;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class NavigationMoteur {
    public NavigationMoteur(String key_word){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sitha\\Documents\\MIAGE\\Projet\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(" http://www.google.fr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(key_word+"\n");
        new WebDriverWait(driver, 10)
                .until(d -> d.getTitle().toLowerCase().startsWith(key_word));
        //element = driver.findElement(By.linkText("wikipedia"));

        System.out.println("Title: " + driver.getTitle());
    }
    public static void main(String[] args) /* throws  InterruptedException*/ {
       /* System.setProperty("webdriver.gecko.driver", "C:\\Users\\sitha\\Documents\\MIAGE\\Projet\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(" http://www.google.fr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheval\n");
        new WebDriverWait(driver, 10)
                .until(d -> d.getTitle().toLowerCase().startsWith("cheval"));
        //element = driver.findElement(By.linkText("wikipedia"));

        System.out.println("Title: " + driver.getTitle());*/
        //driver.quit();*/

    }

}
