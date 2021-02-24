package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerifyAlertBeforeLog  extends TestBase{


    @Test(priority = 1,
            description = "as User Try Positive Log into Account",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void verifyAlertBeforeLog() {

        Dialog dialog = new Dialog(driver);
        dialog.verifyAlertBeforeLogin("×\n" +
                "Komunikat testowy przed autoryzacja");
    }

}