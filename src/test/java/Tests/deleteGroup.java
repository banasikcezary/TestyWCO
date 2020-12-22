package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class deleteGroup extends TestBase {


    @Test(priority = 4,
            description = "as Admin Try Delete Group",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteGroup() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        String groupName ="test123";
        Dialog dialog = new Dialog(driver);

        group.clickOnDeleteGroupButton(groupName);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();


        group.validateDeleteGroup(groupName);
    }

}
