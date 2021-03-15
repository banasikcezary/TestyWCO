package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class ChangePasswordForUser extends TestBase {

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateAuditLogsPlusReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("nowyTest");
        loginPage.typeIntoPasswordField("Nowehasło12344566!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        loginPage.changePasswordUser("Nowehasło12344566!", "123321Qwertyuio12344566!", "123321Qwertyuio12344566!");
        Dialog d = new Dialog(driver);
        d.clickOnAcceptPopupButton();

        loginPage.clickOnLogoutButton();

        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("nowyTest");
        loginPage.typeIntoPasswordField("123321Qwertyuio12344566!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


    }
}
