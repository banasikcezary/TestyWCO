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
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
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


        configuration.verifySaveBlackList();


        configuration.clickOnLinkActivationBlackList();
        configuration.clickOnActivationLastBlackList();


        configuration.verifyActivateBlacklist();

    }}

