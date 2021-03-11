package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createRecordedCallsDetailsReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateRecordedCallsDetailsReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnRecordedCallsDetailsReport();
        report.typeInStartReportDateForRecordedCallsDetailsField();
        report.typeInEndReportDateForRecordedCallsDetailsField();

        report.clickInSelectionMainNumber11();
        report.clickInSelectNumber11();

        report.clickInGenerateRecordedCallsDetails();

        report.checkGenerateNewReport("Nagrane połączenia szczegółowo");
        report.checkStatusNewReport();
    }

}
