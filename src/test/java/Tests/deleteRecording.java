package Tests;

        import PageObject.*;
        import PageObject.Dialog;
        import org.testng.annotations.Test;
        import testng.listeners.RetryAnalyzer;

        import java.awt.*;

public class deleteRecording extends TestBase {

    @Test(priority = 3,
            description ="as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteRecording() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("TestyQA");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        int quentity =recordingPage.validateQuantityReportBefore();
        recordingPage.deleteRecordingWithList();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        recordingPage.validateQuantityReportAfter(quentity);



    }

}
