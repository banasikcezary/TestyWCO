package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class CreateNewUser extends TestBase {


    @Test(priority=1)
    public void asAdminTryCreateNewUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnAddUserButton();
        user.typeIntoLoginField();
        user.typeIntoFirstNameField();
        user.typeIntoLastName();
        user.typeIntoEmailField();
        user.typeIntoPhoneField();
        user.clickOnSaveNewUserButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        user.clickOnSearchButton();
        user.typeIntoSearchUserField();
        user.clickOnSearchButton();

        user.assertUser();


    }


}
