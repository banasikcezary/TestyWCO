package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class FilteringPhoneCallsByIsRec extends TestBase{


    @Test(priority = 3,
            description = "as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryFilteringRecordingByType() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnPhoneCallsTab();
        recordingPage.selectAllColumns();

        recordingPage.filterPhoneCallsByIsRecording();
        recordingPage.validationCallsPhoneIsRec();

    }
}
