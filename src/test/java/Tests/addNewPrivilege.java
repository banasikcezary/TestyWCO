package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.Privileges;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class addNewPrivilege extends TestBase {


    @Test(priority = 1,
            retryAnalyzer = RetryAnalyzer.class)
    public void asAdminTryAddNewPrivilege() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Privileges privileges = new Privileges(driver);
        privileges.clickOnPrivilegeButton();
        privileges.clickOnAddPrivilegeButton();
        privileges.typeIntoAddNameField("testNameField");
        privileges.clickOnSaveNewPrivilege();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        privileges.clickOnPrivilegeButton();


        privileges.validateThePrivilegesCreation("testNameField");

    }

}
