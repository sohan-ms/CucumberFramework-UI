package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPageRegression {
    WebDriver driver;
    ChromeOptions options;
    String expectedURL = "https://staging.now.amagi.tv/signin";
    @Given("Launch a browser")
    public void launch_a_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(expectedURL);

    }
    @When("Login page is displayed")
    public void login_page_is_displayed() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);

    }
    @Then("validate the Login page functionalities")
    public void validate_the_login_page_functionalities() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("c-sohan.s@amagi.com");
        driver.findElement(By.id("domain_name")).sendKeys("vod_demo_3");
        driver.findElement(By.id("password")).sendKeys("User@321");
        driver.findElement(By.xpath("//*[name()='svg' and @class = 'lan-MuiSvgIcon-root lan-lan31']")).click();
        driver.findElement(By.xpath("//input[@type='text' and @id='password']"));
        driver.findElement(By.xpath("//*[name()='svg' and @class = 'lan-MuiSvgIcon-root lan-lan31']")).click();
        driver.findElement(By.xpath("//input[@type='password' and @id='password']"));
        driver.findElement(By.xpath("//*[name()='svg' and @class='lan-lan29']")).click();
        driver.findElement(By.xpath("//*[name()='svg' and @data-testid='domainname-clear-icon']")).click();
        driver.findElement(By.xpath("//*[name()='svg']/ancestor::div[@class='lan-MuiInputAdornment-root lan-MuiInputAdornment-positionEnd']")).click();
        driver.close();
    }
}
