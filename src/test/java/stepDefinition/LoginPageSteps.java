package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPageSteps {
    WebDriver driver;
    @Given("User in login page")
    public void user_in_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://dev.stv.amagi.tv/signin");
    }
    @When("User provides the {string} {string} {string}")
    public void user_provides_the(String string, String string2, String string3) {
        driver.findElement(By.id("email")).sendKeys("c-sohan.s@amagi.com");
        driver.findElement(By.id("domain_name")).sendKeys("amaginow");
        driver.findElement(By.id("password")).sendKeys("User@321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("Home page should be displayed")
    public void home_page_should_be_displayed() {
        boolean dashboardName = driver.findElement(By.xpath("//div[.='Dashboard']")).isDisplayed();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://amaginow.dev.stv.amagi.tv/now/dashboard";

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(dashboardName);
    }
    @Then("User click on Logout button")
    public void user_click_on_logout_button() {
    }
    @Then("Login page should be displayed")
    public void login_page_should_be_displayed() {
        driver.close();
        driver.quit();
    }
}
