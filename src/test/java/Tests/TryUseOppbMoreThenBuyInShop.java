package Tests;

import PageObject.*;
import PageObject.Dialog;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class TryUseOppbMoreThenBuyInShop extends TestBase{

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewOppbFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();


        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("User_1");
        configuration.selectNewUser();
        configuration.switchOnOppbOnUser();

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        UserList userList=new UserList(driver);
        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();

        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("User_1");
        configuration.selectNewUser();
        configuration.verifySwitchOppbOnUser();


driver.navigate().refresh();
configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("Pio");
        configuration.selectNewUser();
        configuration.verifyDisableCheckboxOppbOnUserSettings();



        driver.navigate().refresh();

        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("User_1");
        configuration.selectNewUser();
        configuration.switchOnOppbOnUser();

        configuration.clickSaveButton();
        dialog.confirmPopup();

        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();

        shopPage.clickOnShopTab();
        shopPage.sellOppbFunctionalities();
        shopPage.clickOnSaveChangeButton();

        shopPage.checkSavingConfirmationText();


    }
}
