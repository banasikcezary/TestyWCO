package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;

public class BuyingFunctionalityInTheStoreAndExceedingTheAmountToBeUsed extends TestBase {

    @Test
    public void asUserTryBuyFunctionalitiesWithExceedingTheAmountToBeUsedFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewFaxFunctionalitiesWithExceedingTheAmount();
        shopPage.clickOnBuyPackageButton();





    }

}
