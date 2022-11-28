package tv.amagi.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement Email;
    @FindBy(id = "domain_name")
    private WebElement DomainName;
    @FindBy(id = "password")
    private WebElement Password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement SignInButton;
    @FindBy(xpath = "//div[.='FORGOT PASSWORD?']")
    private WebElement ForgotPassword;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement PasswordVisibility;

    public WebElement getEmail() {
        return Email;
    }

    public WebElement getDomainName() {
        return DomainName;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getSignInButton() {
        return SignInButton;
    }

    public WebElement getForgotPassword() {
        return ForgotPassword;
    }

    public WebElement getPasswordVisibility() {
        return PasswordVisibility;
    }

    public void loginToAmagiNow(String emailText, String domainText, String passwordText) {
        Email.sendKeys(emailText);
        DomainName.sendKeys(domainText);
        Password.sendKeys(passwordText);
        SignInButton.click();
    }
}
