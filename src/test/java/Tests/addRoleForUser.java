package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class addRoleForUser extends TestBase {
    @Test(priority = 2,
            description = "as Admin Try Add Role For User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddRoleForUser() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();
        user.clickOnShowRoleButton();
        user.clickOnAddAssignmentButton();
        user.selectRole();
        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();

        user.assertionAddRoleForUser();

    }

}
