package Tests;

import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class CreateNewUser extends TestBase {


    @Test
    public void asAdminTryCreateNewUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
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
        user.assertUser();

        //user.typeIntoSearchUserField();
       // user.clickOnSearchButton();
    }


}
