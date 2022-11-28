package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAddPlatforms {
    @Test
    public void AssetsList(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://staging.now.amagi.tv/signin");

        driver.findElement(By.id("email")).sendKeys("pruthvi.m@amagi.com");
        driver.findElement(By.id("domain_name")).sendKeys("vod_demo_3");
        driver.findElement(By.id("password")).sendKeys("Amagi@560076");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//div[@class='now-now17']/descendant::*[name()='svg']")).click();
//        driver.findElement(By.xpath("//div[.='On Demand']")).click();
        Actions ac = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//div[@class='now-now37'][normalize-space()='On Demand']"));
        ac.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[.='Platforms']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }
}
