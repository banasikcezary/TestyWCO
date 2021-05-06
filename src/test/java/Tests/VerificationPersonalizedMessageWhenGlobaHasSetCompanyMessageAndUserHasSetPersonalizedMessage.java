package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class VerificationPersonalizedMessageWhenGlobaHasSetCompanyMessageAndUserHasSetPersonalizedMessage extends TestBase {

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


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.setIncomingCompanyMessage("ciekawyTTs");
        configuration.clickSaveButton();
        PageObject.Dialog dialog = new Dialog(driver);
        dialog.confirmPopup();
        configuration.verifyIncomingCompanyMessage();



        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.setPersonalizedMessageForUserIncomingCalls("ciekawyTTs", "InterestingTTs");
        configuration.clickSaveButton();
        dialog.confirmPopup();
        configuration.verifyPersonalizedMessageForUserIncomingCalls();
    }
}
