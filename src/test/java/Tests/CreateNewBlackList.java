package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class CreateNewBlackList extends TestBase{


    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList();
        configuration.completeNameAndDescription("BlackListaTest","DescBlackList");
        configuration.addNumberForBlackList("48333444333");
        configuration.clickOnButtonSaveBlackList();
        configuration.verifySaveBlackList("BlackListaTest");

        configuration.clickOnLinkActivationBlackList();
        configuration.clickOnActivationLastBlackList();

        configuration.verifyActivateBlacklist();
    }}

