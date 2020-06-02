package Tests;

import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;

public class GenerateCyclicalReport extends TestBase {


    @Test
    public void asUserTryGenerateCyclicalReport() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
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