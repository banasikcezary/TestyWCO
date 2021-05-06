package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class VerifyOneTimeStopRecording extends TestBase{

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();

        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnOneTimeOffRecordingOnUser();

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        driver.navigate().refresh();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.verifySwitchOnOneTimeOffRecordingOnUser();

//Call

        driver.navigate().refresh();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnOneTimeOffRecordingOnUser();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        driver.navigate().refresh();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.verifySwitchOffOneTimeOffRecordingOnUser();


        //Call
    }
}
