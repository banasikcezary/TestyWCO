package PageObject;

import io.qameta.allure.Step;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Dialog {

    @FindBy(id = "close_dialog")
    WebElement acceptPopupButton;
    @FindBy(id = "save-button")
    WebElement confirmButton;

    @FindBy(xpath = "(//*[contains(@class,\"alert alert-warning alert-dismissible fade show\")])")
    WebElement alert;
    @FindBy(xpath = "(//*[@class=\"mat-dialog-content\"])/div/button[1]")
    WebElement continuePurchasing;
@FindBy(css = "div.mat-dialog-actions>button:nth-of-type(2)>span")
WebElement confirmGenerateKey;
@FindBy(xpath = "(//mat-dialog-container[contains(@id,\"mat-dialog\")])")
WebElement confirmText;

@FindBy(id = "sms")
WebElement txtSms;
@FindBy(css = "[type=\"submit\"]")
WebElement btnSubmitSms;
@FindBy(css = "p.ng-star-inserted")
private WebElement warningMessageSms;

    public WebDriver driver;

    public Dialog(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickOnAcceptPopupButton")

    public void clickOnAcceptPopupButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptPopupButton));
        acceptPopupButton.click();
    }
    public void confirmSms(String smsKey) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtSms));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSubmitSms));
        btnSubmitSms.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(warningMessageSms));

        if(warningMessageSms.isDisplayed()){
            assertEquals(warningMessageSms.getText(),"Niepoprawny sms kod");

        }else {
            throw new IllegalArgumentException( "Nie znaleziono ostrzegającego komunikatu po wpisaniu niepoprawnej wartości");
        }
        txtSms.clear();
        txtSms.sendKeys(smsKey);
        btnSubmitSms.click();



    }
    public void confirmPopup(){
        Actions actions=new Actions(driver);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(confirmText));
            confirmText.isDisplayed();
            System.out.println(confirmText.getText());

            actions.sendKeys(Keys.ESCAPE).perform();
           // driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(confirmText));
            confirmText.isDisplayed();
            System.out.println(confirmText.getText());
            actions.sendKeys(Keys.ESCAPE).perform();
            // driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
        }

    }

    public void refreshPage(){
        driver.navigate().refresh();

    }
    public void clickOnConfirmButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }
    public void clickOnContinuePurchasing() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continuePurchasing));
        continuePurchasing.click();
    }
    public void clickOnContinueGenerateKey() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(confirmGenerateKey));
        confirmGenerateKey.click();
Actions actions=new Actions(driver);
        try {
            actions.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(confirmText))).perform();
            confirmText.isDisplayed();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            actions.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(confirmText))).perform();
            confirmText.isDisplayed();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
        }




    }

    public void verifyAlertBeforeLogin(String message) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(alert));
        String text= alert.getText();

        assertEquals(text,message);

    }
    public void verifyAlertAfterLogin(String message) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(alert));
        String text= alert.getText();

        if (text.equals(message)) {
            System.out.println("Poprawny komunikat");
        } else {
            throw new IllegalArgumentException("Niepoprawny komunikat");
        }
    }
}
