package Tests;

import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;


public class addCertificates extends TestBase {




    @Test(priority = 3,
            description ="as Admin Try Add New Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)

    public void asAdminTryAddNewCertificate() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();
        user.clickIntoCertificateButton();
        user.clickIntoAddCertificateButton();
        user.assertAddCertificate();


    }

}
