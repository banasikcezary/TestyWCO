package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class addPrivilegeForRole extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Add Privilege For Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddPrivilegeForRole() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickAddPrivilegeForNewRole();
        role.selectChoosePrivilege();
        role.clickOnSavePrivilege();
//        Dialog dialog = new Dialog(driver);
//        dialog.clickOnAcceptPopupButton();
        user.clickOnUserAndPermissionButton();
        role.clickOnRolesButton();


        role.validateAddRole("testRoleName");
        role.validateAddPermissionForRole();


    }

}
