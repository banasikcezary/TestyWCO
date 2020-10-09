package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createAuditLogsPlusReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateAuditLogsPlusReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnAuditLogsPlusReport();
        report.typeInStartReportDateForAuditLogsPlusField();
        report.typeInEndReportDateForAuditLogsPlusField();
        report.clickInGenerateAuditLogsPlus();

        report.checkGenerateNewReport("Logi Audytowe plus");
        report.checkStatusNewReport();


    }

}