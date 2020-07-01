package Tests;

import PageObject.Certificates;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class addCertificates extends TestBase {

    @Test
    public void asAdminTryAddNewCertificate(){

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
        cert.typeIntoSearchNameField();
        cert.clickOnSearchCertificateButton();

    }

}
