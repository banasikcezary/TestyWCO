package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class RecordingTagsTest extends TestBase {
    @Test(priority = 2,
            description = "as User Try Edit Tags In Records",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryEditTagsInRecords() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("TestyQA");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsButton();
        recordingPage.clickTagsCheckbox();
        recordingPage.clickOnSaveEditTagsButton();
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsButton();
        recordingPage.validationEditTagsButton();


    }
}
