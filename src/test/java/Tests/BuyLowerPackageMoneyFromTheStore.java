package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyLowerPackageMoneyFromTheStore extends TestBase {

    @Test(priority = 3,
            description = "as User Try Buy An Additional Package From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyAnAdditionalPackageFromTheStore() {

        driver.navigate().to("https://wck.orange.pl/");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("nowyTest");
        loginPage.typeIntoPasswordField("123456123456Aa!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.clickOnAdditionalFundsAvailableTab();
        shopPage.selectLowestValuePackageWithList();
        shopPage.clickOnBuyPackageButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnContinuePurchasing();

        shopPage.checkNotAllowSavingLowerPackageMoneyMessage();


    }
}
