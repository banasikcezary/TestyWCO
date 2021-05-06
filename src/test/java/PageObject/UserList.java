package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

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
    @FindBy(id = "new_import_csv_button")
    WebElement importNewUserCsv;
    @FindBy(id = "file")
    WebElement chooseFileButton;
    @FindBy(id = "send_button")
    WebElement sendFileButton;
@FindBy(id = "yes_button")
WebElement confirmButton;
    @FindBy(id = "visible_columns_button")
    WebElement visibleColumnsButton;
    @FindBy(id = "select_all_button")
    WebElement showAllColumns;
    @FindBy(id = "pick_button")
    WebElement confirmShowAllColumns;

    @FindBy(css = "#select_header")
    WebElement cbxSelectAlluser;

    ///////////////////////////////////////////

    @FindBy(id = "recDirectlyIncoming_edit_button")
    WebElement btnEditRecDirectlyIncoming;
    @FindBy(id = "recOutgoing_edit_button")
    WebElement btnEditRecOutgoing;
    @FindBy(id = "status_edit_button")
    WebElement btnEditStatus;
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
    @FindBy(id = "change_from_option_Nieaktywny")
    WebElement changeValueFromNotActive;
    @FindBy(id = "change_to_option_Aktywny")
    WebElement changeValueToActive;
    @FindBy(id = "save_button")
    WebElement btnSave;

    @FindBy(css = "label[for='new_value_checkbox-input']")
    WebElement checkboxNewValue;
    @FindBy(id = "new_value_input")
    WebElement newValueOrganizationUnit;

    @FindBy(css = "[id='add_list_operation'] .mat-radio-label")
    WebElement massAddList;
    @FindBy(css = "[id='delete_list_operation'] .mat-radio-label")
    WebElement massDeleteList;

    @FindBy(xpath = "(//div[text()=\" BlackListaTest \"])")
    WebElement chooseBlackList;
    @FindBy(xpath = "//*[contains(text(),'Czarna Lista')]")
    WebElement chooseMassBlackList;
    @FindBy(xpath = "//*[contains(text(),'Biała lista')]")
    WebElement chooseMassWhiteList;
    @FindBy(css = "[class*='userBlackLists ']>[mattooltipclass=\"multiline-tooltip\"]")
    WebElement verifyMassBlackList;
    @FindBy(css = "[class*='userWhiteLists ']>[mattooltipclass=\"multiline-tooltip\"]")
    WebElement verifyMassWhiteList;
    @FindBy(xpath = "(//div[text()=\" WhiteListaTest \"])")
    WebElement chooseWhiteList;
    @FindBy(css = "mat-row>[class*='description-cell d-flex justify-content-center mat-cell cdk-column-userStatus']")
    private List<WebElement> checkMassStatus;
    @FindBy(css = "mat-row>[class*='duration-cell d-flex justify-content-center mat-cell cdk-column-recordingDirectlyIncomingCalls']")
    private List<WebElement> checkRecordingDirectlyIncomingCalls;
    @FindBy(css = "mat-row>[class*='duration-cell d-flex justify-content-center mat-cell cdk-column-recordingOutgoingCalls']")
    private List<WebElement> checkRecordingOutgoingCalls;
    @FindBy(css = "duration-cell d-flex justify-content-center mat-cell cdk-column-canSwitchOffRecordingOutgoingCalls")
    private List<WebElement> checkCanSwitchOffRecordingOutgoingCalls;
    @FindBy(css = "duration-cell d-flex justify-content-center mat-cell cdk-column-directIncomingCalls")
    private List<WebElement> checkDirectIncomingCalls;
    @FindBy(css = "mat-row>[class*='duration-cell d-flex justify-content-center mat-cell cdk-column-organizationalUnit']")
    private List<WebElement> checkOrganizationalUnit;
    @FindBy(id = "refresh_button")
    WebElement btnRefreshStatus;


    private WebDriver driver;

    public UserList(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickIntoUserListLink")

    public void clickIntoUserListLink() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userListLink));
        userListLink.click();
        List<WebElement> elements=driver.findElements(By.id("visible_columns_button"));
        if(elements.isEmpty()){
            userListLink.click();
        }
    }

    @Step("typeIntoSearchfield")
    public void typeIntoSearchfield(String searchUser) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(searchUser);
        searchField.sendKeys(Keys.ENTER);
    }

    @Step("checkIfTheUserYouAreLookingForExists")
    public void checkIfTheUserYouAreLookingForExists(String user) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertEquals(checkList.getText(), user);
            System.out.println(checkList.getText());
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }

    }

    @Step("clickOnUser")
    public void clickOnUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkList));
        Actions action = new Actions(driver);
        action.moveToElement(checkList).click().build().perform();
    }

    @Step("clickOnCheckboxUSR")
    public void clickOnCheckboxUSR() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkbox));

        checkbox.click();
    }

    @Step("clickOnButtonExportToCsv")
    public void clickOnButtonExportToCsv() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(exportCsvButton));
//        Actions action = new Actions(driver);
//        action.moveToElement(exportCsvButton).click().build().perform();
        exportCsvButton.click();
    }

    public void waitForFileDownloaded(String fileName, int timeoutSeconds, String downloadPath) {
        //
        //  Logger logger = LoggerFactory.getLogger(deleteRecording.class);


        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until((x) -> {
            File[] files = new File(downloadPath).listFiles();
            if (Objects.isNull(files)) {
                return false;
            }
            for (File file : files) {
                if (file.getName().contains(fileName)) {
                    return true;
                }
            }
            return false;
        });
    }

    public void verifyDownloadFile(String downloadPath, String fileNameContains) {


        File folder = new File(downloadPath);

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                String name = fileNameContains;
                if (fileName.contains(fileNameContains)) {

                    assertTrue(fileName.contains(fileNameContains));

                    listOfFile.delete();
                }
            }
        }


    }

    @Step("clickOnButtonImportCsv")
    public void clickOnButtonImportCsv() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(importCsv));
        importCsv.click();
    }

    @Step("clickOnButtonImportCsv")
    public void clickOnButtonImportNewUserCsv() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(importNewUserCsv));
        importNewUserCsv.click();
    }

    @Step("clickOnButtonChooseFile")
    public void clickOnButtonChooseFile(String lokalizacja) {

        chooseFileButton.sendKeys(lokalizacja);
    }

    @Step("clickOnButtonSendFileToApp")
    public void clickOnButtonSendFileToApp() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendFileButton));
        sendFileButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        confirmButton.click();
    }


    public void selectAllColumns() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(visibleColumnsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(visibleColumnsButton));
        visibleColumnsButton.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id*=\"mat-dialog\"]")));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(showAllColumns));
        showAllColumns.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(confirmShowAllColumns));
        confirmShowAllColumns.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id*=\"mat-dialog\"]")));

    }

    public void selectAllUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxSelectAlluser));
        cbxSelectAlluser.click();



        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("mat-checkbox[class*=\"mat-checkbox-checked\"]")));


    }

    public void clickOnButtonEditRecDirectlyIncoming() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecDirectlyIncoming));
            btnEditRecDirectlyIncoming.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecDirectlyIncoming));
            btnEditRecDirectlyIncoming.click();
        }
    }

    public void clickOnEditRecOutgoing() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecOutgoing));
            btnEditRecOutgoing.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditRecOutgoing));
            btnEditRecOutgoing.click();
        }
    }

    public void clickOnEditStatus() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditStatus));
            btnEditStatus.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditStatus));
            btnEditStatus.click();

        }
    }

    public void clickOnEditSwitchOffRecOutgoing() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditSwitchOffRecOutgoing));
            btnEditSwitchOffRecOutgoing.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditSwitchOffRecOutgoing));
            btnEditSwitchOffRecOutgoing.click();
        }
    }

    public void clickOnEditOppb() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOppb));
            btnEditOppb.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOppb));
            btnEditOppb.click();
        }
    }

    public void clickOnEditOrganizationalUnit() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOrganizationalUnit));
            btnEditOrganizationalUnit.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditOrganizationalUnit));
            btnEditOrganizationalUnit.click();
        }
    }

    public void clickOnEditBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditBlackList));
            btnEditBlackList.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditBlackList));
            btnEditBlackList.click();
        }
    }

    public void clickOnEditWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditWhiteList));
            btnEditWhiteList.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnEditWhiteList));
            btnEditWhiteList.click();
        }
    }

    public void clickOn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(temat));
        temat.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    public void setValueFromNotToYesMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFrom));
        changeValueFrom.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFromNot));
        changeValueFromNot.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueTo));
        changeValueTo.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueToYes));
        changeValueToYes.click();

    }

    public void setValueFromNotActiveToActiveMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFrom));
        changeValueFrom.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueFromNotActive));
        changeValueFromNotActive.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueTo));
        changeValueTo.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeValueToActive));
        changeValueToActive.click();

    }

    public void validationValueMassChangeOrganizationalUnit() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[16]")));
        for (int i = 1; i <= checkOrganizationalUnit.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[16]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[16]"));
            String status = element.getText();
            System.out.println(i);

            switch (status) {
                case "Warszawa":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "empty":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[16]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[16]"));
                    String status1 = element1.getText();
                    if (status1.equals("Warszawa")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Warszawa");
                    }
            }

        }


    }

    public void validationValueFromNotToYesMassChangeDirectIncomingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[15]")));
        for (int i = 1; i <= checkDirectIncomingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]"));
            String status = element.getText();
            System.out.println(i);

            switch (status) {
                case "Tak":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Nie":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]"));
                    String status1 = element1.getText();
                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }

        }
    }

    public void validationValueFromYesToNoMassChangeDirectIncomingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[15]")));
        for (int i = 1; i <= checkDirectIncomingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]"));
            String status = element.getText();
            System.out.println(i);

            switch (status) {
                case "Nie":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Tak":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[15]"));
                    String status1 = element1.getText();
                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }

        }
    }
    public void validationValueFromNotToYesMassChangeCanSwitchOffRecordingOutgoingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[14]")));

        for (int i = 1; i <= checkCanSwitchOffRecordingOutgoingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[14]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[14]"));
            String status = element.getText();
            System.out.println(i);


            switch (status) {
                case "Tak":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Nie":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[14]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[14]"));
                    String status1 = element1.getText();
                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }

        }


    }

    public void validationValueFromNotToYesMassChangeRecordingOutgoingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[13]")));
        for (int i = 1; i <= checkRecordingOutgoingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]"));
            String status = element.getText();
            System.out.println(i);


            switch (status) {
                case "Tak":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Nie":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]"));
                    String status1 = element1.getText();
                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }

        }


    }
    public void validationValueFromYesToNoMassChangeRecordingOutgoingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[13]")));
        for (int i = 1; i <= checkRecordingOutgoingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]"));
            String status = element.getText();
            System.out.println(i);


            switch (status) {
                case "Nie":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Tak":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[13]"));
                    String status1 = element1.getText();
                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }

        }


    }
    public void validationValueFromNotToYesMassChangeRecordingDirectlyIncomingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[12]")));

        for (int i = 1; i <= checkRecordingDirectlyIncomingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]"));
            String status = element.getText();
            System.out.println(i);

            switch (status) {
                case "Tak":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Nie":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]"));
                    String status1 = element1.getText();

                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }


        }
    }

    public void validationValueFromYesToNoMassChangeRecordingDirectlyIncomingCalls() {
        driver.navigate().refresh();

        validationValueFromNotActiveToActiveMassChange();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[12]")));

        for (int i = 1; i <= checkRecordingDirectlyIncomingCalls.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]"));
            String status = element.getText();
            System.out.println(i);

            switch (status) {
                case "Nie":
                    System.out.println("Status został zmianiony poprawnie");
                    break;
                case "Tak":
                    driver.navigate().refresh();
                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]")));

                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[12]"));
                    String status1 = element1.getText();

                    if (status1.equals("Tak")) {
                        System.out.println("Udało się");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(status1, "Tak");
                    }
            }


        }
    }

    public void validationLoginInListUser(String nameUser,int usersSize) {


        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[19]")));

        List<WebElement> login = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[5]"));
        System.out.println(login.size());
assertTrue(login.size()==usersSize);
login.forEach(x-> System.out.println(x.getText()));
        if (!login.isEmpty()) {

                login
                        .stream()
                        .filter(webElement -> Objects.equals(webElement.getText(), nameUser))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + nameUser));
            } else {
                driver.navigate().refresh();
                webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[5]")));

                login
                        .stream()
                        .filter(webElement -> Objects.equals(webElement.getText(), nameUser))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + nameUser));

            }


        }











//    public void validationLoginAfterImportNewUserCsv() {
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
//        List<WebElement> login=driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[5]"));
//        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[5]")));
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='user3']")));
//
//        for (int i = login.size(); i <= login.size(); i++) {
//
//            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[5]")));
//
//            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[5]"));
//            String status = element.getText();
//            System.out.println(i);
//
//            switch (status) {
//                case "user3":
//                    System.out.println("Import został wykonany poprawnie");
//                    System.out.println("----------------------------------------------");
//                    break;
//
//                case "":
//                    driver.navigate().refresh();
//                    webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[5]")));
//
//                    WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[5]"));
//                    String status1 = element1.getText();
//
//                    if (status1.equals("user3")) {
//                        System.out.println("Import został wykonany poprawnie");
//                        System.out.println("----------------------------------------------");
//                    } else {
//                        assertEquals(status1, "user3");
//                    }
//            }
//
//
//        }
//    }
    public void validationValueFromNotActiveToActiveMassChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();


        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));
        for (int i = 1; i <= elements.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]"));
            String status = element.getText();
            System.out.println(i);
            switch (status) {
                case "A":
                    System.out.println("Status został zmianiony poprawnie");
                    System.out.println("----------------------------------------------");

                    break;
                case "N":
                    throw new IllegalArgumentException("Wystąpił błąd podczas masowej zmiany, status nie został zmieniony");
                case "WTZ":

                    String value;
                    int numberValue = 0;
                    do {

                        driver.navigate().refresh();

                        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

                        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));
                        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]")));

                        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]"));
                        value = element1.getText();
                        System.out.println(value);

                        numberValue++;
                        System.out.println(numberValue);
                    } while (value.equals("WTZ") && numberValue < 60);

                    if (value.equals("A")) {
                        System.out.println("Status został zmianiony poprawnie");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertEquals(value, "A");
                    }

                    break;
                case "B":
                    throw new IllegalArgumentException("Wystąpił błąd podczas masowej zmiany");
                default: {
                    throw new IllegalArgumentException("Wystąpił błąd podczas masowej zmiany");

                }


            }
        }
    }

    public void validationValueWtzChange() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        }
        List<WebElement> elementsWtz=driver.findElements(By.xpath("(//*[contains(text(),'WTZ')])[1]"));

        if(elementsWtz.isEmpty()){
            int i=0;
            do{
                driver.navigate().refresh();
                elementsWtz=driver.findElements(By.xpath("(//*[contains(text(),'WTZ')])[1]"));

                i++;

            }while (!elementsWtz.isEmpty() || i<10);

        }



        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));
        for (int i = 1; i <= elements.size(); i++) {

            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]")));

            WebElement element = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]"));
            String status = element.getText();
            System.out.println(i);
            switch (status) {
                case "A":
                case "N":
                    System.out.println("Status został zmianiony poprawnie");
                    System.out.println("----------------------------------------------");

                    break;

                case "WTZ":

                    String value;
                    int numberValue = 0;
                    do {

                        driver.navigate().refresh();

                        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

                        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));
                        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]")));

                        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row[" + i + "]/mat-cell[3]"));
                        value = element1.getText();
                        System.out.println(value);

                        numberValue++;
                        System.out.println(numberValue);
                    } while (value.equals("WTZ") && numberValue < 60);

                    if (!value.equals("WTZ")) {
                        System.out.println("Status został zmianiony poprawnie");
                        System.out.println("----------------------------------------------");
                    } else {
                        assertNotEquals(value, "WTZ");
                    }

                    break;
                case "B":
                    throw new IllegalArgumentException("Wystąpił błąd podczas masowej zmiany");
                default: {
                    throw new IllegalArgumentException("Wystąpił błąd podczas masowej zmiany");

                }


            }
        }
    }

    public void validationImportUser() {
        driver.navigate().refresh();
        driver.navigate().refresh();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));

        assertEquals(2, elements.size());

    }

    public int validationImportNewUser() {
        driver.navigate().refresh();
        driver.navigate().refresh();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]")));

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"users_list_mat_table\"]/mat-row/mat-cell[3]"));

        return elements.size();
    }


    public void clickOnSaveBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
    }

    public void setValueForOrganizationUnitMassChange(String value) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxNewValue));
        checkboxNewValue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newValueOrganizationUnit));
        newValueOrganizationUnit.sendKeys(value);

    }

    public void addBlackListMassChange(String lista) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massAddList));
        Actions action = new Actions(driver);
        action.moveToElement(massAddList).click().build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+lista+"')]")));
        driver.findElement(By.xpath("//*[contains(text(),'"+lista+"')]")).click();
    }
    public void deleteBlackListMassChange(String lista) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massDeleteList));
        Actions action = new Actions(driver);
        action.moveToElement(massDeleteList).click().build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+lista+"')]")));
        driver.findElement(By.xpath("//*[contains(text(),'"+lista+"')]")).click();
    }

    public void verifyMassBlackList(String lista){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
     webDriverWait.until(ExpectedConditions.visibilityOf(verifyMassBlackList));
       Actions actions=new Actions(driver);
       actions.clickAndHold(verifyMassBlackList).build().perform();
        String ToolTipText = driver.findElement(By.cssSelector("mat-tooltip-component>div")).getText();

        System.out.println(ToolTipText);

        assertTrue(ToolTipText.contains(lista)
);
    }


    public void verifyDeleteMassBlackList(String lista){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyMassBlackList));
        Actions actions=new Actions(driver);
        actions.clickAndHold(verifyMassBlackList).build().perform();
        List<WebElement> elements=driver.findElements(By.cssSelector("mat-tooltip-component>div"));
if(elements.isEmpty()) {
    webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("mat-tooltip-component>div")));
}else {

    System.out.println(elements.get(0).getText());

    assertFalse(elements.get(0).getText().contains(lista));
}
}

 public void verifyDeleteMassWhiteList(String lista){
     WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
     webDriverWait.until(ExpectedConditions.visibilityOf(verifyMassWhiteList));
     Actions actions=new Actions(driver);
     actions.clickAndHold(verifyMassWhiteList).build().perform();
     List<WebElement> elements=driver.findElements(By.cssSelector("mat-tooltip-component>div"));
     if(elements.isEmpty()) {
         webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("mat-tooltip-component>div")));
     }else {

         System.out.println(elements.get(0).getText());

         assertFalse(elements.get(0).getText().contains(lista));
     }
 }

    public void verifyMassWhiteList(String lista){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyMassWhiteList));
        Actions actions=new Actions(driver);
        actions.clickAndHold(verifyMassWhiteList).build().perform();
        String ToolTipText = driver.findElement(By.cssSelector("mat-tooltip-component>div")).getText();

        System.out.println(ToolTipText);

        assertTrue(ToolTipText.contains(lista)
        );
    }
    public void addWhiteListMassChange(String lista) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massAddList));
        massAddList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+lista+"')]")));
        driver.findElement((By.xpath("//*[contains(text(),'"+lista+"')]"))).click();

    }
    public void deleteWhiteListMassChange(String lista) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(massDeleteList));
        Actions action = new Actions(driver);
        action.moveToElement(massDeleteList).click().build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+lista+"')]")));
        driver.findElement(By.xpath("//*[contains(text(),'"+lista+"')]")).click();
    }

}
