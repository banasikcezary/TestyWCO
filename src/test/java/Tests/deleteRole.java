package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class deleteRole extends TestBase {

    @Test(priority = 3,
            description = "as Admin Try Delete Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteRole() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
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
