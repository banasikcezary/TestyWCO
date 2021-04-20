package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class addRole extends TestBase {


    @Test(priority = 1,
            description = "as Admin Try Add New Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddNewRole() {

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
        role.clickOnAddRoleButton();
        String rola="testRoleName";
        role.typeIntoAddRoleNameField(rola);
        role.typeIntoAddRoleDescriptionField("Rola123");
        role.clickOnSaveNewRole();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        dialog.refreshPage();
        role.clickOnRolesButton();

        role.validateAddRole(rola);


    }

}
