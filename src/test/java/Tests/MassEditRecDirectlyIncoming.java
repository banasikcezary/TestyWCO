package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class MassEditRecDirectlyIncoming extends TestBase {

    @Test(priority = 2,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryMassEditRecDirectlyIncoming() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnButtonEditRecDirectlyIncoming();
        userList.setValueFromNotToYesMassChange();
        userList.clickOnSaveBtn();
    }
}
