package stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContentSteps {
    WebDriver driver;
    @Given("navigate to the Media Library - content tab")
    public void navigate_to_the_media_library_content_tab() {
        Actions ac = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//div[.='Content']"));
        ac.moveToElement(element).perform();
    }
    @Then("collect the assets list")
    public void collect_the_assets_list() {

    }

}
