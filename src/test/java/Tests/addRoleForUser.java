package Tests;
import PageObject.*;

import PageObject.Dialog;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;


public class addRoleForUser extends TestBase {



    @Test(priority = 2,
            description = "as Admin Try Add Role For User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddRoleForUser()  {

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
        user.selectRole("AG_option");
        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        user.assertionAddRoleForUser("Admin Główny");

    }

}
