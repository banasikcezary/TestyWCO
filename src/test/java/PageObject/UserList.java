package PageObject;

import Tests.deleteRecording;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static org.testng.Assert.*;
public class UserList {
    @FindBy(id = "user_list_link")
    WebElement userListLink;
    @FindBy(id = "filterValue_placeholder")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[5][text()=\"KarolN\"]")
    WebElement checkList;

    @FindBy(id = "fana_select_checkbox")
    WebElement checkbox;
    @FindBy(id = "export_csv_button")
    WebElement exportCsvButton;
    @FindBy(id = "import_csv_button")
    WebElement importCsv;
    @FindBy(id = "file")
    WebElement chooseFileButton;
    @FindBy(id = "send_button")
    WebElement sendFileButton;

    @FindBy(id = "visible_columns_button")
    WebElement visibleColumnsButton;
    @FindBy(id = "select_all_button")
    WebElement showAllColumns;
    @FindBy(id = "pick_button")
    WebElement confirmShowAllColumns;

    ///////////////////////////////////////////

    @FindBy(id = "recDirectlyIncoming_edit_button")
    WebElement btnEditRecDirectlyIncoming;
    @FindBy(id = "recOutgoing_edit_button")
    WebElement btnEditRecOutgoing;
    @FindBy(id = "canSwitchOffRecOutgoing_edit_button")
    WebElement btnEditSwitchOffRecOutgoing;
    @FindBy(id = "directIncomingCalls_edit_button")
    WebElement btnEditOppb;
    @FindBy(id = "organizationalUnit_edit_button")
    WebElement btnEditOrganizationalUnit;
    @FindBy(id = "blacklist_edit_button")
    WebElement btnEditBlackList;
    @FindBy(id = "context_edit_button")
    WebElement btnEditWhiteList;

    @FindBy(xpath = "//*[@id=\"integracja\"]/div/div/div/div[1]/li/a[1]")
    WebElement temat;

    @FindBy(id = "change_from_select")
    WebElement changeValueFrom;
    @FindBy(id = "change_to_select")
    WebElement changeValueTo;

    @FindBy(id = "change_from_option_Nie")
    WebElement changeValueFromNot;
    @FindBy(id = "change_to_option_Tak")
    WebElement changeValueToYes;
    @FindBy(id = "save_button")
    WebElement btnSave;

    @FindBy(css = "label[for='new_value_checkbox-input']")
    WebElement checkboxNewValue;
    @FindBy(id = "new_value_input")
    WebElement newValueOrganizationUnit;

    @FindBy(css = "[id='add_list_operation'] .mat-radio-label")
    WebElement massAddList;
    @FindBy(id = "delete_list_operation-input")
    WebElement massDeleteList;

    @FindBy(xpath = "(//div[text()=\" BlackListaTest \"])")
    WebElement chooseBlackList;
    @FindBy(xpath = "(//div[text()=\" WhiteListaTest \"])")
    WebElement chooseWhiteList;



    private WebDriver driver;
    public UserList(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickIntoUserListLink")

    public void clickIntoUserListLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userListLink));
        userListLink.click();}
    @Step("typeIntoSearchfield")
    public void typeIntoSearchfield(String searchUser){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(searchUser);
    searchField.sendKeys(Keys.ENTER);}
    @Step("checkIfTheUserYouAreLookingForExists")
    public void checkIfTheUserYouAreLookingForExists(String user){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertEquals(checkList.getText(), user);
            System.out.println(checkList.getText());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }

        }
    @Step("clickOnUser")
    public void clickOnUser(){
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkList));
            Actions action = new Actions(driver);
            action.moveToElement(checkList).click().build().perform();
    }
    @Step("clickOnCheckboxUSR")
    public void clickOnCheckboxUSR(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkbox));

        checkbox.click();
    }
    @Step("clickOnButtonExportToCsv")
    public void clickOnButtonExportToCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(exportCsvButton));
//        Actions action = new Actions(driver);
//        action.moveToElement(exportCsvButton).click().build().perform();
        exportCsvButton.click();
    }

    public void waitForFileDownloaded(String fileName, int timeoutSeconds, String downloadPath) {
        //
        Logger logger = LoggerFactory.getLogger(deleteRecording.class);


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
                String name="";
                if (fileName.contains("fileName")) {

                    assertTrue(fileName.contains("fileName"));

               listOfFile.delete();
                }
            }
        }


    }
    @Step("clickOnButtonImportCsv")
    public void clickOnButtonImportCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(importCsv));
        importCsv.click();
    }
    @Step("clickOnButtonChooseFile")
    public void clickOnButtonChooseFile(String lokalizacja){

        chooseFileButton.sendKeys(lokalizacja);
    }
    @Step("clickOnButtonSendFileToApp")
    public void clickOnButtonSendFileToApp(){

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendFileButton));
        sendFileButton.click();
    }


    public void selectAllColumns(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        visibleColumnsButton.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        showAllColumns.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        confirmShowAllColumns.click();

    }

    public void clickOnButtonEditRecDirectlyIncoming(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecDirectlyIncoming));
            btnEditRecDirectlyIncoming.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecDirectlyIncoming));
            btnEditRecDirectlyIncoming.click();
        }
    }
    public void clickOnEditRecOutgoing(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecOutgoing));
            btnEditRecOutgoing.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecOutgoing));
            btnEditRecOutgoing.click();
        }
    }
    public void clickOnEditSwitchOffRecOutgoing(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditSwitchOffRecOutgoing));
            btnEditSwitchOffRecOutgoing.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditSwitchOffRecOutgoing));
            btnEditSwitchOffRecOutgoing.click();
        }
    }
    public void clickOnEditOppb(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOppb));
            btnEditOppb.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOppb));
            btnEditOppb.click();
        }
    }
    public void clickOnEditOrganizationalUnit(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOrganizationalUnit));
            btnEditOrganizationalUnit.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOrganizationalUnit));
            btnEditOrganizationalUnit.click();
        }
    }
    public void clickOnEditBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditBlackList));
            btnEditBlackList.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditBlackList));
            btnEditBlackList.click();
        }
    }
    public void clickOnEditWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditWhiteList));
            btnEditWhiteList.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditWhiteList));
            btnEditWhiteList.click();
        }
    }

    public void clickOn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(temat));
        temat.click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
    }

    public void setValueFromNotToYesMassChange(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFrom));
        changeValueFrom.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFromNot));
        changeValueFromNot.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueTo));
        changeValueTo.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueToYes));
        changeValueToYes.click();

    }
    public void clickOnSaveBtn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
    }

    public void setValueForOrganizationUnitMassChange(String value){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxNewValue));
        checkboxNewValue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newValueOrganizationUnit));
        newValueOrganizationUnit.sendKeys(value);

    }

    public void addBlackListMassChange(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massAddList));
        Actions action=new Actions(driver);
        action.moveToElement(massAddList).click().build().perform();
        //massAddList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseBlackList));
        chooseBlackList.click();

    }

    public void addWhiteListMassChange(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massAddList));
        massAddList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseWhiteList));
        chooseWhiteList.click();

    }


}
