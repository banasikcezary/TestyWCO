package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationAssignmentWhiteListForUser extends TestBase{


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
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList("Biała");
        configuration.completeNameAndDescriptionWhiteList("WhiteListaTest","DescWhiteList");
        configuration.addNumberForWhiteList("48333444333");
        configuration.clickOnButtonSaveWhiteList();
        configuration.verifySaveWhiteList("WhiteListaTest");
        configuration.clickOnLinkActivationWhiteList();
        configuration.clickOnActivationLastWhiteList();
        configuration.verifyActivateWhitelist();

        driver.navigate().refresh();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList("WhiteListaTest");
        configuration.clickOnGlobalWhiteList();
        configuration.clickOnButtonSaveWhiteList();
        configuration.verifyActivateGlobalWhitelist("WhiteListaTest");


    ////Call

        driver.navigate().refresh();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList("WhiteListaTest");
        configuration.clickOnGlobalWhiteList();
        configuration.clickOnButtonSaveWhiteList();
        configuration.verifyDeactivateGlobalWhitelist("WhiteListaTest");

        /// Call

        driver.navigate().refresh();
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("Pio");
        configuration.selectNewUser();
        configuration.addWhiteListOnUser("Pio","WhiteListaTest");

        driver.navigate().refresh();
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("BlackListaTest");
        configuration.clickOnButtonDeleteBlackList();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        configuration.verifyDeleteBlackList("BlackListaTest");

        driver.navigate().refresh();
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList("WhiteListaTest");
        configuration.clickOnButtonDeleteWhiteList();
        dialog.clickOnConfirmButton();
        configuration.verifyDeleteWhiteList("WhiteListaTest");



    }
}
