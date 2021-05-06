package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage {

    @FindBy(id = "telNumber")
    WebElement telNumber;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(css = "[type=\"submit\"]")
    WebElement logIn;
    @FindBy(id = "logout_button")
    WebElement logoutButton;
    @FindBy(xpath = "/html/body/app-root/cookie-law/cookie-law-component/div/div/a")
    private List<WebElement> cooki;

    @FindBy(id = "change_password")
    WebElement lnkChangePass;
    @FindBy(css = "[formcontrolname=\"old_password\"]")
    WebElement txtOldPass;
    @FindBy(css = "[formcontrolname=\"password\"]")
    WebElement txtPass;
    @FindBy(css = "[formcontrolname=\"password_repeat\"]")
    WebElement txtRepeatPass;
    @FindBy(id = "change_password_button")
    WebElement btnChangePass;
    @FindBy(css = "[class=\"text-danger\"]")
    List<WebElement> txtValidationChangePass;


    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("typeIntoPhoneNumberField")

    public void typeIntoPhoneNumberField(String phoneNumber) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(telNumber));
        telNumber.sendKeys(phoneNumber);
        System.out.println("phone");

    }
    @Step("typeIntoUsernameField")

    public void typeIntoUsernameField(String user) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);

        System.out.println("user");

    }
    @Step("typeIntoPasswordField")

    public void typeIntoPasswordField(String pass) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        System.out.println("pass");

        if(!cooki.isEmpty()) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(cooki.get(0)));
            cooki.get(0).click();
        }else{
            System.out.println("cooki not displayed");
        }
    }
    @Step("typeIntoPasswordFieldFailed")

    public void typeIntoPasswordFieldFailed(String passFail) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passFail);

        System.out.println("pass");

    }
    @Step("clickIntoLogInButton")

    public void clickIntoLogInButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
       logIn.click();
       List<WebElement> elementList=driver.findElements(By.id("audit_log_link"));
      if(elementList.isEmpty()){
          logIn.click();
      }

        System.out.println("click login");

    }
    public void verifyLogoutAfterTime() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 300);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logIn));
        logIn.isDisplayed();


    }
    @Step("checkPositiveLoginToApp")

    public void checkPositiveLoginToApp() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
           // assertEquals(logoutButton.getText(), "Wyloguj");
        }

public void changePasswordUser(String oldPassword, String password, String passwordRepeat){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkChangePass));
    lnkChangePass.click();
    List<WebElement> elements=driver.findElements(By.cssSelector("[formcontrolname=\"old_password\"]"));
    if(elements.isEmpty()){
        lnkChangePass.click();

    }

    webDriverWait.until(ExpectedConditions.visibilityOf(txtOldPass));
    txtOldPass.clear();
    txtOldPass.sendKeys(oldPassword);

    webDriverWait.until(ExpectedConditions.visibilityOf(txtPass));
    txtPass.clear();
    txtPass.sendKeys(password);

    webDriverWait.until(ExpectedConditions.visibilityOf(txtRepeatPass));
    txtRepeatPass.clear();
    txtRepeatPass.sendKeys(passwordRepeat);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(btnChangePass));
    btnChangePass.click();

}

public void validationChangePasswordWrongNewValue(){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.visibilityOfAllElements(txtValidationChangePass));
    System.out.println(txtValidationChangePass.get(0).getText());
    System.out.println(txtValidationChangePass.get(1).getText());
    assertTrue(txtValidationChangePass.get(0).getText().equals("warning Hasło musi składać z 12 znaków, w tym małej i dużej litery, cyfry oraz znaku: #?!@$%^&*-"));
    assertTrue(txtValidationChangePass.get(1).getText().equals("warning Hasło nie jest takie samo jak powyżej"));

}


public void clickOnLogoutButton(){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
    webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    Actions actions=new Actions(driver);
    logoutButton.isDisplayed();
    actions.moveToElement(logoutButton).click().build().perform();
    if(logoutButton.isDisplayed()){
        actions.moveToElement(logoutButton).click().build().perform();
    }

}


    @Step("checkNegativeLoginToApp")

        public void checkNegativeLoginToApp() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());

        try {
            Alert alert = driver.switchTo().alert();
           String text= alert.getText();
            alert.accept();

            assertEquals(text, "Nie udało się zalogować");

        } catch(UnhandledAlertException noe) {
            // No alert found on page, proceed with test.
        }

        }
    }


