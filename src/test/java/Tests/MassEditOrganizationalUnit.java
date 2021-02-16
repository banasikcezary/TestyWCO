package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class MassEditOrganizationalUnit extends TestBase {

    @Test(priority = 2,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryMassEditOrganizationalUnit() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnEditOrganizationalUnit();
        userList.setValueForOrganizationUnitMassChange();
        userList.clickOnSaveBtn();


    }
}
