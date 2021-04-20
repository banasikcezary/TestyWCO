package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class EditRole extends TestBase {

    @Test(priority = 4,
            description = "as Admin Try Edit Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryEditRole() {



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
        role.clickOnEditRole();
        String editRoleName="Rola123445";
        role.typeIntoEditRoleNameField(editRoleName);
        role.typeIntoEditRoleDescription("testEdycjiOpisu");
        role.clickOnSaveEditRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();


        role.validateEditRole(editRoleName);


    }

}
