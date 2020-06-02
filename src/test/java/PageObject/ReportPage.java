package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportPage {

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")
    WebElement reportButton;
    @FindBy(xpath = "//*[@id=\"headingOne\"]")
    WebElement property;
    @FindBy(xpath = "//*[@id=\"headingCyclicReport\"]")
    WebElement cyclicalReport;
    @FindBy(xpath = "//*[@id=\"startReportDate\"]")
    WebElement startReportDate;
    @FindBy(xpath = "//*[@id=\"endReportDate\"]")
    WebElement endReportDate;
    @FindBy(xpath = "//*[@id=\"collapseOne\"]/form/button")
    WebElement generateSingleReportButton;
    @FindBy(xpath = "//*[@id=\"generateCyclicReports\"]/label/div")
    WebElement checkboxGenerateReportCyclical;

    @FindBy(xpath = "//*[@id=\"numberOfIntervalOfReport\"]")
    WebElement generateReportEveryField;
    @FindBy(xpath = "//*[@id=\"collapseCyclicReport\"]/form/div[2]/div[2]/select")
    WebElement selectChooseInterval;

    @FindBy(xpath = "//*[@id=\"startCyclicReportDate\"]")
    WebElement endReportDateForCyclical;
    @FindBy(xpath = "//*[@id=\"collapseCyclicReport\"]/form/button")
    WebElement generateCyclicalReport;


    private WebDriver driver;
    public ReportPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void clickOnReportTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(reportButton));
        reportButton.click();
    }

    public void clickOnProperty(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(property));
        property.click();
    }
    public void chooseStartReportDay(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(startReportDate));
        startReportDate.sendKeys("3.05.2020");
    }
    public void chooseEndReportDay(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDate));
        endReportDate.sendKeys("30.05.2020");
    }
    public void clickOnButtonGenerateSingletonReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(generateSingleReportButton));
        generateSingleReportButton.click();
    }


    public void clickOnButtonCyclicalReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(cyclicalReport));
        cyclicalReport.click();
    }
    public void clickOncheckboxGenerateReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkboxGenerateReportCyclical));
        checkboxGenerateReportCyclical.click();
    }
    public void clickOnGenerateReportEveryField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(generateReportEveryField));
        generateReportEveryField.sendKeys("2");
    }
    public void selectChooseInterval(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(selectChooseInterval));
        Select select = new Select(selectChooseInterval);
        select.selectByIndex(1);
    }

    public void typeIntoEndReportDateForCyclical(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(endReportDateForCyclical));
        endReportDateForCyclical.sendKeys("31.05.2020");
    }
    public void clickOnGenerateCyclicalReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(generateCyclicalReport));
        generateCyclicalReport.click();
    }

}
