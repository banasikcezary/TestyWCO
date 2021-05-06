package Tests;

import PageObject.*;
import PageObject.Dialog;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class UserStatusCheck extends TestBase{

    @Test(priority = 3,
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







        String user1="xoxo";

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();

        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField(user1);
        configuration.selectNewUser();

     Dialog dialog=new Dialog(driver);
        configuration.selectStatusActive();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        configuration.clickLinkUserList();

        configuration.typeIntoUserSearchField(user1);
        configuration.selectNewUser();
        configuration.checkActualStatus("Aktywny");

        ////Call


        configuration.selectStatusDeactive();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        configuration.clickLinkUserList();

        configuration.typeIntoUserSearchField(user1);
        configuration.selectNewUser();
        configuration.checkActualStatus("Nieaktywny");

        ////Call

        configuration.selectStatusSuspended();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        configuration.clickLinkUserList();

        configuration.typeIntoUserSearchField(user1);
        configuration.selectNewUser();
        configuration.checkActualStatus("Zawieszony");

        ////Call






    }
}
