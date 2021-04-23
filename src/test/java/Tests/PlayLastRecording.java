package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class PlayLastRecording extends TestBase{

    @Test(priority = 3,
            description ="as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDownloadRecording()   {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("1");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.clickPlayRecButton();
        recordingPage.operationAutorizationPlayRec("invalidPass");
        recordingPage.verifyWrongPasswordForRec();
        recordingPage.clickPlayRecButton();
        recordingPage.operationAutorizationPlayRec("123456");
        recordingPage.verifyPlayRecDialog();



    }
}
