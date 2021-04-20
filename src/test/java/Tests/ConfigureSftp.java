package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class ConfigureSftp extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


       Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();



        configuration.clickOnFunctionalitySettings();
        configuration.chooseSettingsArchivingCalls();
        configuration.addSettingsSftp("126.198.148.88","22","sftptest4","sftptest1","10:00","17:00","AAAAB3NzaC1yc2EAAAADAQABAAABgQC/WzYzfDe3+Ejhl4zTj3Ket6zlPRi7Af3PUQ3IEC57PS+8fYyM/4dRRUT6HqlsTFz1Jj/VzcX6APz2DuVQUwONwzPU35+AJsiz6UZvKAbzI4IX8QMVKO5UshyMVV8pkXWXQc9nlsVqnjzknIneCxb746Nwt8WQXY0NUjctD2QBN611V1NN2lu1mvq0h9l5lUk3xB4tIsZqm8On6/YviSfEzMI0XOH9iAk/ppPyODCfUNCqlnWevmUjK5mMAqjuxDn091GwCNePQx0A1SK/t3ysIFx+YL7Nnfq31alpWpRvylzz0fri1bBtNWUTclSJAabb8eeWOFU15ezD3i031lgLyGT/8HnqBMbocyTuubBPa9WARBTXhKo/dMKx/Ulf3H6fUfsm+TqfTrjhoENo/61nh5BV/0H4JnuNghwqhn1k/s+HSxSEDuAi6t2a2VDnsaYi3XlVCbkzjw9jD9v1WKyjWnnWgyNBVvDxj7zH/0bAvhDy837/eHGbVnGn5LOJ/20=");

        configuration.clickSaveButton();
        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        configuration.verifySettingsSftp("126.198.148.88","22","sftptest4","10:00:00","17:00:00","AAAAB3NzaC1yc2EAAAADAQABAAABgQC/WzYzfDe3+Ejhl4zTj3Ket6zlPRi7Af3PUQ3IEC57PS+8fYyM/4dRRUT6HqlsTFz1Jj/VzcX6APz2DuVQUwONwzPU35+AJsiz6UZvKAbzI4IX8QMVKO5UshyMVV8pkXWXQc9nlsVqnjzknIneCxb746Nwt8WQXY0NUjctD2QBN611V1NN2lu1mvq0h9l5lUk3xB4tIsZqm8On6/YviSfEzMI0XOH9iAk/ppPyODCfUNCqlnWevmUjK5mMAqjuxDn091GwCNePQx0A1SK/t3ysIFx+YL7Nnfq31alpWpRvylzz0fri1bBtNWUTclSJAabb8eeWOFU15ezD3i031lgLyGT/8HnqBMbocyTuubBPa9WARBTXhKo/dMKx/Ulf3H6fUfsm+TqfTrjhoENo/61nh5BV/0H4JnuNghwqhn1k/s+HSxSEDuAi6t2a2VDnsaYi3XlVCbkzjw9jD9v1WKyjWnnWgyNBVvDxj7zH/0bAvhDy837/eHGbVnGn5LOJ/20=");

    }
}
