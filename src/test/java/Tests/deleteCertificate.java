package Tests;

import PageObject.Certificates;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class deleteCertificate extends TestBase {

    @Test(priority = 3,
            description = "as Admin Try Delete Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteCertificate() {

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
        String certyficate="Artur";
        cert.typeIntoSearchNameField(certyficate);
        cert.clickOnSearchCertificateButton();
        cert.clickOnDeleteCertificateButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        cert.clearCertificateSearchField();


        cert.validateTheCertificateDelete(certyficate);

    }

}
