package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class DeleteUserFromGroup extends TestBase {
    @Test(priority = 1,
            description = "as Admin Try Create New Group",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewGroup() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.chooseGroupWithList("test123");

     group.deleteUserWithGroup("Pio");
     PageObject.Dialog dialog = new Dialog(driver);
        dialog.clickOnConfirmButton();
        driver.navigate().refresh();
        group.chooseGroupWithList("test123");


        group.verifyDeleteUserFromGroup("Pio");



    }
}
