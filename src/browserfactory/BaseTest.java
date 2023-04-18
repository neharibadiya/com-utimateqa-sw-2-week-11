package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl = "https://courses.ultimateqa.com/";
    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();
        //launch the URL
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
