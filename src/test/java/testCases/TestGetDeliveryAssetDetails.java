package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGetDeliveryAssetDetails {
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
        driver.findElement(By.xpath("//div[.='On Demand']")).click();
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[.='TICKET NO.']")));
        List<WebElement> transcodFail = driver.findElements(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[5]/div[1]/div[1]/div[2]"));
        List<WebElement> list1 = driver.findElements(By.xpath("//tbody/tr/td[2]/descendant::span[1]"));
        System.out.println(list1.size());
        for (int i = 0; i < list1.size(); i++) {
            WebElement fail = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[" + i + "]/div[1]/div[1]/div[2]"));
            
        }
        for (WebElement ls:
                transcodFail) {
            System.out.println(ls.getText());
        }


//      //table/tbody/tr/td[2]/div/span[1]

    }
}
