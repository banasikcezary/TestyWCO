package Tests;

import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class downloadRecording extends TestBase{

    @Test(priority = 3,
            description ="as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDownloadRecording() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("1");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        recordingPage.downloadRecordingWithList();
        recordingPage.operationAutorization("wrongPas");
        recordingPage.verifyWrongPassword();
        recordingPage.downloadRecordingWithList();
        recordingPage.operationAutorization("123456");
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";

        recordingPage.waitForFileDownloaded( ".zip", 50,downloadDir);
        recordingPage.verifyDownloadFile(downloadDir);

    }



}
