package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    @FindBy(id = "telNumber")
    WebElement telNumber;
    @FindBy(id = "username")
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

    public void typeIntoPhoneNumberField(String phoneNumber) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(telNumber));
        telNumber.sendKeys(phoneNumber);
    }

    public void typeIntoUsernameField(String user) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
    }

    public void typeIntoPasswordField(String pass) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        cooki.click();
    }

    public void typeIntoPasswordFieldFailed(String passFail) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passFail);
    }

    public void clickIntoLogInButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(logIn));
        Actions actions = new Actions(driver);
        actions.moveToElement(logIn).click().build().perform();
        //   logIn.click();}
    }
        public void checkPositiveLoginToApp() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
            assertEquals(logoutButton.getText(), "Wyloguj");
        }

        public void checkNegativeLoginToApp() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(logIn));
            assertEquals(logIn.getText(), "Zaloguj");
        }
    }


