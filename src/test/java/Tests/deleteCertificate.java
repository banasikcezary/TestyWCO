package Tests;

import PageObject.Certificates;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class deleteCertificate extends TestBase {

    @Test(priority = 3)
    public void asAdminTryDownloadCertificate(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Certificates cert = new Certificates(driver);
        cert.clickOnCertificatesButton();
        cert.typeIntoSearchNameField();
        cert.clickOnSearchCertificateButton();
        cert.clickOnDeleteCertificateButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        cert.clickOnSearchCertificateButton();

        cert.typeIntoSearchNameField();
        cert.clickOnSearchCertificateButton();


        cert.validateTheCertificateDelete();

    }

}
