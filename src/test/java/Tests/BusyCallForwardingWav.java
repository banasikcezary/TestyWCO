package Tests;

import PageObject.*;

import PageObject.Dialog;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class BusyCallForwardingWav extends TestBase{


    @Test(priority = 3,
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

        configuration.clickLinkUserList();
     configuration.typeIntoUserSearchField("KarolN");
        configuration.selectNewUser();

        configuration.setBusyForwardingWav("src/test/java/resources/sample.wav");

        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        configuration.verifyBusyForwardingWav("KarolN");

    }
}
