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
    @FindBy(xpath = "(//button[text()=\"Pokaż role \"])[last()]")
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

    @FindBy(id = "AG_option")
    WebElement role;

    @FindBy(xpath = "(//*[contains(@id, \"role_\")])[1]")
    WebElement assertUserRole;

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

        lnkPrivileges.click();
    }

    public void clickOnSmsVerifyResetPassword() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerResetPassword));

        chooseSmsVerResetPassword.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_1[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerMassChange));

        chooseSmsVerMassChange.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_3[class*='mat-checkbox-checked']")));

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

        chooseSmsVerDownloadReport.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_11[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyDeleteReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteReport));

        chooseSmsVerDeleteReport.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_12[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyDeleteAuditReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerDeleteAuditReport));

        chooseSmsVerDeleteAuditReport.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_13[class*='mat-checkbox-checked']")));

    }

    public void clickOnSmsVerifySaveGlobalParameter() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerSaveGlobalParameter));

        chooseSmsVerSaveGlobalParameter.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_16[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifySaveAndDeleteUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerSaveAndDeleteUser));

        chooseSmsVerSaveAndDeleteUser.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_17[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyOppb() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerOppb));

        chooseSmsVerOppb.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_19[class*='mat-checkbox-checked']")));

    }

    public void clickOnSmsVerifyGenerateKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerGenerateKey));

        chooseSmsVerGenerateKey.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_20[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyCreateWhiteAndBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerCreateWhiteAndBlackList));

        chooseSmsVerCreateWhiteAndBlackList.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_21[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyAddWhiteAndBlackListToUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddWhiteAndBlackListToUser));

        chooseSmsVerAddWhiteAndBlackListToUser.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_22[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyBuyFunctional() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerBuyFunctional));

        chooseSmsVerBuyFunctional.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_25[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyAddAndDeleteRoleWithGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerAddAndDeleteRoleWithGroup));

        chooseSmsVerAddAndDeleteRoleWithGroup.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_29[class*='mat-checkbox-checked']")));

    }

    public void clickOnSmsVerifyPermissionConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerPermissionConfiguration));

        chooseSmsVerPermissionConfiguration.click();


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

        chooseSmsVerRecIn.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_34[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyRecOut() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerRecOut));

        chooseSmsVerRecOut.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_35[class*='mat-checkbox-checked']")));

    }
    public void clickOnSmsVerifyUseTags() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSmsVerUseTags));

        chooseSmsVerUseTags.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send_sms_36[class*='mat-checkbox-checked']")));

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

        clearbutton.click();
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


        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));



        String name = assertRoleName.getText();


            assertEquals(name, user);


    }

    @Step("assertDeleteUser")
    public void assertDeleteUser(String user) throws AWTException {
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
          webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();


    }

    @Step("clickOnShowRoleButton")
    public void clickOnShowRoleButton() {



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
    }

    @Step("clickOnAddAssignmentButton")
    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();

    }

    @Step("selectRole")
    public void selectRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRole));
        selectRole.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(role));
        role.click();

    }

    @Step("clickAddRoleButton")
    public void clickAddRoleButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();
    }

    @Step("assertionAddRoleForUser")
    public void assertionAddRoleForUser(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(assertUserRole));
        String userRola = assertUserRole.getText();
        assertEquals(userRola,"Admin Główny");
    }





    @Step("clickIntoCertificateButton")
    public void clickIntoCertificateButton(){



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }

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