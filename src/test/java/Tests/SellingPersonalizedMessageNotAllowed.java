package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SellingPersonalizedMessageNotAllowed extends TestBase {
    @Test(priority = 3,
            description = "as User Try Sell Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTrySellFunctionalitiesFromTheStore() {
        driver.navigate().to("https://wck.orange.pl/");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("nowyTest");
        loginPage.typeIntoPasswordField("123456123456Aa!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.setPersonalizedMessageForUserIncomingCalls("ciekawyTTs", "InterestingTTs");

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        configuration.verifyPersonalizedMessageForUserIncomingCalls();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.sellPersonalizedMessageFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkNotAllowSavingConfirmationTextForPersonalizedMessage();


    }
}
