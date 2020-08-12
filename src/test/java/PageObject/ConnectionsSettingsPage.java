package PageObject;

import com.google.gson.internal.$Gson$Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectionsSettingsPage {

    @FindBy(xpath = "//*[@id=\"1591_edit_element\"]")
    WebElement editSettingsButton;
    @FindBy(id ="mat-radio-2")
    WebElement recordingVPABXConnections;
    @FindBy(id = "mat-radio-5")
    WebElement recordingConnections;
    @FindBy(id ="mat-radio-8" )
    WebElement disableOutgoingCalls;
    @FindBy(id = "mat-radio-11")
    WebElement recordingOutgoingCalls;
    @FindBy(id ="save-button")
    WebElement saveSettingsButton;


    private WebDriver driver;
    public ConnectionsSettingsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("click Into Edit Button")
    public void clickIntoEditButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editSettingsButton));
        editSettingsButton.click(); }

    @Step("click Into Agree Recording VPABX Connections")
    public void clickIntoToAgreeRecordingVPABXConnections(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingVPABXConnections));
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingVPABXConnections).click().perform();
        }

    @Step("click Into Agree Recording Connections")
    public void clickIntoToAgreeRecordingConnections(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingConnections));
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingConnections).click().perform();
        }

    public void clickIntoToAgreeDisableOutgoingCalls(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(disableOutgoingCalls));
        Actions actions = new Actions(driver);
        actions.moveToElement(disableOutgoingCalls).click().perform();
        }
    public void clickIntoToAgreeRecordingOutgoingCalls(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingOutgoingCalls));
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingOutgoingCalls).click().perform();
        }
    public void clickIntoSaveSettingsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveSettingsButton));
        saveSettingsButton.click();}



}
