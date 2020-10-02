package Tests;

import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;



public class addCertificates extends TestBase {




    @Test(priority = 2,
            description ="as Admin Try Add New Certificate",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)

    public void asAdminTryAddNewCertificate()  {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
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
