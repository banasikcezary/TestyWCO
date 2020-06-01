package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "telNumber")
    WebElement telNumber;
    @FindBy (id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "/html/body/app-root/app-login-page/div/form/button")
    WebElement logIn;

    private WebDriver driver;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void typeIntoPhoneNumberField() { telNumber.sendKeys("502369741"); }
    public void typeIntoUsernameField() { username.sendKeys("jan.nowak"); }
    public void typeIntoPasswordField() {
        password.sendKeys("User12345!@#");
}
public void typeIntoPasswordFieldFailed(){password.sendKeys("1");}
    public void clickIntoLogInButton() { logIn.click();


    }

}
