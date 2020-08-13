package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CreateNewUser extends TestBase {


    @Test(priority = 1,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
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
        String login="KarolN";
        user.typeIntoLoginField(login);
        user.typeIntoFirstNameField("Karol");
        user.typeIntoLastName("Nowak");
        user.typeIntoEmailField("qwerty@o2.pl");
        user.typeIntoPhoneField("666555777");
        user.clickOnSaveNewUserButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField(login);
        user.clickOnSearchButton();

        user.assertUser(login);


    }


}
