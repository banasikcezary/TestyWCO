package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class GenerateCyclicalReport extends TestBase {


    @Test(priority = 2,
            retryAnalyzer = RetryAnalyzer.class)
    public void asUserTryGenerateCyclicalReport() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        ReportPage reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        reportPage.clickOnButtonCyclicalReport();
        reportPage.clickOncheckboxGenerateReport();
        reportPage.clickOnGenerateReportEveryField();
        reportPage.selectChooseInterval();
        reportPage.typeIntoEndReportDateForCyclical();
        reportPage.clickOnGenerateCyclicalReport();


    }
}