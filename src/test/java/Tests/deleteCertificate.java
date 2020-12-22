package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class deleteCertificate extends TestBase {

    @Test(priority = 4,
            description = "as Admin Try Delete Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteCertificate() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();

        user.clickOnUserButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();
        user.clickIntoCertificateButton();
        user.clickIntoDeleteCertificateButton();
    }

}
