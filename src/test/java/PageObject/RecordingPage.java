package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

public class RecordingPage {

    @FindBy(id = "recording_list_link")
    WebElement recordingTab;

    @FindBy(id = "deletedRecordings")
    WebElement lnkDeleteRec;
    @FindBy(id = "headingOne")
    WebElement filterCriteria;
    @FindBy(id = "numberHeader")
    WebElement filterNumber;
    @FindBy(id = "mainNumber")
    WebElement filterNumberField;

    @FindBy(xpath= "(//*[contains(@id,'_edit_tags')])[1]")
    WebElement editTags;
    @FindBy(xpath= "(//*[contains(@id,'_edit_tags')])[2]")
    WebElement editTagsUssd;



    @FindBy(css = "[role=\"dialog\"] label[class*=checkbox]")
    WebElement tagsField;
    @FindBy(id = "save_button")
    WebElement saveEditTagsButton;
    @FindBy(id = "add_new_tag")
    WebElement addTag;
/////////////////
    @FindBy(xpath = "(//mat-checkbox[contains(@id,\"mat-checkbox-\")])[1]//label")
    WebElement chooseRec;
    @FindBy(xpath = "(//mat-checkbox[contains(@id,\"mat-checkbox-\")])[last()]")
    WebElement chooseLastRec;
    @FindBy(xpath = "(//button[text()=\"Pobierz nagranie\"])")
    WebElement btnDownloadRec;
    @FindBy(xpath = "(//button[text()=\"Usuń nagranie\"])")
    WebElement btnDeleteRec;
    @FindBy(xpath = "(//button[text()=\"Zablokuj nagranie\"])")
    WebElement btnLockRec;
    @FindBy(xpath = "(//button[text()=\"Odblokuj nagranie\"])")
    WebElement btnUnlockRec;
    @FindBy(id = "filterValueRecordings_placeholder")
    WebElement searchField;
    @FindBy(xpath = "(//button[text()=\" Wyszukaj\"])")
    WebElement btnSearch;
    @FindBy(xpath = "(//input[contains(@id, \"mat-input-\")])[last()]")
    WebElement passwordField;
    @FindBy(css="mat-dialog-container [class=\"mat-dialog-actions\"]>button:nth-of-type(2)")
    WebElement btnSubmitPassword;
    @FindBy(id = "password-recordings-play")
    WebElement btnSubmitPasswordRec;
    @FindBy(id = "password-recordings-cancel")
    WebElement btnCancelPassword;

    @FindBy(css = "mat-select[placeholder=\"Status\"]")
    WebElement selectRecStatus;
    @FindBy(xpath = "//mat-option[2]")
    WebElement chooseStatus;

    @FindBy(id = "internalCallSection")
    WebElement selectInternalConnection;
    @FindBy(xpath = "(//span[text()=\"Nie\"])")
    WebElement chooseInternalConnectionAsFalse;

    @FindBy(id = "filter_button")
    WebElement btnFilter;
    @FindBy(className = "element-row mat-row ng-tns-c62-329 ng-star-inserted")
WebElement validSearchRec;
    @FindBy(xpath = "(//*[contains(@class,'locked mat')])[2]/div/span")
    WebElement validationLock;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox-checked\")])[last()]")
    WebElement validationTags;
    @FindBy(css = "[class='mat-paginator-range-label']")
    WebElement validateQuantityReport;
    @FindBy(xpath = "//*[contains(@class,'duration-cell cell-style mat-cell cdk-column-internalCall')]")
    private List <WebElement> listInternalConnection;
    @FindBy(css = "[class*='description-cell cell-style mat-cell cdk-column-status']")
    private List <WebElement> listStatus;

    @FindBy(id = "visible_columns_button")
    WebElement visibleColumnsButton;
    @FindBy(id = "select_all_button")
    WebElement showAllColumns;
    @FindBy(id = "pick_button")
    WebElement confirmShowAllColumns;

    @FindBy(xpath = "(//*[contains(@class, \"playRec\")]//span)[1]")
    WebElement btnPlayRec;
    @FindBy(css = "[class*=\"play-pause\"]")
    WebElement btnStartAndStopPlayRec;
    @FindBy(css = "[role=\"dialog\"]>app-app-error>p")
    WebElement txtDialogInformation;

    /////////////////
    @FindBy(id = "phoneCalls")
    WebElement lnkPhoneCalls;

    @FindBy(css = "mat-cell[class*=\"isRecorded\"]")
    List<WebElement> listIsRec;
    @FindBy(css = "[formcontrolname=\"isRecorded\"]")
    WebElement selectListIsRec;

    @FindBy(css = "mat-cell[class*=\"isVip\"]")
    List<WebElement> listIsvipIvr;
    @FindBy(css = "[formcontrolname=\"isVipivr\"]")
    WebElement selectListIsVip;


    @FindBy(css = "[role=\"option\"]:nth-of-type(2)")
    WebElement chooseOptionNumber2;




    private WebDriver driver;
    public RecordingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnRecordingTab")

    public void clickOnRecordingTab(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog-\"]")));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingTab));
        recordingTab.click();
    }

    public void clickOnDeleteRecording(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog-\"]")));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkDeleteRec));
        lnkDeleteRec.click();
    }
    public void selectAllColumns(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        Actions actions=new Actions(driver);
        actions.moveToElement(visibleColumnsButton).click().build().perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        actions.moveToElement(showAllColumns).click().build().perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        actions.moveToElement(confirmShowAllColumns).click().build().perform();


    }


    public void verifyTooltipNotAllowedDeleteRec(String tooltip){
        WebElement element = driver.findElement(By.cssSelector("#cdk-describedby-message-container"));
        String content = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", element);
        System.out.println(content);
assertTrue(content.contains(tooltip));

    }

//    public void clickOnButtonfilterCriteria(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterCriteria));
//        filterCriteria.click();
//    }

//    public void clickOnButtonFilterNumber(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumber));
//        filterNumber.click();
//    }
//    public void typeIntoFilterNumberField(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumberField));
//        filterNumberField.sendKeys("48222903841");
//    }
//    public void clickOnFilterButton(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
//        filter.click();
//    }

    @Step("clickOnEditTagsButton")

    public void clickOnEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTags));

       editTags.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog-\"]")));



    }

    public void clickOnEditTagsUssdButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTagsUssd));

        editTagsUssd.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog-\"]")));



    }

    @Step("typeIntoEditTagsField")

    public void clickTagsCheckbox(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(tagsField));
tagsField.click();

    }
    @Step("clickOnSaveEditTagsButton")

    public void clickOnSaveEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveEditTagsButton));
        saveEditTagsButton.click();

    }

    public void validationAddTagForRec(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationTags));
        String classAtr = validationTags.getAttribute("class");

        assertTrue(classAtr.contains("mat-checkbox-checked"));
Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog-\"]")));

    }

    public void validationDeleteTagRec() {

        java.util.List<WebElement> elements=driver.findElements(By.xpath("(//*[contains(@class,\"mat-checkbox-checked\")])[last()]"));
        Assert.assertTrue(elements.isEmpty());

    }


    public void chooseRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRec));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", chooseRec);
      //chooseRec.click();
    }
    public void chooseLastRecordingWithList(){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRec));
            chooseRec.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRec));
            chooseRec.click();
        }

    }
    public void downloadRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDownloadRec));
        btnDownloadRec.click();
    }
    public void deleteRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteRec));
        btnDeleteRec.click();
    }
    public void trydDeleteRecordingWithList(){

        assertFalse(btnDeleteRec.isEnabled());
        Actions actions=new Actions(driver);
        actions.moveToElement(btnDeleteRec).clickAndHold(btnDeleteRec).build().perform();
    }

    public String validateQuantityReportBefore() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(validateQuantityReport));
        String quantity = validateQuantityReport.getText();


        String  foo = quantity;
        System.out.println(foo);
        return foo;
    }
    public void validateQuantityReportAfter(String beforeValue) {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(validateQuantityReport));
        String quantity = validateQuantityReport.getText();

        System.out.println(quantity);
        String after=quantity;
        assertNotEquals(beforeValue,after);

    }

    public void validateQuantityReportNotValid(String beforeValue) {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(validateQuantityReport));
        String quantity = validateQuantityReport.getText();

        System.out.println(quantity);
        String after=quantity;
        assertEquals(beforeValue,after);

    }
    public void lockRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnLockRec));
        btnLockRec.click();
    }
    public void unlockRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnUnlockRec));
        btnUnlockRec.click();
    }
    public void validationUnlock(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationLock));
        String unlock = validationLock.getText();
        System.out.println(unlock);
        assertEquals(unlock, "lock_open");
    }

    public void clickPlayRecButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnPlayRec));
        btnPlayRec.click();
    }
    public void verifyPlayRecDialog(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(btnStartAndStopPlayRec));
        btnStartAndStopPlayRec.isDisplayed();

        driver.navigate().refresh();

    }
    public void validationLock(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationLock));
        String unlock = validationLock.getText();
        System.out.println(unlock);
        assertEquals(unlock, "lock");
    }
    public void searchRecordingWithList(String nameRec){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(nameRec);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        btnSearch.click();
    }
    public void validationSearchRec(){


        String newRec= validSearchRec.toString();
        System.out.println(newRec);
        assertNotNull(newRec);
    }


    public void operationAutorization(String pass){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(passwordField));
        passwordField.clear();
        passwordField.sendKeys(pass);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(btnSubmitPassword));
        btnSubmitPassword.click();

    }
    public void operationAutorizationPlayRec(String pass){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(passwordField));
        passwordField.clear();
        passwordField.sendKeys(pass);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(btnSubmitPasswordRec));
        btnSubmitPasswordRec.click();

    }

    public void clickOnPhoneCallsTab(){

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(lnkPhoneCalls));
            lnkPhoneCalls.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(lnkPhoneCalls));
            lnkPhoneCalls.click();
        }
    }

    public void verifyWrongPassword(){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(txtDialogInformation));
            txtDialogInformation.isDisplayed();
            assertEquals(txtDialogInformation.getText(), "Błędne hasło.");
            Actions actions=new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(txtDialogInformation));
            txtDialogInformation.isDisplayed();
            assertEquals(txtDialogInformation.getText(), "Błędne hasło.");
            Actions actions=new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).perform();
        }


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
    public void verifyDownloadFile(String downloadPath) {


        File folder = new File(downloadPath);

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                String name = "";
                if (fileName.contains(".zip")) {

                    Assert.assertTrue(fileName.contains(".zip"));

                    listOfFile.delete();
                }
            }
        }
    }

    public void filterRecordingWithListByType(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRecStatus));
        selectRecStatus.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseStatus));
        chooseStatus.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        btnFilter.click();
    }
    public void filterRecordingWithListByInternalConnection(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectInternalConnection));
        Actions actions=new Actions(driver);
        actions.moveToElement(selectInternalConnection).click().build().perform();
        //selectInternalConnection.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseInternalConnectionAsFalse));
        actions.moveToElement(chooseInternalConnectionAsFalse).click().build().perform();
       // chooseInternalConnectionAsTrue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        actions.moveToElement(btnFilter).click().build().perform();
      //  btnFilter.click();
    }

    public void filterPhoneCallsByIsRecording(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectListIsRec));
        Actions actions=new Actions(driver);
        actions.moveToElement(selectListIsRec).click().build().perform();
        //selectInternalConnection.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseOptionNumber2));
        actions.moveToElement(chooseOptionNumber2).click().build().perform();
        // chooseInternalConnectionAsTrue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        actions.moveToElement(btnFilter).click().build().perform();
        //  btnFilter.click();
    }
    public void filterPhoneCallsByIsVip(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectListIsVip));
        Actions actions=new Actions(driver);
        actions.moveToElement(selectListIsVip).click().build().perform();
        //selectInternalConnection.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseOptionNumber2));
        actions.moveToElement(chooseOptionNumber2).click().build().perform();
        // chooseInternalConnectionAsTrue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        actions.moveToElement(btnFilter).click().build().perform();
        //  btnFilter.click();
    }
public void validationInternalConnection(){

    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

    try {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(listInternalConnection.get(0)));

        for (WebElement x : listInternalConnection) {
            System.out.println(x.getText());
            assertEquals(x.getText(),"Nie");
        }
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(listInternalConnection.get(0)));

        for (WebElement x : listInternalConnection) {
            System.out.println(x.getText());
            assertEquals(x.getText(),"Nie");
        }
    }

}
    public void validationCallsPhoneIsRec(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(listIsRec.get(0)));

            for (WebElement x : listIsRec) {
                System.out.println(x.getText());
                assertEquals(x.getText(),"Tak");
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(listIsRec.get(0)));

            for (WebElement x : listIsRec) {
                System.out.println(x.getText());
                assertEquals(x.getText(),"Tak");
            }
        }

    }

    public void validationCallsPhoneIsVip(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));

            if(!listIsvipIvr.isEmpty()){
            for (WebElement x : listIsvipIvr) {
                System.out.println(x.getText());
                assertEquals(x.getText(),"Nie");
            }}
            else {
                System.out.println("Brak połączeń dla tego filtra");
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));

            if(!listIsvipIvr.isEmpty()){
                for (WebElement x : listIsvipIvr) {
                    System.out.println(x.getText());
                    assertEquals(x.getText(),"Nie");
                }}
            else {
                System.out.println("Brak połączeń dla tego filtra");
            }
        }

    }
    public void validationRecStatus(String status){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(listStatus.get(0)));

            for (WebElement x : listStatus) {
                System.out.println(x.getText());
                assertEquals(x.getText(),status);
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(listStatus.get(0)));

            for (WebElement x : listStatus) {
                System.out.println(x.getText());
                assertEquals(x.getText(),status);
            }
        }

    }
}


