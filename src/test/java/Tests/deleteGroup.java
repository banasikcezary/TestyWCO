package Tests;

import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class deleteGroup extends TestBase {


    @Test
    public void asAdminTryDeleteGroup(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        group.selectChooseRole();
        group.clickOnDeleteGroupButton();
    }

}