package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tv.amagi.POMRepository.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLoginToAmagiNow {
    public WebDriver driver;
    LoginPage lp = new LoginPage(driver);

    @Test
    public void login() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36
//        String user_agent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36";
//        options.addArguments(user_agent);
        options.setHeadless(true);
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://dev.stv.amagi.tv/signin");

        driver.findElement(By.id("email")).sendKeys("c-sohan.s@amagi.com");
        driver.findElement(By.id("domain_name")).sendKeys("amaginow");
        driver.findElement(By.id("password")).sendKeys("User@321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        boolean dashboardName = driver.findElement(By.xpath("//div[.='Dashboard']")).isDisplayed();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://amaginow.dev.stv.amagi.tv/now/dashboard";

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(dashboardName);
        driver.close();
    }
}
