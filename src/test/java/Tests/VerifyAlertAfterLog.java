package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerifyAlertAfterLog extends TestBase {


    @Test(priority = 1,
            description = "as User Try Positive Log into Account",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void verifyAlertAfterLog() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Dialog dialog= new Dialog(driver);
        dialog.verifyAlertAfterLogin("×\n" +
                "Komunikat testowy po autoryzacji");

    }
}
