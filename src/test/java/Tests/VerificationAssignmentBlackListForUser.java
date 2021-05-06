package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationAssignmentBlackListForUser extends TestBase{


    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("Czarna");
        configuration.completeNameAndDescription("BlackListaTest","DescBlackList");
        configuration.addNumberForBlackList("48333444333");
        configuration.clickOnButtonSaveBlackList();
        configuration.verifySaveBlackList("BlackListaTest");

        configuration.clickOnLinkActivationBlackList();
        configuration.clickOnActivationLastBlackList();

        configuration.verifyActivateBlacklist();

        driver.navigate().refresh();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("BlackListaTest");
        configuration.clickOnGlobalBlackList();
        configuration.clickOnButtonSaveBlackList();

        configuration.verifyActivateGlobalBlacklist("BlackListaTest");

        driver.navigate().refresh();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("BlackListaTest");
        configuration.clickOnGlobalBlackList();
        configuration.clickOnButtonSaveBlackList();


        configuration.verifyDeactivateGlobalBlacklist("BlackListaTest");

        driver.navigate().refresh();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("Pio");
        configuration.selectNewUser();
        configuration.addBlackListOnUser("Pio","BlackListaTest");


    }
}
