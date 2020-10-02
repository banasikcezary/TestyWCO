package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createExtensionsNumberAndTransfersReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

    }

}
