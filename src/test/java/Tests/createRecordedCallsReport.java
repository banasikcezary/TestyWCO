package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createRecordedCallsReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("KarolN");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnRecordedCallsReport();
        report.typeInStartReportDateForRecordedCallsField();
        report.typeInEndReportDateForRecordedCallsField();

        report.clickInSelectionMainNumber10();
        report.clickInSelectNumber10();

        report.clickInGenerateRecordedCalls();


        report.checkGenerateNewReport("Nagrane połączenia");
        report.checkStatusNewReport();

    }

}
