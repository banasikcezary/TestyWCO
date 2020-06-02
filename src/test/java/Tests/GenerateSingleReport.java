package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;

public class GenerateSingleReport extends TestBase {

    @Test
    public void asUserTryGenerateSingleReport() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        ReportPage reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        reportPage.clickOnProperty();
        reportPage.chooseStartReportDay();
        reportPage.chooseEndReportDay();
        reportPage.clickOnButtonGenerateSingletonReport();

    }
}