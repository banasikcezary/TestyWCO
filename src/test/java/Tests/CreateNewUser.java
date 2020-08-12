package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CreateNewUser extends TestBase {


    @Test(priority = 1,
            retryAnalyzer = RetryAnalyzer.class)
    public void asAdminTryCreateNewUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnAddUserButton();
        user.typeIntoLoginField("KarolN");
        user.typeIntoFirstNameField("Karol");
        user.typeIntoLastName("Nowak");
        user.typeIntoEmailField("qwerty@o2.pl");
        user.typeIntoPhoneField("666555777");
        user.clickOnSaveNewUserButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();

        user.assertUser("KarolN");


    }


}
