package Tests;

import PageObject.Dialog;
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
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
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
