package Tests;

import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class deletePrivilegeFromRole extends TestBase {

    @Test
    public void asAdminTryDeletePrivilegeFromRole(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickOpenRole();
        role.clickOnDeletePrivilegeFromRoleButton();


    }

}
