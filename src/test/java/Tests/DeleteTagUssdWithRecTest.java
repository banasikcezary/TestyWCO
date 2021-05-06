package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class DeleteTagUssdWithRecTest extends TestBase {

    @Test(priority = 3,
            description = "as User Try Edit Tags In Records",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryEditTagsInRecords() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM2");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsUssdButton();
        recordingPage.validationAddTagForRec();

        recordingPage.clickOnEditTagsUssdButton();
        recordingPage.clickTagsCheckbox();
        recordingPage.clickOnSaveEditTagsButton();
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsUssdButton();
        recordingPage.validationDeleteTagRec();


    }
}
