package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createNewGroup extends TestBase {
    @Test(priority = 1,
            retryAnalyzer = RetryAnalyzer.class)
    public void asAdminTryCreateNewGroup() {

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
        group.clickOnAddGroupButton();
        group.typeIntoAddNameField("test123");
        group.typeIntoAddDescriptionField("test opisu grupy");
        group.clickOnSaveNewGroupButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        group.clickOnGroupButton();


        group.validateAddNewGroup("test123");
    }
}
