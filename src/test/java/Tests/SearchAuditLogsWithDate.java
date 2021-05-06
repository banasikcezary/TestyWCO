package Tests;

import PageObject.AuditLogsPage;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SearchAuditLogsWithDate extends TestBase {

    @Test(priority = 4,
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTrySearchLogsWithDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        AuditLogsPage auditLogsPage=new AuditLogsPage(driver);
        auditLogsPage.searchAuditLogsWithDate("26.04.2021","26.04.2021");

        auditLogsPage.verifyViewAuditLogsFromDate("26.04.2021");
    }
}