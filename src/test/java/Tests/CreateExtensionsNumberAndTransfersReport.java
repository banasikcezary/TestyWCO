package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CreateExtensionsNumberAndTransfersReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnExtensionsNumberAndTransfersReport();
        report.typeInStartReportDateForExtensionsNumberAndTransfersField();
        report.typeInEndReportDateForExtensionsNumberAndTransfersField();

        report.clickInSelectionUser5();
        report.clickInSelectUser5();

        report.clickInGenerateExtensionsNumberAndTransfers();

        report.checkGenerateNewReport("Rozkład połączeń na różne numery wewnętrzne i transfery");
        report.checkStatusNewReport();
    }

}
