package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyAnAdditionalPackageFromTheStore extends TestBase {

    @Test(priority = 3,
            description = "as User Try Buy An Additional Package From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyAnAdditionalPackageFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.clickOnAdditionalFundsAvailableTab();
        shopPage.selectValuePackageWithList();
        shopPage.clickOnBuyPackageButton();


    }

}
