package Tests;

import PageObject.*;

import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyingTagsFromTheStore extends TestBase {


    @Test(priority = 1,
            description = "as User Try Buy New Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyNewFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewTagFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();


    }
}
