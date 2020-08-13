package Tests;

import PageObject.Certificates;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class downloadCertificate extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Download Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDownloadCertificate() {

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
        String deleteCertificateName="Artur";
        cert.typeIntoSearchNameField(deleteCertificateName);
        cert.clickOnSearchCertificateButton();
        cert.clickOnDownloadCertificateButton();

    }

}
