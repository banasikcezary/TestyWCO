package Tests;

import PageObject.*;

import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class BuyAnAdditionalPackageFromTheStore extends TestBase {

    @Test(priority = 3,
            description = "as User Try Buy An Additional Package From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyAnAdditionalPackageFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.clickOnAdditionalFundsAvailableTab();
        shopPage.selectValuePackageWithList();
        shopPage.clickOnBuyPackageButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnContinuePurchasing();

        shopPage.checkSavingAdditionalPackageConfirmationText();


    }

}
