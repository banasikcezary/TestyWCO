package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CreateNewWhiteList extends TestBase{


    @Test(priority = 1,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewWhiteList()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewWhiteListFunctionalities();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList();
        configuration.completeNameAndDescriptionWhiteList("WhiteListaTest","DescBlackList");
        configuration.addNumberForWhiteList("48333444333");
        configuration.clickOnButtonSaveWhiteList();
        configuration.clickOnLinkActivationWhiteList();
        configuration.clickOnActivationLastWhiteList();

        configuration.verifySaveWhiteList();
        configuration.verifyActivateWhitelist();


    }
}
