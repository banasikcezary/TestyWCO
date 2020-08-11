package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;

public class BuyingFunctionalityInTheStoreAndExceedingTheAmountToBeUsed extends TestBase {

    @Test(priority = 3)
    public void asUserTryBuyFunctionalitiesWithExceedingTheAmountToBeUsedFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewFaxFunctionalitiesWithExceedingTheAmount();
        shopPage.clickOnBuyPackageButton();





    }

}
