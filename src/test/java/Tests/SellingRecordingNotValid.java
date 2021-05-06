package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SellingRecordingNotValid extends TestBase {
    @Test(priority = 3,
            description = "as User Try Sell Functionalities From The Store",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTrySellFunctionalitiesFromTheStore() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewRecordingFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user_1");
        configuration.selectNewUser();
        configuration.switchOnRecordingDirectlyIncomingCallsOnUser();

        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        UserList userList=new UserList(driver);
        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();

        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user_1");
        configuration.selectNewUser();
        configuration.verifySwitchOnRecIn();



        shopPage.clickOnShopTab();
        shopPage.sellRecordingFunctionalities();
        shopPage.clickOnSaveChangeButton();

        dialog.confirmPopupWrongInfo("Centralka nie posiada wystarczającej liczby nieużywanych opcji nagrywania połączeń do sprzedania");


        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user_1");
        configuration.selectNewUser();
        configuration.switchOnRecordingDirectlyIncomingCallsOnUser();

        configuration.clickSaveButton();
        dialog.confirmPopup();

        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();

        shopPage.clickOnShopTab();
        shopPage.sellRecordingFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();


    }
}
