package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CyclicFunctionalityOnUsersReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateExtensionsNumberAndTransfersReportCyclic() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnFunctionalityOnUsersReport();
        report.clickOnFunctionalityOnUsersReportCyclic();
        report.chooseValueCyclicalReport();

report.chooseAllUserForFunctionalityOnUsersReportCyclic();

        report.clickInGenerateFunctionalityOnUsers();

        Dialog dialog= new Dialog(driver);
        dialog.confirmPopup();

        report.checkGenerateCyclicReport("Funkcjonalności na użytkownikach");

    }
}
