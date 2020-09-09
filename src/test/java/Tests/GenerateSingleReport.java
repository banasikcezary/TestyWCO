package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class GenerateSingleReport extends TestBase {

    @Test(priority = 2,
            enabled=false,
            description = "as User Try Generate Single Report",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryGenerateSingleReport() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        ReportPage reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        reportPage.clickOnProperty();
        reportPage.chooseStartReportDay();
        reportPage.chooseEndReportDay();
        reportPage.clickOnButtonGenerateSingletonReport();

    }
}