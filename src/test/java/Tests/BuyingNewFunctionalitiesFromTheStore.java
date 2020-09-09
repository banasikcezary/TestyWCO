package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyingNewFunctionalitiesFromTheStore extends TestBase {


    @Test(priority = 3,
            description = "as User Try Buy New Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyNewFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewPresentationByMajorNumberFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();


    }
}
