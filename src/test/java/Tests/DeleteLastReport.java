package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class DeleteLastReport extends TestBase {


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
        String quantity =report.validateQuantityReportBefore();
        report.deleteLastReport();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        dialog.confirmPopup();

        report.validateQuantityReportAfter(quantity);
    }
}
