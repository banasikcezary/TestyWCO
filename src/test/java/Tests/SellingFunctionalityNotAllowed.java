package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ShopPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SellingFunctionalityNotAllowed extends TestBase {


    @Test(priority = 1,
            description = "as User Try Buy New Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryBuyAllFunctionalitiesFromTheStore() {

        driver.navigate().to("https://wck.orange.pl/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("nowyTest");
        loginPage.typeIntoPasswordField("123456123456Aa!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewBlackListFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();
        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("Czarna");
        configuration.completeNameAndDescription("CzarnaListaTest1","DescBlackList");
        configuration.addNumberForBlackList("48333444333");
        configuration.clickOnButtonSaveBlackList();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();

        configuration.verifySaveBlackList("CzarnaListaTest1");

        shopPage.clickOnShopTab();
        shopPage.sellBlackListFunctionalities();


        shopPage.clickOnSaveChangeButton();
        shopPage.checkNotAllowSavingConfirmationText();



        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();

        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("CzarnaListaTest1");
        configuration.clickOnButtonDeleteBlackList();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();

        configuration.verifyDeleteBlackList("CzarnaListaTest1");




    }
}
