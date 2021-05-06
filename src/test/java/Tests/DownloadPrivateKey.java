package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import PageObject.RecordingPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class DownloadPrivateKey extends TestBase{

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


        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.clickButtonDownloadPrivateKey();

        RecordingPage recordingPage=new RecordingPage(driver);
        recordingPage.operationAutorization("wrongPas");
        recordingPage.verifyWrongPassword();
        configuration.clickButtonDownloadPrivateKey();
        recordingPage.operationAutorization("123456");
        UserList userList=new UserList(driver);
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";

        userList.waitForFileDownloaded( "key", 50,downloadDir);
        userList.verifyDownloadFile(downloadDir,"key");







    }
}
