package Tests;

import PageObject.Certificates;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class addNewRoleForCertificate extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Add New Role For Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryAddNewRoleForCertificate() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Certificates cert = new Certificates(driver);
        cert.clickOnCertificatesButton();
        cert.typeIntoSearchNameField("Artur");
        cert.clickOnSearchCertificateButton();
        cert.clickIntoShowRoles();
        cert.clickAddAssignmentButton();
        cert.selectChooseRole();
        cert.clickOnSaveNewRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();

        cert.validateAddRoleForCertificate();

    }

}
