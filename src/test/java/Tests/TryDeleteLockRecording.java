package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.RecordingPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class TryDeleteLockRecording extends TestBase {

    @Test(priority = 3,
            description ="as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteRecording() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);

        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        recordingPage.lockRecordingWithList();
        recordingPage.validationLock();


        driver.navigate().refresh();
        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        String quentity =recordingPage.validateQuantityReportBefore();
        recordingPage.trydDeleteRecordingWithList();
        recordingPage.verifyTooltipNotAllowedDeleteRec("Usunąć można jedynie nagrania, które nie są zablokowane(nie mają założonej kłódki)");

        recordingPage.validateQuantityReportNotValid(quentity);



    }
}
