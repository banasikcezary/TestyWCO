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
        loginPage.typeIntoUsernameField("UserTest");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        recordingPage.downloadRecordingWithList();
        recordingPage.operationAutorization("password");

        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";

        recordingPage.waitForFileDownloaded( ".zip", 50,downloadDir);
        recordingPage.verifyDownloadFile(downloadDir);

    }



}
