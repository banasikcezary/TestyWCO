package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportPage {

    @FindBy(id = "reports_list_link")
    WebElement reportButton;
    @FindBy(id = "headingOne")
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
////////////////
    @FindBy(id = "report5")
    WebElement extensionsAndTransfersReport;

    @FindBy(id = "report10")
    WebElement recordedCallsReport;
    @FindBy(id = "report11")
    WebElement recordedCallsDetailsReport;
    @FindBy(id = "report12")
    WebElement downloadFileReport;
@FindBy(id = "report21")
WebElement auditLogsReport;
    @FindBy(id = "report22")
    WebElement auditLogsPlusReport;
    @FindBy(id = "report23")
    WebElement functionalityOnUsersReport;
    @FindBy(id = "report24")
    WebElement apiCallsReport;

    @FindBy(id = "report_22_startReportDate")
    WebElement startReportDateField;
    @FindBy(id = "report_22_endReportDate")
    WebElement endReportDateField;
    @FindBy(id = "report_22_generate_report_button")
    WebElement generateReportAuditLogPlus;

    @FindBy(xpath = "//*[@id=\"report_list\"]/mat-row[1]/mat-cell[2]")
    WebElement assertCreateReport;




    private WebDriver driver;
    public ReportPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnReportTab")

    public void clickOnReportTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(reportButton));
        reportButton.click();
    }
    @Step("clickOnProperty")

    public void clickOnProperty(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(property));
        property.click();
    }
    @Step("chooseStartReportDay")

    public void chooseStartReportDay(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate));
        startReportDate.sendKeys("3.05.2020");
    }
    @Step("chooseEndReportDay")

    public void chooseEndReportDay(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate));
        endReportDate.sendKeys("30.05.2020");
    }
    @Step("clickOnButtonGenerateSingletonReport")

    public void clickOnButtonGenerateSingletonReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateSingleReportButton));
        generateSingleReportButton.click();
    }

    @Step("clickOnButtonCyclicalReport")

    public void clickOnButtonCyclicalReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cyclicalReport));
        Actions actions=new Actions(driver);
        actions.moveToElement(cyclicalReport).click().build().perform();
    }
    @Step("clickOncheckboxGenerateReport")

    public void clickOncheckboxGenerateReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGenerateReportCyclical));
        checkboxGenerateReportCyclical.click();
    }
    @Step("clickOnGenerateReportEveryField")

    public void clickOnGenerateReportEveryField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateReportEveryField));
        generateReportEveryField.sendKeys("2");
    }
    @Step("selectChooseInterval")

    public void selectChooseInterval(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(selectChooseInterval));
        Select select = new Select(selectChooseInterval);
        select.selectByIndex(1);
    }
    @Step("typeIntoEndReportDateForCyclical")

    public void typeIntoEndReportDateForCyclical(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDateForCyclical));
        endReportDateForCyclical.sendKeys("31.05.2020");
    }
    @Step("clickOnGenerateCyclicalReport")

    public void clickOnGenerateCyclicalReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(generateCyclicalReport));
        generateCyclicalReport.click();
    }

}
