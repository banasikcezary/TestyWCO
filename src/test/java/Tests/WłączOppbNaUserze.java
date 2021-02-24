package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class WłączOppbNaUserze extends TestBase{

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();


        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("KarolN");
        configuration.selectNewUser();
        configuration.switchOnOppbOnUser();

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();
    }
}
