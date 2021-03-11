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
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();



        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnWhiteListFunctionality();
        configuration.clickOnLastWhiteList();
        configuration.completeNameAndDescriptionWhiteList("WhiteListaTest","DescBlackList");
        configuration.addNumberForWhiteList("48333444333");
        configuration.clickOnButtonSaveWhiteList();
        configuration.verifySaveWhiteList();


        configuration.clickOnLinkActivationWhiteList();
        configuration.clickOnActivationLastWhiteList();

        configuration.verifyActivateWhitelist();


    }
}
