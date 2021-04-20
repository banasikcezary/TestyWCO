package Tests;

import PageObject.LoginPage;
import PageObject.Roles;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class AddPrivilegeForRole extends TestBase {


    @Test(priority = 2,
            description = "as Admin Try Add Privilege For Role",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddPrivilegeForRole() throws AWTException {

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
        role.clickAddPrivilegeForNewRole();
        role.selectChoosePrivilege();
        role.clickOnSavePrivilege();

        role.clickOnRolesButton();


        role.validateAddRole("testRoleName");
        role.validateAddPermissionForRole();


    }

}
