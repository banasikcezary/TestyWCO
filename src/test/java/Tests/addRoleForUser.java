package Tests;

import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class addRoleForUser extends TestBase {
    @Test
    public void asAdminTryAddRoleForUser(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
;
        user.clickOnShowRoleButton();
        user.clickOnAddAssignmentButton();
        user.selectRole();
       user.clickAddRoleButton();
       user.clickOnAcceptPopupButton();
       user.assertionAddRoleForUser();

    }

}
