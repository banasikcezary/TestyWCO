package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class deleteGroup extends TestBase {


    @Test(priority = 4,
            description = "as Admin Try Delete Group",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteGroup() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        String groupName ="test123";

        group.clickOnDeleteGroupButton(groupName);
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();


        group.validateDeleteGroup(groupName);
    }

}
