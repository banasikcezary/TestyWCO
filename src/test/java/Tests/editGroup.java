package Tests;

import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class editGroup extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Edit Group",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryEditGroup() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        group.clickOnEditGroupButton();
        String editName="test123";
        group.typeIntoAddNameField(editName);
        group.typeIntoAddDescriptionField("test opisu grupy");
        group.clickOnSaveNewGroupButton();

        group.validateAddNewGroup(editName);

    }

}
