package Tests;

        import PageObject.LoginPage;
        import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase  {
    @Test
    public void asUserTryNegativeLogintoAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.clickIntoLogInButton();
        loginPage.checkNegativeLoginToApp();
    }

}
