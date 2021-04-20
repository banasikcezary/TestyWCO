package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class deletePrivilegeFromRole extends TestBase {

    @Test(priority = 3,
            description ="as Admin Try Delete Privilege From Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeletePrivilegeFromRole() throws AWTException {

        driver.navigate().to("http://localhost:8075/superadmin/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("superadminbs");
        loginPage.typeIntoPasswordField("Super2020!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickOpenRole();
        role.clickOnDeletePrivilegeFromRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();


        role.validateDeletePermissionForRole();


    }

}
