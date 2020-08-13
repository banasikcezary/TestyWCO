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
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
//        recordingPage.clickOnButtonfilterCriteria();
//        recordingPage.clickOnButtonFilterNumber();
//        recordingPage.typeIntoFilterNumberField();
//        recordingPage.clickOnFilterButton();
        recordingPage.clickOnEditTagsButton();
        recordingPage.typeIntoEditTagsField("test");
        recordingPage.clickOnSaveEditTagsButton();


    }
}
