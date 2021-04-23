package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CyclicRecordedCallsDetailsReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReportCyclic() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("KarolN");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnRecordedCallsDetailsReport();
        report.clickOnRecordedCallsDetailsReportCyclic();
        report.chooseValueCyclicalReport();

        report.clickInSelectionMainNumber11();
        report.clickInSelectNumber11();

        report.clickInGenerateRecordedCallsDetails();

        Dialog dialog= new Dialog(driver);
        dialog.confirmPopup();

        report.checkGenerateCyclicReport("Nagrane połączenia szczegółowo");

    }
}
