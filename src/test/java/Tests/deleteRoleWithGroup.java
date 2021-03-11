package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class deleteRoleWithGroup extends TestBase {

    @Test(priority = 3,
            description = "as Admin Try Delete Role With Group",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteRoleWithGroup() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        group.clickDeleteRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();


        group.validateDeleteRoleForGroup();
    }

}
