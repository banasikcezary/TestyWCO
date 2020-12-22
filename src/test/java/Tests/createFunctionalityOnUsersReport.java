package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class createFunctionalityOnUsersReport extends TestBase{

    @Test(priority = 3,
            description = "as Admin Try Generate Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateFunctionalityOnUsersReport() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnFunctionalityOnUsersReport();
        report.typeInStartReportDateForFunctionalityOnUsersField();
        report.typeInEndReportDateForFunctionalityOnUsersField();

        report.clickInSelectionUser23();
        report.clickInSelectUser23();


        report.clickInGenerateFunctionalityOnUsers();

        report.checkGenerateNewReport("Funkcjonalności na użytkownikach");
        report.checkStatusNewReport();
    }

}
