package Tests;

import PageObject.Certificates;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class addRole extends TestBase{
    @Test
    public void asAdminTryAddNewRole(){

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
        role.clickOnAddRoleButton();
        role.typeIntoAddRoleNameField();
        role.typeIntoAddRoleDescriptionField();
        role.clickOnSaveNewRole();


    }

}
