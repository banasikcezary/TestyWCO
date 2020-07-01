package Tests;

import PageObject.Certificates;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class downloadCertificate extends TestBase {

    @Test
    public void asAdminTryDownloadCertificate(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Certificates cert = new Certificates(driver);
        cert.clickOnCertificatesButton();
        cert.typeIntoSearchNameField();
        cert.clickOnSearchCertificateButton();
        cert.clickOnDownloadCertificateButton();

    }

}
