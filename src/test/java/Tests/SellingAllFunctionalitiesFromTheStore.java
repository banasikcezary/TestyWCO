package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SellingAllFunctionalitiesFromTheStore extends TestBase {


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

        shopPage.sellUserFunctionalities();
        shopPage.sellRecordingFunctionalities();
        shopPage.sellApiFunctionalities();
        shopPage.sellPersonalizedMessageFunctionalities();
        shopPage.sellOppbFunctionalities();
        shopPage.sellTagFunctionalities();
        shopPage.sellPackage1000MinutesRecFunctionalities();
        shopPage.sellMessageEnglishFemaleFunctionalities();
        shopPage.sellMessagePolishFemaleFunctionalities();
        shopPage.sellMessagePolishMaleFunctionalities();
        shopPage.sellVipFunctionalities();
        shopPage.sellWhiteListFunctionalities();
        shopPage.sellBlackListFunctionalities();
        shopPage.sellDetailedAuditLogsFunctionalities();

        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();




    }
}
