package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Dialog {

    @FindBy(id = "close_dialog")
    WebElement acceptPopupButton;
    @FindBy(id = "save-button")
    WebElement confirmButton;

    @FindBy(xpath = "(//*[contains(@class,\"alert alert-warning alert-dismissible fade show\")])")
    WebElement alert;


    private WebDriver driver;

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

    public void refreshPage(){
        driver.navigate().refresh();

    }
    public void clickOnConfirmButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public void verifyAlertBeforeLogin(String message) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(alert));
        String text= alert.getText();

        if (text.equals(message)) {
            System.out.println("Poprawny komunikat");
        } else {
            throw new IllegalArgumentException("Niepoprawny komunikat");
        }
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
