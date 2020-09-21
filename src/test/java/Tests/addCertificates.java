package Tests;

import PageObject.Certificates;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class addCertificates extends TestBase {




    @Test(priority = 1,
            description ="as Admin Try Add New Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)

    public void asAdminTryAddNewCertificate() {

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
        cert.clickOnAddUserButton();
        String name = "Artur";
        cert.typeIntoAddNameField(name);
        cert.typeIntoAddEmailField("artur@o2.pl");
        cert.typeIntoAddCityField("Warszawa");
        cert.typeIntoAddCountryField("Polska");
        cert.typeIntoAddStateField("Stan");
        cert.typeIntoAddOrganisationField("Organizacja");
        cert.typeIntoAddOrganisationalUnitField("Dział");
        cert.loadFileWithCertificates();
        cert.clickSaveNewCertificateButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        cert.clickOnSearchCertificateButton();
        cert.typeIntoSearchNameField(name);
        cert.clickOnSearchCertificateButton();

        cert.validateTheCertificateCreation(name);

    }

}
