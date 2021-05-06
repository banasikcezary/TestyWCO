package Tests;

import PageObject.*;
import PageObject.Dialog;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class CreateUserWithNumberInAnotherWck extends TestBase {


    @Test(priority = 1,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewUser() {
        String phone1="+48690408932";
        String user1="CRM2J2DF6ZZ";
        String pass1="Centralka123456!";

        String phone2="+48690408934";
        String user2="CRMOG8WX6VV";
        String pass2="Wcopassword1!";

        String userNumber="48123321123";
        String userLogin="number1";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField(phone1);
        loginPage.typeIntoUsernameField(user1);
        loginPage.typeIntoPasswordField(pass1);
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewUserFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.selectNewUser();
        configuration.typeIntoLoginField(userLogin);
        configuration.typeIntoFirstNameField("Karol");
        configuration.typeIntoLastNameInputField("N");
       configuration.typeIntoNumberInputField("48123321123");
        configuration.clickSaveButton();
        PageObject.Dialog dialog = new Dialog(driver);
        dialog.confirmPopup();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
        user.typeIntoSearchUserField(userLogin);
        user.clickOnSearchButton();
        user.assertUser(userLogin);

        loginPage.clickOnLogoutButton();

        loginPage.typeIntoPhoneNumberField(phone2);
        loginPage.typeIntoUsernameField(user2);
        loginPage.typeIntoPasswordField(pass2);
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        shopPage.clickOnShopTab();
        shopPage.buyNewUserFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.selectNewUser();
        configuration.typeIntoLoginField(userLogin);
        configuration.typeIntoFirstNameField("Karol");
        configuration.typeIntoLastNameInputField("N");
        configuration.typeIntoNumberInputField("48123321123");
        configuration.clickSaveButton();
        dialog.confirmPopupWrongInfo("Nie mozna aktywować numeru "+userNumber+" ponieważ istnieje on w centralce "+user1+"");

        shopPage.clickOnShopTab();
        shopPage.sellUserFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        loginPage.clickOnLogoutButton();
        loginPage.typeIntoPhoneNumberField(phone1);
        loginPage.typeIntoUsernameField(user1);
        loginPage.typeIntoPasswordField(pass1);
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField(userLogin);
        configuration.selectNewUser();
        configuration.clickOnDeleteButton();
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();

        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField(userLogin);
        user.clickOnSearchButton();

        user.assertDeleteUser(userLogin);
    }
}
