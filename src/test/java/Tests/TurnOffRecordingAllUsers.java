package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class TurnOffRecordingAllUsers extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.turnOffRecordingAllUsers();
        PageObject.Dialog dialog = new Dialog(driver);
        dialog.confirmPopup();

        UserList userList=new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.validationValueWtzChange();

        userList.validationValueFromYesToNoMassChangeRecordingDirectlyIncomingCalls();
        userList.validationValueFromYesToNoMassChangeRecordingOutgoingCalls();
        userList.validationValueFromYesToNoMassChangeDirectIncomingCalls();



    }
}
