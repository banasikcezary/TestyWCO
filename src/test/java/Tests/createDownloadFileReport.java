package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createDownloadFileReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateDownloadFileReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnDownloadFileReport();
        report.typeInStartReportDateForDownloadFileField();
        report.typeInEndReportDateForDownloadFileField();

        report.clickInSelectionAdmin12();
        report.clickInSelectAdmin12();

        report.clickInGenerateDownloadFile();

        report.checkGenerateNewReport("Pobrane pliki");
        report.checkStatusNewReport();


    }

}
