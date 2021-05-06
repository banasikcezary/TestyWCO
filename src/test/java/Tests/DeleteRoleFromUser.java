package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class DeleteRoleFromUser extends TestBase {
    @Test(priority = 2,
            description = "as Admin Try Add Role For User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddRoleForUser()  {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("CRMOG8WX6VV");
        loginPage.typeIntoPasswordField("Wcopassword1!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
        user.typeIntoSearchUserField("user123");
        user.clickOnSearchButton();
        user.clickOnShowRoleButton();
        user.clickOnAddAssignmentButton();
        user.selectRole("AD_option");
        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();

        user.assertionAddRoleForUser("Admin Dodatkowy");

        user.deleteRoleWithUser("Admin Dodatkowy");
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();

        user.validationDeleteRoleWithUser("Admin Dodatkowy");

    }
}
