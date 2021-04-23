package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyingAllFunctionalitiesFromShop extends TestBase {


    @Test(priority = 1,
            description = "as User Try Buy New Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyAllFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();

        shopPage.buyNewUserFunctionalities();
        shopPage.buyNewRecordingFunctionalities();
        shopPage.buyNewApiFunctionalities();
        shopPage.buyNewPersonalizedMessageFunctionalities();
        shopPage.buyNewOppbFunctionalities();
        shopPage.buyNewTagFunctionalities();
        shopPage.buyNewPackage1000MinutesRecFunctionalities();
        shopPage.buyNewMessageEnglishFemaleFunctionalities();
        shopPage.buyNewMessagePolishFemaleFunctionalities();
        shopPage.buyNewMessagePolishMaleFunctionalities();
        shopPage.buyNewVipFunctionalities();
        shopPage.buyNewWhiteListFunctionalities();
        shopPage.buyNewBlackListFunctionalities();
        shopPage.buyNewDetailedAuditLogsFunctionalities();

        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();




    }
}
