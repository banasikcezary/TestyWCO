package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class deleteRole extends TestBase {

    @Test(priority = 3)
    public void asAdminTryDeleteRole(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickDeleteRoleButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();


        role.validateDeleteRole();
    }

}
