package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class MassEditStatus extends TestBase{

    @Test(priority = 2,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryMassEditRecOutgoing() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnEditStatus();
        userList.setValueFromNotActiveToActiveMassChange();
        userList.clickOnSaveBtn();
        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        userList.validationValueFromNotActiveToActiveMassChange();


    }
}
