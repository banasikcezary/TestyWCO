package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CyclicExtensionsNumberAndTransfersReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReportCyclic() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnExtensionsNumberAndTransfersReport();
        report.clickOnExtensionsNumberAndTransfersReportCyclic();
        report.chooseValueCyclicalReport();

        report.chooseAllUser5();

        report.clickInGenerateExtensionsNumberAndTransfers();
        Dialog dialog= new Dialog(driver);
        dialog.confirmPopup();

        report.checkGenerateCyclicReport("Rozkład połączeń na różne numery wewnętrzne i transfery");

    }
}
