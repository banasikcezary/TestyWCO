package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CsvExport extends TestBase {


    @Test(priority = 2,
            description = "as User Try Export Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryExportCsvFile() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.clickOnButtonExportToCsv();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";
        userList.waitForFileDownloaded( "fileName", 50,downloadDir);
        userList.verifyDownloadFile(downloadDir, "fileName");

        }

    }

