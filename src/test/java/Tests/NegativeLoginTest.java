package Tests;

        import PageObject.LoginPage;
        import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase  {
    @Test
    public void asUserTryNegativeLogintoAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkNegativeLoginToApp();
    }

}
