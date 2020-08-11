package Tests;

import PageObject.*;
import org.testng.annotations.Test;

public class addCertificates extends TestBase {

    @Test(priority= 1)
    public void asAdminTryAddNewCertificate(){

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
        cert.clickOnAddUserButton();
        cert.typeIntoAddNameField();
        cert.typeIntoAddEmailField();
        cert.typeIntoAddCityField();
        cert.typeIntoAddCountryField();
        cert.typeIntoAddStateField();
        cert.typeIntoAddOrganisationField();
        cert.typeIntoAddOrganisationalUnitField();
        cert.loadFileWithCertificates();
        cert.clickSaveNewCertificateButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        cert.clickOnSearchCertificateButton();
        cert.typeIntoSearchNameField();
        cert.clickOnSearchCertificateButton();

        cert.validateTheCertificateCreation();

    }

}
