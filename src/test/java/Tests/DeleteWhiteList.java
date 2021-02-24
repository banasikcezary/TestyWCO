package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class DeleteWhiteList extends TestBase {



    @Test(priority = 4,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();

        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList();
        configuration.clickOnButtonDeleteWhiteList();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        configuration.verifyDeleteWhiteList();



    }
}
