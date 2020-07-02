package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    @FindBy(id = "telNumber")
    WebElement telNumber;
    @FindBy (id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement logIn;
    @FindBy(id = "logout_button")
    WebElement logoutButton;
    @FindBy(xpath = "/html/body/app-root/cookie-law/cookie-law-component/div/div/a")
    WebElement cooki;

    private WebDriver driver;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void typeIntoPhoneNumberField() { telNumber.sendKeys("503896452"); }
    public void typeIntoUsernameField() { username.sendKeys("u.user2"); }
    public void typeIntoPasswordField() {
        password.sendKeys("test");
        cooki.click();
}
public void typeIntoPasswordFieldFailed(){password.sendKeys("1");}
    public void clickIntoLogInButton() { logIn.click();}

    public void checkPositiveLoginToApp(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        assertEquals(logoutButton.getText(), "Wyloguj");}

    public void checkNegativeLoginToApp(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(logIn));
        assertEquals(logIn.getText(), "Zaloguj")

       ;}
    }


