package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PlatformSteps {
    WebDriver driver;
    @Given("User will log in to amagi now")
    public void user_will_log_in_to_amagi_now() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://staging.now.amagi.tv/signin");
        driver.findElement(By.id("email")).sendKeys("pruthvi.m@amagi.com");
        driver.findElement(By.id("domain_name")).sendKeys("vod_demo_3");
        driver.findElement(By.id("password")).sendKeys("Amagi@560076");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean bn = driver.findElement(By.xpath("//*[name()='svg' and @class='now-now19']")).isDisplayed();
        driver.findElement(By.xpath("//*[name()='svg' and @class='now-now19']")).click();
    }
    @Given("click on On Demand-platform page")
    public void click_on_on_demand_platform_page() {
        Actions ac = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//div[.='On Demand' and @class='now-now31']"));
        ac.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[.='Platforms']")).click();
    }
    @Then("validate the platform page")
    public void validate_the_platform_page() {
        String actualURL = "https://vod_demo_3.staging.now.amagi.tv/now/on-demand/platforms";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, currentURL);
        List<WebElement> pfList = driver.findElements(By.xpath("//table/tbody/tr/td[@class='vod-vod60 vod-vod74']"));
        for ( WebElement pf: pfList
             ) {
            System.out.println(pf);
        }
        driver.close();
    }
}
