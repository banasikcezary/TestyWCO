package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;

public class BuyAnAdditionalPackageFromTheStore extends TestBase {

    @Test
    public void asUserTryBuyAnAdditionalPackageFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.clickOnAdditionalFundsAvailableTab();
        shopPage.selectValuePackageWithList();
        shopPage.clickOnBuyPackageButton();






    }

}
