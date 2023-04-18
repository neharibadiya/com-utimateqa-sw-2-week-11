package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void  userShouldNavigateToLoginPageSuccessfully(){
        //click on sign in link
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();
        //verify the text 'Welcome Back!'
        String expectedTextDisplay = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("Text is Display", expectedTextDisplay, actualTextDisplay);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on sign in link
        WebElement signLink = driver.findElement(By.linkText("Sign In"));
        signLink.click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("gautampatel@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("gautamGP123");
        //click on sign in button
        WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signinBtn.click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message is displayed", expectedMessage, actualMessage);
    }
//    @After
//    public void tearDown(){
//        closeBrowser();
//    }
}
