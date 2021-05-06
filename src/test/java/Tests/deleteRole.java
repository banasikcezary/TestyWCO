package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class deleteRole extends TestBase {

    @Test(priority = 5,
            description = "as Admin Try Delete Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteRole() {

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
        role.clickDeleteRoleButton("Rola123445");
        Dialog dialog = new Dialog(driver);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();
        role.validateDeleteRole("Rola123445");
    }

}
