package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class VipListaNagrywajZKomunikatem extends TestBase {
    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();


        configuration.clickOnFunctionalitySettings();
        configuration.chooseSettingsVipList();
        configuration.addNumberToVipList("48333444332");
        configuration.setRecordingAndAnnouncement("48333444332");

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();


    }
}