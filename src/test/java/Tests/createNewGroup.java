package Tests;

import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;

public class createNewGroup extends TestBase {
    @Test
    public void asAdminTryCreateNewGroup(){

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
        group.clickOnAddGroupButton();
        group.typeIntoAddNameField();
        group.typeIntoAddDescriptionField();
        group.clickOnSaveNewGroupButton();
    }
}