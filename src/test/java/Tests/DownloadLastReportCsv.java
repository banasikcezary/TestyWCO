package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class DownloadLastReportCsv extends TestBase {

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateFunctionalityOnUsersReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report = new ReportPage(driver);
        report.clickOnReportTab();
        report.downloadLastReportCSV();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";

        report.waitForFileDownloaded( "Raport", 50,downloadDir);
        report.verifyDownloadFile(downloadDir);

    }
}
