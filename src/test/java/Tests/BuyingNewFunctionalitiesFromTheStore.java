package Tests;

import PageObject.LoginPage;
import PageObject.ShopPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class BuyingNewFunctionalitiesFromTheStore extends TestBase {


    @Test
    public void asUserTryBuyNewFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewFaxFunctionalities();
        shopPage.clickOnSaveChangeButton();





    }
}
