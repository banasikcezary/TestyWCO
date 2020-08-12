package Tests;

import PageObject.Certificates;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class downloadCertificate extends TestBase {

    @Test(priority = 2,
            retryAnalyzer = RetryAnalyzer.class)
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
        cert.typeIntoSearchNameField("Artur");
        cert.clickOnSearchCertificateButton();
        cert.clickOnDownloadCertificateButton();

    }

}
