package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.*;

public class UserAndPermissions {

    @FindBy(id = "privileges_component_link")
    WebElement userAndPermission;
    @FindBy(id = "users")
    WebElement users;
    @FindBy(id = "add_user_button")
    WebElement addUserButton;
    @FindBy(id = "add_login")
    WebElement loginField;
    @FindBy(id = "add_first_name")
    WebElement firstNameField;
    @FindBy(id = "add_last_name")
    WebElement lastNameField;
    @FindBy(id = "add_email")
    WebElement emailField;
    @FindBy(id = "add_phone")
    WebElement phoneField;
    @FindBy(id = "user_add")
    WebElement saveUserButton;
    @FindBy(id = "filter_value_input")
    WebElement searchUserField;
    @FindBy(id = "search_button")
    WebElement searchButton;
    @FindBy(id = "roles_0")
    WebElement showRoleButton;
    @FindBy(id = "add_assignment_button")
    WebElement addAssignmentButton;
    @FindBy(id = "choose_role")
    WebElement selectRole;
    @FindBy(id = "privilege_add")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń \"])[last()]")
    WebElement deleteUser;
    @FindBy(xpath = "//p[contains(text(),'KarolN')]")
    WebElement assertRoleName;
    @FindBy(id = "page_message")
    WebElement pageMessage;



    @FindBy(css = "[id*=role_]")
    private java.util.List<WebElement> assertUserRole;

    @FindBy(id = "next_page_button")
    WebElement btnNextPage;


    @FindBy (xpath = "(//button[text()=\" Certyfikat \"])[last()]")
    WebElement btnCertificate;
    @FindBy(xpath = "(//input[@type=\"file\"])[last()]")
    WebElement addCertificate;
    @FindBy(xpath = "(//button[text()=\"Pobierz\"])[last()]")
    WebElement downloadCert;

    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteCert;

    @FindBy(id = "clear_button")
    WebElement clearbutton;
    @FindBy(id = "privileges")
    WebElement lnkPrivileges;
    ///////////////// SMS //////////
    @FindBy(css = "#send_sms_1")
    WebElement chooseSmsVerResetPassword;
    @FindBy(css = "#send_sms_3")
    WebElement chooseSmsVerMassChange;
    @FindBy(css = "#send_sms_6")
    WebElement chooseSmsVerListenRec;
    @FindBy(css = "#send_sms_7")
    WebElement chooseSmsVerDownloadRec;
    @FindBy(css = "#send_sms_8")
    WebElement chooseSmsVerDeleteRec;
    @FindBy(id = "send_sms_11")
    WebElement chooseSmsVerDownloadReport;
    @FindBy(id = "send_sms_12")
    WebElement chooseSmsVerDeleteReport;
    @FindBy(id = "send_sms_13")
    WebElement chooseSmsVerDeleteAuditReport;
    @FindBy(id = "send_sms_16")
    WebElement chooseSmsVerSaveGlobalParameter;
    @FindBy(id = "send_sms_17")
    WebElement chooseSmsVerSaveAndDeleteUser;
    @FindBy(id = "send_sms_19")
    WebElement chooseSmsVerOppb;
    @FindBy(id = "send_sms_20")
    WebElement chooseSmsVerGenerateKey;
    @FindBy(id = "send_sms_21")
    WebElement chooseSmsVerCreateWhiteAndBlackList;
    @FindBy(id = "send_sms_22")
    WebElement chooseSmsVerAddWhiteAndBlackListToUser;

    @FindBy(id = "send_sms_25")
    WebElement chooseSmsVerBuyFunctional;
    @FindBy(id = "send_sms_29")
    WebElement chooseSmsVerAddAndDeleteRoleWithGroup;
    @FindBy(id = "send_sms_30")
    WebElement chooseSmsVerPermissionConfiguration;

    @FindBy(id = "send_sms_33")
    WebElement chooseSmsVerAbilityToDisableRecording;

    @FindBy(id = "send_sms_34")
    WebElement chooseSmsVerRecIn;
    @FindBy(id = "send_sms_35")
    WebElement chooseSmsVerRecOut;

    @FindBy(id = "send_sms_36")
    WebElement chooseSmsVerUseTags;







    @FindBy(css = "#reset_1")
    WebElement btnResetPassword;



    private WebDriver driver;

    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnUserAndPermissionButton")

    public void clickOnUserAndPermissionButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userAndPermission));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(userAndPermission).click().build().perform();
        //  userAndPermission.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", userAndPermission);

    }

    @Step("clickOnUserButton")
    public void clickOnUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(users));
        Actions actions = new Actions(driver);
        actions.moveToElement(users).click().build().perform();
    }

    @Step("clickOnAddUserButton")
    public void clickOnAddUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addUserButton));

        addUserButton.click();
    }
    public void clickOnLinkPrivilleges() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkPrivileges));
        Actions actions=new Actions(driver);
        actions.moveToElement(lnkPrivileges).click().build().perform();
        if (lnkPrivileges.isDisplayed())
            actions.moveToElement(lnkPrivileges).click().build().perform();

    }

    public void clickOnSmsVerifyResetPassword() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerResetPassword));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_1[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerResetPassword).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_1[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyResetPassword() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerResetPassword));

        chooseSmsVerResetPassword.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_1[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerMassChange));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_3[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerMassChange).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_3[class*='mat-checkbox-checked']")));
        }

    }
    public void turnOffSmsVerifyMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerMassChange));

        chooseSmsVerMassChange.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_3[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyListenRec() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerListenRec));

        chooseSmsVerListenRec.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_6[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyDownloadRec() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDownloadRec));

        chooseSmsVerDownloadRec.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_7[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyDeleteRec() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteRec));

        chooseSmsVerDeleteRec.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_8[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyDownloadReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDownloadReport));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_11[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerDownloadReport).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_11[class*='mat-checkbox-checked']")));
        }
    }


    public void turnOffSmsVerifyDownloadReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

        chooseSmsVerDownloadReport.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_11[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyDeleteReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteReport));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_12[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerDeleteReport).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_12[class*='mat-checkbox-checked']")));
        }
    }



    public void turnOffSmsVerifyDeleteReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteReport));

        chooseSmsVerDeleteReport.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_12[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyDeleteAuditReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteAuditReport));

        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_13[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerDeleteAuditReport).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_13[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyDeleteAuditReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteAuditReport));

        chooseSmsVerDeleteAuditReport.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_13[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }

    public void clickOnSmsVerifySaveGlobalParameter() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerSaveGlobalParameter));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_16[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerSaveGlobalParameter).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_16[class*='mat-checkbox-checked']")));
        }
    }
    public void turnOffSmsVerifySaveGlobalParameter() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

        chooseSmsVerSaveGlobalParameter.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_16[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifySaveAndDeleteUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerSaveAndDeleteUser));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_17[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerSaveAndDeleteUser).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_17[class*='mat-checkbox-checked']")));
        }

    }
    public void turnOffSmsVerifySaveAndDeleteUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerSaveAndDeleteUser));

        chooseSmsVerSaveAndDeleteUser.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_17[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyOppb() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerOppb));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_19[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerOppb).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_19[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyVerifyOppb() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerOppb));

        chooseSmsVerOppb.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_19[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }

    public void clickOnSmsVerifyGenerateKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerGenerateKey));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_20[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerGenerateKey).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_20[class*='mat-checkbox-checked']")));
        }

    }


    public void turnOffSmsVerifyGenerateKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerGenerateKey));

        chooseSmsVerGenerateKey.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_20[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyCreateWhiteAndBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerCreateWhiteAndBlackList));



        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_21[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerCreateWhiteAndBlackList).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_21[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyCreateWhiteAndBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerCreateWhiteAndBlackList));

        chooseSmsVerCreateWhiteAndBlackList.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_21[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyAddWhiteAndBlackListToUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddWhiteAndBlackListToUser));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_22[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerAddWhiteAndBlackListToUser).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_22[class*='mat-checkbox-checked']")));
        }

    }

    public void turnOffSmsVerifyAddWhiteAndBlackListToUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

        chooseSmsVerAddWhiteAndBlackListToUser.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_22[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }


    public void clickOnSmsVerifyBuyFunctional() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerBuyFunctional));



        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_25[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerBuyFunctional).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_25[class*='mat-checkbox-checked']")));
        }
    }
    public void turnOffSmsVerifyBuyFunctional() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerBuyFunctional));

        chooseSmsVerBuyFunctional.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_25[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyAddAndDeleteRoleWithGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_29[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerAddAndDeleteRoleWithGroup).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_29[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyAddAndDeleteRoleWithGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

       chooseSmsVerAddAndDeleteRoleWithGroup.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_29[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }

    public void clickOnSmsVerifyPermissionConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerPermissionConfiguration));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_30[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerPermissionConfiguration).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_30[class*='mat-checkbox-checked']")));
        }

    }

    public void turnOffSmsVerifyPermissionConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerPermissionConfiguration));

        chooseSmsVerPermissionConfiguration.click();

        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_30[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void SmsVerifyPermissionConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_30[class*='mat-checkbox']")));

    }
    public void clickOnSmsVerifyAbilityToDisableRecording() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAbilityToDisableRecording));

        chooseSmsVerAbilityToDisableRecording.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_33[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyRecIn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerRecIn));



        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_34[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerRecIn).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_34[class*='mat-checkbox-checked']")));
        }

    }
    public void turnOffSmsVerifyRecIn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerRecIn));

        chooseSmsVerRecIn.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_34[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }

    public void clickOnSmsVerifyRecOut() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerRecOut));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_35[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerRecOut).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_35[class*='mat-checkbox-checked']")));
        }
    }

    public void turnOffSmsVerifyRecOut() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerRecOut));

        chooseSmsVerRecOut.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_35[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickOnSmsVerifyUseTags() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerUseTags));


        java.util.List<WebElement> elements= driver.findElements(By.cssSelector("#send_sms_36[class*='mat-checkbox-checked']"));

        if(elements.isEmpty()) {
            Actions actions=new Actions(driver);
            actions.moveToElement(chooseSmsVerUseTags).click().build().perform();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_36[class*='mat-checkbox-checked']")));
        }

    }

    public void turnOffSmsVerifyUseTags() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerUseTags));

        chooseSmsVerUseTags.click();
        java.util.List<WebElement> elements=driver.findElements(By.cssSelector("#send_sms_36[class*='mat-checkbox-checked']"));
        assertTrue(elements.isEmpty());

    }
    public void clickResetPassword() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnResetPassword));
        btnResetPassword.click();

    }
    @Step("clickOnClearButton")
    public void clickOnClearButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clearbutton));

        Actions actions = new Actions(driver);
        actions.moveToElement(clearbutton).click().build().perform();
        // clearbutton.click();
    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginField));
        webDriverWait.ignoring(TimeoutException.class);

        loginField.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    @Step("typeIntoLastName")
    public void typeIntoLastName(String lastName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    @Step("typeIntoEmailField")
    public void typeIntoEmailField(String email) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    @Step("typeIntoPhoneField")
    public void typeIntoPhoneField(String phone) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
    }

    @Step("clickOnSaveNewUserButton")
    public void clickOnSaveNewUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveUserButton));
        saveUserButton.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("assertUser")
    public void assertUser(String user) {
        WebElement searched = driver.findElement(By.xpath("//p[contains(text(),'" + user + "')]"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searched));
        // String name = assertRoleName.getText();
        // assertEquals(name, user);
    }

    @Step("assertDeleteUser")
    public void assertDeleteUser(String user) {
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageMessage));

        String name = pageMessage.getText();
        assertEquals(name, "Nie ma użytkowników");
    }

    @Step("typeIntoSearchUserField")
    public void typeIntoSearchUserField(String searchUser) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchUserField));
        searchUserField.sendKeys(searchUser);
    }

    @Step("clickOnSearchButton")
    public void clickOnSearchButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchButton).click().build().perform();
        actions.moveToElement(searchButton).click().build().perform();

    }

    @Step("clickOnShowRoleButton")
    public void clickOnShowRoleButton() {

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            Actions actions = new Actions(driver);
            actions.moveToElement(showRoleButton).click().build().perform();

        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            Actions actions = new Actions(driver);
            actions.moveToElement(showRoleButton).click().build().perform();

        }
    }

    @Step("clickOnAddAssignmentButton")
    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(addAssignmentButton).click().build().perform();
    }

    @Step("selectRole")
    public void selectRole(String role) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRole));
        selectRole.click();
       WebElement chooseRole= driver.findElement(By.id(role));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRole));
        chooseRole.click();

    }

    @Step("clickAddRoleButton")
    public void clickAddRoleButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();
    }

    @Step("assertionAddRoleForUser")
    public void assertionAddRoleForUser(String value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(assertUserRole));


             assertUserRole
                    .stream()
                    .filter(webElement -> Objects.equals(webElement.getText(), value))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + value));

assertUserRole.forEach(x-> System.out.println(x));

    }





        @Step("clickIntoCertificateButton")
    public void clickIntoCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnCertificate).click().build().perform();
    }


    @Step("clickIntoAddCertificateButton")
    public void clickIntoAddCertificateButton() {

        addCertificate.sendKeys("src/test/java/resources/123.crt");

    }

    @Step("assertAddCertificate")
    public void assertAddCertificate() throws AWTException {
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCert));

        downloadCert.isDisplayed();
    }

    @Step("clickIntoDownloadCertificateButton")
    public void clickIntoDownloadCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCert));
        downloadCert.click();
    }

    public void waitForFileDownloaded(String fileName, int timeoutSeconds, String downloadPath) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until((x) -> {
            File[] files = new File(downloadPath).listFiles();
            for (File file : files) {
                if (file.getName().contains(fileName)) {
                    return true;
                }
            }
            return false;
        });
    }
    public void verifyDownloadFile(String downloadPath){


        File folder = new File(downloadPath);

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.contains("123")) {

                    assertTrue(fileName.contains("123"));

                    listOfFile.delete();
                }
            }
        }

    }

    @Step("clickIntoDeleteCertificateButton")
    public void clickIntoDeleteCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteCert));
        deleteCert.click();
    }
}