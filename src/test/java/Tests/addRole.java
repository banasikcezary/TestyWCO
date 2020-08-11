package Tests;

import PageObject.*;
import org.testng.annotations.Test;

public class addRole extends TestBase{
    @Test(priority = 1)
    public void asAdminTryAddNewRole(){

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
        role.clickOnAddRoleButton();
        role.typeIntoAddRoleNameField();
        role.typeIntoAddRoleDescriptionField();
        role.clickOnSaveNewRole();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();

        role.validateAddRole();


    }

}
