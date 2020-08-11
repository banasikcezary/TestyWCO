package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class RecordingTagsTest extends TestBase {
    @Test(priority = 2)
    public void asUserTryEditTagsInRecords() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
//        recordingPage.clickOnButtonfilterCriteria();
//        recordingPage.clickOnButtonFilterNumber();
//        recordingPage.typeIntoFilterNumberField();
//        recordingPage.clickOnFilterButton();
        recordingPage.clickOnEditTagsButton();
        recordingPage.typeIntoEditTagsField();
        recordingPage.clickOnSaveEditTagsButton();





    }
}
