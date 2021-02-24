package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerifyAlertAfterLog extends TestBase{


    @Test(priority = 1,
            description = "as User Try Positive Log into Account",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void verifyAlertAfterLog() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Dialog dialog= new Dialog(driver);
        dialog.verifyAlertAfterLogin("×\n" +
                "Komunikat testowy po autoryzacji");

    }
}
