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
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.chooseLastRecordingWithList();
        int quentity =recordingPage.validateQuantityReportBefore();
        recordingPage.deleteRecordingWithList();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        dialog.confirmPopup();

        recordingPage.validateQuantityReportAfter(quentity);



    }

}
