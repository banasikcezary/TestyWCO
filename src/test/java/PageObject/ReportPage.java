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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class ReportPage {

    @FindBy(id = "reports_list_link")
    WebElement reportButton;
    @FindBy(css = "#headingOne")
    WebElement property;
    @FindBy(id = "heading_cyclic_report")
    WebElement cyclicalReport;
    @FindBy(id = "startReportDate")
    WebElement startReportDate;
    @FindBy(id = "endReportDate")
    WebElement endReportDate;
    @FindBy(xpath = "//*[@id=\"collapseOne\"]/form/button")
    WebElement generateSingleReportButton;
    @FindBy(id = "generate_cyclic_reports")
    WebElement checkboxGenerateReportCyclical;

    @FindBy(id = "number_of_interval_report")
    WebElement generateReportEveryField;
    @FindBy(id = "interval_of_report")
    WebElement selectChooseInterval;

    @FindBy(id = "start_cyclic_report_date")
    WebElement endReportDateForCyclical;
    @FindBy(xpath = "//*[@id=\"collapseCyclicReport\"]/form/button")
    WebElement generateCyclicalReport;

////////////////////////////////////////////////////////////////////
    @FindBy(id = "report5_user_selection")
    WebElement selectionUser5;
    @FindBy(xpath = "//*[contains(text(),'Karol N')]")
    WebElement selectUser5;

    @FindBy(id = "report10_number_selection")
    WebElement selectionMainNumber10;
    @FindBy(xpath = "(//mat-option[contains(@id,'report10_select_')])")
    WebElement selectNumber10;


    @FindBy(id = "report11_number_selection")
    WebElement selectionMainNumber11;
    @FindBy(xpath = "(//mat-option[contains(@id,'report11_select_')])")
    WebElement selectNumber11;

    @FindBy(id = "report12_admin_selection")
    WebElement selectionAdmin12;
    @FindBy(xpath = "//*[contains(text(),'Karol N')]")
    WebElement selectAdmin12;


    @FindBy(id = "report23_user_selection")
    WebElement selectionUser23;
    @FindBy(xpath = "//*[contains(text(),'Karol N')]")
    WebElement selectUser23;

    ////////////////raport num.wew i transfery////
    @FindBy(id = "report5")
    WebElement extensionsNumberAndTransfersReport;
    @FindBy(id = "report_5_startReportDate")
    WebElement startReportDate5;
    @FindBy(id = "report_5_endReportDate")
    WebElement endReportDate5;
    @FindBy(id = "report_5_generate_report_button")
    WebElement generate5;

    @FindBy(id ="report_5_cyclic_checkbox")
    WebElement cbxExtensionsNumberAndTransfersReportCyclic;

    @FindBy(id = "report_5_add_all_button")
    WebElement btnAddAllUsers;
    ////////////////////////////////////////Raporty cykliczne ///////////////////////
    @FindBy(css = "[formcontrolname=\"intervalValue\"]")
    WebElement txtValueIntervalGenerate;
    @FindBy(css = "[formcontrolname=\"periodValue\"]")
    WebElement txtValuePeriodReport;
    @FindBy(id = "cyclicReportInstance")
    WebElement lnkInstanceCyclicalReport;
    @FindBy(css = "[class=\"element-row mat-row ng-star-inserted\"]:first-of-type [class*=description]:nth-of-type(2)")
    WebElement checkLastInstanceCyclicalReport;

    //////////////// nagrania raporty//////////
    @FindBy(id = "report10")
    WebElement recordedCallsReport;
    @FindBy(id = "report_10_startReportDate")
    WebElement startReportDate10;
    @FindBy(id = "report_10_endReportDate")
    WebElement endReportDate10;
    @FindBy(id = "report_10_generate_report_button")
    WebElement generate10;

@FindBy(id = "report_10_cyclic_checkbox")
WebElement recordedCallsReportCyclic;
    ////////////////////// nagrania szczegółowo /////////////
    @FindBy(id = "report11")
    WebElement recordedCallsDetailsReport;
    @FindBy(id = "report_11_startReportDate")
    WebElement startReportDate11;
    @FindBy(id = "report_11_endReportDate")
    WebElement endReportDate11;
    @FindBy(id = "report_11_generate_report_button")
    WebElement generate11;

    @FindBy(id = "report_11_cyclic_checkbox")
    WebElement recordedCallsDetailsReportCyclic;

    ///////////////////// Pobrane pliki ////////////////
    @FindBy(id = "report12")
    WebElement downloadFileReport;

    @FindBy(id = "report_12_startReportDate")
    WebElement startReportDate12;
    @FindBy(id = "report_12_endReportDate")
    WebElement endReportDate12;
    @FindBy(id = "report_12_generate_report_button")
    WebElement generate12;

@FindBy(id = "report_12_cyclic_checkbox")
WebElement fileReportCyclic;

@FindBy(id = "report_12_add_all_button")
WebElement btnAddAllAdmin;
    ////////////////// logi audytowe ////////////////

    @FindBy(id = "report21")
    WebElement auditLogsReport;

    @FindBy(id = "report_21_startReportDate")
    WebElement startReportDate21;
    @FindBy(id = "report_21_endReportDate")
    WebElement endReportDate21;
    @FindBy(id = "report_21_generate_report_button")
    WebElement generate21;

    @FindBy(id = "report_21_config_sftp_connection_checkbox")
    WebElement btnAuditLogsReportCyclic;

//////////////////// logi szczegółowe /////////////

    @FindBy(id = "report22")
    WebElement auditLogsPlusReport;
    @FindBy(id = "report_22_startReportDate")
    WebElement startReportDate22;
    @FindBy(id = "report_22_endReportDate")
    WebElement endReportDate22;
    @FindBy(id = "report_22_generate_report_button")
    WebElement generate22;

    @FindBy(id = "report_22_cyclic_checkbox")
    WebElement btnAuditLogsPlusReportCyclic;

/////////////////// funkcjonalności na userze ///////////////

    @FindBy(id = "report23")
    WebElement functionalityOnUsersReport;
    @FindBy(id = "report_23_startReportDate")
    WebElement startReportDate23;
    @FindBy(id = "report_23_endReportDate")
    WebElement endReportDate23;
    @FindBy(id = "report_23_generate_report_button")
    WebElement generate23;

    @FindBy(id = "report_23_cyclic_checkbox")
    WebElement btnFunctionalityOnUsersReportCyclic;

    @FindBy(id = "report_23_add_all_button")
    WebElement btnAddAllUserFunctionalityReport;
    /////////////// wywołania API /////////////////


    @FindBy(id = "report24")
    WebElement apiCallsReport;
    @FindBy(id = "report_24_startReportDate")
    WebElement startReportDate24;
    @FindBy(id = "report_24_endReportDate")
    WebElement endReportDate24;
    @FindBy(id = "report_24_generate_report_button")
    WebElement generate24;

    /////////////////////////////////


    @FindBy(xpath = "//*[@id=\"report_list\"]/mat-row[1]/mat-cell[2]")
    WebElement assertTypeCreateReport;
    @FindBy(xpath = "//*[@id=\"report_list\"]/mat-row[1]/mat-cell[3]")
    WebElement assertStatusCreateReport;
/////////////////////////////////////////////////////
    ///////////////////////////////
    ////////////////////


    @FindBy(xpath = "(//span[contains(@id, \"_delte_report\")])[1]")
    WebElement btnDeleteLastRaport;

    @FindBy(xpath = "(//span[contains(@id, \"_generate_pdf_report\")])[1]")
    WebElement btnDownloadPDFLastRaport;

    @FindBy(xpath = "(//div[contains(@id, \"_generate_csv_report\")])[1]")
    WebElement btnDownloadCSVLastRaport;

    @FindBy(css = "[class='mat-paginator-range-label']")
    WebElement validateQuantityReport;

    private WebDriver driver;

    public ReportPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickOnReportTab")

    public void clickOnReportTab() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(reportButton));
        reportButton.click();
List<WebElement> elementList=driver.findElements(By.cssSelector("#headingOne"));
        if(elementList.isEmpty()){
            reportButton.click();
        }
    }

    @Step("clickOnProperty")

    public void clickOnProperty() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(property));
        property.click();
    }

    @Step("chooseStartReportDay")

    public void chooseStartReportDay() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate));
        startReportDate.sendKeys("3.05.2020");
    }

    @Step("chooseEndReportDay")

    public void chooseEndReportDay() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate));
        endReportDate.sendKeys("30.05.2020");
    }

    @Step("clickOnButtonGenerateSingletonReport")

    public void clickOnButtonGenerateSingletonReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateSingleReportButton));
        generateSingleReportButton.click();
    }

    @Step("clickOnButtonCyclicalReport")

    public void clickOnButtonCyclicalReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cyclicalReport));
        Actions actions = new Actions(driver);
        actions.moveToElement(cyclicalReport).click().build().perform();
    }

    @Step("clickOncheckboxGenerateReport")

    public void clickOncheckboxGenerateReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGenerateReportCyclical));
        checkboxGenerateReportCyclical.click();
    }

    @Step("clickOnGenerateReportEveryField")

    public void clickOnGenerateReportEveryField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateReportEveryField));
        generateReportEveryField.sendKeys("2");
    }

    @Step("selectChooseInterval")

    public void selectChooseInterval() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(selectChooseInterval));
        Select select = new Select(selectChooseInterval);
        select.selectByIndex(1);
    }

    @Step("typeIntoEndReportDateForCyclical")

    public void typeIntoEndReportDateForCyclical() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDateForCyclical));
        endReportDateForCyclical.sendKeys("31.05.2020");
    }

    @Step("clickOnGenerateCyclicalReport")

    public void clickOnGenerateCyclicalReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateCyclicalReport));
        generateCyclicalReport.click();
    }

    ////////////////////////////// nr. wew. i transfery ////////////////
    @Step("clickOnExtensionsNumberAndTransfersReport")
    public void clickOnExtensionsNumberAndTransfersReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(extensionsNumberAndTransfersReport));
        extensionsNumberAndTransfersReport.click();
    }
    public void clickOnExtensionsNumberAndTransfersReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxExtensionsNumberAndTransfersReportCyclic));
        cbxExtensionsNumberAndTransfersReportCyclic.click();
    }
    public void clickOnRecordedCallsReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordedCallsReportCyclic));
        recordedCallsReportCyclic.click();
    }

    public void clickOnRecordedCallsDetailsReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordedCallsDetailsReportCyclic));
        recordedCallsDetailsReportCyclic.click();
    }

    public void clickOnFileReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(fileReportCyclic));
        fileReportCyclic.click();
    }
    public void chooseAllAdmin(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddAllAdmin));
        btnAddAllAdmin.click();
    }

    public void clickOnAuditLogsReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAuditLogsReportCyclic));
        btnAuditLogsReportCyclic.click();
    }
    public void clickOnAuditLogsPlusReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAuditLogsPlusReportCyclic));
        btnAuditLogsPlusReportCyclic.click();
    }
    public void clickOnFunctionalityOnUsersReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFunctionalityOnUsersReportCyclic));
        btnFunctionalityOnUsersReportCyclic.click();
    }
    public void chooseAllUserForFunctionalityOnUsersReportCyclic(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddAllUserFunctionalityReport));
        btnAddAllUserFunctionalityReport.click();
    }


    @Step("typeInStartReportDateForExtensionsNumberAndTransfersField")
    public void typeInStartReportDateForExtensionsNumberAndTransfersField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate5));
        startReportDate5.sendKeys("1.02.2021");
    }

    @Step("typeInStartReportDateForExtensionsNumberAndTransfersField")
    public void typeInEndReportDateForExtensionsNumberAndTransfersField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate5));
        endReportDate5.sendKeys("2.10.2020");
    }

    @Step("clickInSelectionUser5")
    public void clickInSelectionUser5() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectionUser5));
        selectionUser5.click();
    }
    @Step("clickInSelectUser5")
    public void clickInSelectUser5() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectUser5));
        selectUser5.click();
        driver.findElement(By.xpath("//html")).click();

    }
    public void chooseAllUser5(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddAllUsers));
        btnAddAllUsers.click();
    }

    @Step("typeInStartReportDateForExtensionsNumberAndTransfersField")
    public void clickInGenerateExtensionsNumberAndTransfers() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate5));
        generate5.click();

    }
    ///////////////////// Nagrania   ///////////

    @Step("clickOnRecordedCallsReport")
    public void clickOnRecordedCallsReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordedCallsReport));
        recordedCallsReport.click();
    }

    @Step("typeInStartReportDateForRecordedCallsField")
    public void typeInStartReportDateForRecordedCallsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate10));
        startReportDate10.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForRecordedCallsField")
    public void typeInEndReportDateForRecordedCallsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate10));
        endReportDate10.sendKeys("2.10.2020");
    }
    @Step("clickInSelectionMainNumber10")
    public void clickInSelectionMainNumber10() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectionMainNumber10));
        selectionMainNumber10.click();
    }
    @Step("clickInSelectNumber10")
    public void clickInSelectNumber10() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectNumber10));
        selectNumber10.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("clickInGenerateRecordedCallsField")
    public void clickInGenerateRecordedCalls() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate10));
        generate10.click();
    }
////////////////////////////////////////// połączenia szczegółowo///////

    @Step("clickOnRecordedCallsDetailsReport")
    public void clickOnRecordedCallsDetailsReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordedCallsDetailsReport));
        recordedCallsDetailsReport.click();
    }

    @Step("typeInStartReportDateForRecordedCallsDetailsField")
    public void typeInStartReportDateForRecordedCallsDetailsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate11));
        startReportDate11.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForRecordedCallsDetailsField")
    public void typeInEndReportDateForRecordedCallsDetailsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate11));
        endReportDate11.sendKeys("2.10.2020");
    }
    @Step("clickInSelectionMainNumber11")
    public void clickInSelectionMainNumber11() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectionMainNumber11));
        selectionMainNumber11.click();
    }
    @Step("clickInSelectNumber11")
    public void clickInSelectNumber11() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectNumber11));
        selectNumber11.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("clickInGenerateRecordedCallsDetailsField")
    public void clickInGenerateRecordedCallsDetails() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate11));
        generate11.click();
    }
    ////////////////// Pobrane pliki ////////////////////////////

    @Step("clickOnDownloadFileReport")
    public void clickOnDownloadFileReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadFileReport));
        downloadFileReport.click();
    }

    @Step("typeInStartReportDateForDownloadFileField")
    public void typeInStartReportDateForDownloadFileField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate12));
        startReportDate12.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForDownloadFileField")
    public void typeInEndReportDateForDownloadFileField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate12));
        endReportDate12.sendKeys("2.10.2020");
    }

    @Step("clickInSelectionAdmin12")
    public void clickInSelectionAdmin12() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectionAdmin12));
        selectionAdmin12.click();
    }
    @Step("clickInSelectAdmin12")
    public void clickInSelectAdmin12() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectAdmin12));
        selectAdmin12.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("clickInGenerateDownloadFileField")
    public void clickInGenerateDownloadFile() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate12));
        generate12.click();
    }

    //////////////////// logi audytowe ////////////////

    @Step("clickOnAuditLogsReport")
    public void clickOnAuditLogsReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(auditLogsReport));
        auditLogsReport.click();
    }

    @Step("typeInStartReportDateForAuditLogsField")
    public void typeInStartReportDateForAuditLogsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate21));
        startReportDate21.clear();
        startReportDate21.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForAuditLogsField")
    public void typeInEndReportDateForAuditLogsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate21));
        endReportDate21.clear();
        endReportDate21.sendKeys("2.10.2020");
    }

    @Step("clickInGenerateAuditLogsField")
    public void clickInGenerateAuditLogs() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate21));
        generate21.click();
    }

    ////////////////// Logi audytowe plus ////////////////////


    @Step("clickOnAuditLogsPlusReport")
    public void clickOnAuditLogsPlusReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(auditLogsPlusReport));
        auditLogsPlusReport.click();
    }

    @Step("typeInStartReportDateForAuditLogsPlusField")
    public void typeInStartReportDateForAuditLogsPlusField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate22));
        startReportDate22.clear();
        startReportDate22.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForAuditLogsPlusField")
    public void typeInEndReportDateForAuditLogsPlusField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate22));
        endReportDate22.sendKeys("2.10.2020");
    }

    @Step("clickInGenerateAuditLogsPlusField")
    public void clickInGenerateAuditLogsPlus() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate22));
        generate22.click();
    }


    ///////////////////// funkcjonalności na użytkownikach ////////////


    @Step("clickOnFunctionalityOnUsersReport")
    public void clickOnFunctionalityOnUsersReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(functionalityOnUsersReport));
        functionalityOnUsersReport.click();
    }

    @Step("typeInStartReportDateForFunctionalityOnUsersField")
    public void typeInStartReportDateForFunctionalityOnUsersField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate23));
        startReportDate23.sendKeys("1.02.2021");
    }

    @Step("typeInEndReportDateForFunctionalityOnUsersField")
    public void typeInEndReportDateForFunctionalityOnUsersField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate23));
        endReportDate23.sendKeys("2.10.2020");
    }
    @Step("clickInSelectionUser23")
    public void clickInSelectionUser23() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectionUser23));
        selectionUser23.click();
    }
    @Step("clickInSelectUser23")
    public void clickInSelectUser23() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectUser23));
        selectUser23.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("clickInGenerateFunctionalityOnUsers")
    public void clickInGenerateFunctionalityOnUsers() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate23));
        generate23.click();
    }

    ////////////////// Wywołania API ///////////////


    @Step("clickOnApiCallsReport")
    public void clickOnApiCallsReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(apiCallsReport));
        apiCallsReport.click();
    }

    @Step("typeInStartReportDateForApiCallsField")
    public void typeInStartReportDateForApiCallsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate24));
        startReportDate24.sendKeys("1.10.2020");
    }

    @Step("typeInEndReportDateForApiCallsField")
    public void typeInEndReportDateForApiCallsField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate24));
        endReportDate24.sendKeys("2.10.2020");
    }

    @Step("clickInGenerateApiCalls")
    public void clickInGenerateApiCalls() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generate24));
        generate24.click();
    }
    ////////////////////////////////////

    @Step("clickInGenerateApiCalls")
    public void checkGenerateNewReport(String newReportType) {
        driver.navigate().refresh();
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertTypeCreateReport));
        driver.navigate().refresh();
        driver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.visibilityOf(assertTypeCreateReport));

        String typeRaport = assertTypeCreateReport.getText();
        if (typeRaport.equals(newReportType)) {
            System.out.println("Raport jest w trakcie generowania");
        } else {
            throw new IllegalArgumentException("Raport nie pojawił się na liście");
        }
    }



    @Step("clickInGenerateApiCalls")
    public void checkStatusNewReport() {
        String typeRaport;
        do {
            typeRaport = getTypeReport();
            switch (typeRaport) {
                case "Blad podczas generowania raportu.":
                case "Wygenerowany":
                    assertEquals(typeRaport, "Wygenerowany");
                    break;
            }
        }
        while (!typeRaport.equals("Wygenerowany"));
    }

    private String getTypeReport() {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertStatusCreateReport));
        return assertStatusCreateReport.getText();
    }



    public void deleteLastReport() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteLastRaport));
        btnDeleteLastRaport.click();
    }

    public void chooseValueCyclicalReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtValueIntervalGenerate));
        txtValueIntervalGenerate.clear();
        txtValueIntervalGenerate.sendKeys("1");
        webDriverWait.until(ExpectedConditions.visibilityOf(txtValuePeriodReport));

        txtValuePeriodReport.clear();
        txtValuePeriodReport.sendKeys("1");


    }
    public void checkGenerateCyclicReport(String newReportType) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkInstanceCyclicalReport));
        lnkInstanceCyclicalReport.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(checkLastInstanceCyclicalReport));
        String typeRaport = checkLastInstanceCyclicalReport.getText();
        System.out.println(typeRaport);
        if (typeRaport.equals(newReportType)) {
            System.out.println("Instancja raportu została stworzona");
        } else {
            throw new IllegalArgumentException("Raport nie pojawił się na liście");
        }
    }




    public String validateQuantityReportBefore() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(validateQuantityReport));
        String quantity = validateQuantityReport.getText();
        System.out.println(quantity);

//        String firstqa=quantity.replace("1 – ","");
//        System.out.println(firstqa);
//
//        String numberReport=firstqa.replace(" of ","");
//        System.out.println(numberReport);
//
//        String finalNumberReport=numberReport.substring(3);
//        System.out.println(finalNumberReport);
//       // String qua = quantity.replace("1 – "+finalNumberReport+" of ","");
//        int foo = Integer.parseInt(finalNumberReport);
//        System.out.println(foo);
        return quantity;
    }
    public void validateQuantityReportAfter(String beforeQuantity) {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(validateQuantityReport));
        String after = validateQuantityReport.getText();
        System.out.println(after);

        assertNotEquals(beforeQuantity,after);

    }


    public void downloadLastReportPDF() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDownloadPDFLastRaport));
        btnDownloadPDFLastRaport.click();
    }
    public void downloadLastReportCSV() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDownloadCSVLastRaport));
        btnDownloadCSVLastRaport.click();
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
                if (fileName.contains("Raport")) {

                    assertTrue(fileName.contains("Raport"));

                    listOfFile.delete();
                }
            }
        }
    }
}







