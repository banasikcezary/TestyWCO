package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class AuditLogsPage {

    @FindBy(id = "audit_log_link")
    WebElement lnkAuditLogs;
    @FindBy(id = "date_from")
    WebElement txtDateFrom;
    @FindBy(id = "date_to")
    WebElement txtDateTo;
    @FindBy(id = "search_button")
    WebElement btnSearchLogs;
    @FindBy(css = "[id*=\"timestamp_\"]")
    List<WebElement> listDateBeforeSearchWithDate;




    private WebDriver driver;

    public AuditLogsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void searchAuditLogsWithDate(String dateFrom, String dateTo){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkAuditLogs));
        lnkAuditLogs.click();
        List<WebElement> elementList=driver.findElements(By.id("date_from"));
        if(elementList.isEmpty()){ lnkAuditLogs.click();}


        webDriverWait.until(ExpectedConditions.visibilityOf(txtDateFrom));
        txtDateFrom.clear();
        txtDateFrom.sendKeys(dateFrom);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtDateTo));
        txtDateTo.clear();
        txtDateTo.sendKeys(dateTo);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSearchLogs));
        btnSearchLogs.click();

    }

    public void verifyViewAuditLogsFromDate(String verifyDate){


        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listDateBeforeSearchWithDate));
            for(int i=0;i<listDateBeforeSearchWithDate.size();i++){
                String date=listDateBeforeSearchWithDate.get(i).getText();
                String viewDate = date.substring(0, date.length()-9);
                System.out.println(viewDate);

                assertEquals(viewDate,verifyDate);
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listDateBeforeSearchWithDate));
            for(int i=0;i<listDateBeforeSearchWithDate.size();i++){
                String date=listDateBeforeSearchWithDate.get(i).getText();
                String viewDate = date.substring(0, date.length()-9);
                System.out.println(viewDate);

                assertEquals(viewDate,verifyDate);
            }
        }

    }


}
