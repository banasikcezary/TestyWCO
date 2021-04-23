package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SellingOppbFromTheStore extends TestBase {
    @Test(priority = 3,
            description = "as User Try Sell Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTrySellFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.sellOppbFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();


    }
}
