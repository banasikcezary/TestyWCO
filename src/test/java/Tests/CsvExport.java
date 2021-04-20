package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class CsvExport extends TestBase {


    @Test(priority = 2,
            description = "as User Try Export Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryExportCsvFile() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.clickOnButtonExportToCsv();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";

        userList.waitForFileDownloaded( "fileName", 50,downloadDir);
        userList.verifyDownloadFile(downloadDir);

        }

    }

