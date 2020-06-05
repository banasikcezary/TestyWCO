package PageObject;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectionsSettingsPage {

    @FindBy(id = "37_edit_element")
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

    public void clickIntoEditButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(editSettingsButton));
        editSettingsButton.click(); }
    public void clickIntoToAgreeRecordingVPABXConnections(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(recordingVPABXConnections));
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingVPABXConnections).click().perform();
        }
    public void clickIntoToAgreeRecordingConnections(){
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingConnections).click().perform();
        }
    public void clickIntoToAgreeDisableOutgoingCalls(){
        Actions actions = new Actions(driver);
        actions.moveToElement(disableOutgoingCalls).click().perform();
        }
    public void clickIntoToAgreeRecordingOutgoingCalls(){
        Actions actions = new Actions(driver);
        actions.moveToElement(recordingOutgoingCalls).click().perform();
        }
    public void clickIntoSaveSettingsButton(){saveSettingsButton.click();}



}
