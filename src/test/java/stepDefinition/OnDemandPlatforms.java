package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class OnDemandPlatforms {
    WebDriver driver;
    @Given("admin user navigates to On Demand platform page")
    public void admin_user_navigates_to_on_demand_platform_page() {
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
        Actions ac = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//div[@class='now-now37'][normalize-space()='On Demand']"));
        ac.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[.='Platforms']")).click();
    }
    @When("Platform page is displayed")
    public void platform_page_is_displayed() {
        String currentUrl = driver.getCurrentUrl();
        String actualUrl = "https://vod_demo_3.staging.now.amagi.tv/now/on-demand/platforms";
        SoftAssert as = new SoftAssert();
        as.assertEquals(currentUrl, actualUrl);
    }
    @Then("validate ADD PLATFORM button functionality")
    public void validate_add_platform_button_functionality() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//span[.='Select Platform']")).isDisplayed();
        driver.findElement(By.xpath("//div[.='Back' and @class='vod-vod117']")).click();

    }
    @Then("validate Search by platform\\/region")
    public void validate_search_by_platform_region() {
    }
    @Then("get list of platforms added")
    public void get_list_of_platforms_added() {
    }
    @Then("validate the no of platforms matching to the list of platforms")
    public void validate_the_no_of_platforms_matching_to_the_list_of_platforms() {
    }
}
