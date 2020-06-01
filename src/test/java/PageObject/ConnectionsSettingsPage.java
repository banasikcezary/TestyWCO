package PageObject;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectionsSettingsPage {

    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-users-list/div/mat-table/div/div/div/div[1]/button/span")
    WebElement editSettingsButton;
    @FindBy(xpath ="//*[@id=\"mat-radio-2\"]/label/div[1]/div[1]\n")
    WebElement recordingVPABXConnections;
    @FindBy(xpath = "//*[@id=\"mat-radio-5\"]/label/div[1]/div[1]\n")
    WebElement recordingConnections;
    @FindBy(xpath ="//*[@id=\"mat-radio-8\"]/label/div[1]/div[1]\n" )
    WebElement disableOutgoingCalls;
    @FindBy(xpath = "//*[@id=\"mat-radio-11\"]/label/div[1]/div[1]\n")
    WebElement recordingOutgoingCalls;
    @FindBy(xpath ="//*[@id=\"mat-dialog-0\"]/app-edit-user-dialog/div/div/mat-dialog-actions/button[2]\n")
    WebElement saveSettingsButton;


    private WebDriver driver;
    public ConnectionsSettingsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickIntoEditButton() { editSettingsButton.click(); }
    public void clickIntoToAgreeRecordingVPABXConnections(){recordingVPABXConnections.click();}
    public void clickIntoToAgreeRecordingConnections(){recordingConnections.click();}
    public void clickIntoToAgreeDisableOutgoingCalls(){disableOutgoingCalls.click();}
    public void clickIntoToAgreeRecordingOutgoingCalls(){recordingOutgoingCalls.click();}
    public void clickIntoSaveSettingsButton(){saveSettingsButton.click();}



}
