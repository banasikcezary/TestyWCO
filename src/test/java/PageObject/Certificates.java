package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Certificates {



@FindBy(id = "certificates")
WebElement certificatesButton;

@FindBy(id = "add_user_button")
WebElement addUserButton;
@FindBy(id = "add_cn")
WebElement addNameField;
@FindBy(id = "add_email")
WebElement addEmailField;
@FindBy(id = "add_city")
WebElement addCityField;
@FindBy(id = "add_country")
WebElement addCountryField;
@FindBy(id = "add_state")
WebElement addStateField;
@FindBy(id = "add_organization")
WebElement addOrganisationField;
@FindBy(id = "add_organizational_unit")
WebElement addOrganisationalUnitField;
@FindBy(xpath = "//*[@id=\"ngx-mat-file-input-0\"]/input")
WebElement chooseFile;
@FindBy(id = "cert_add")
WebElement saveNewCertidicate;
@FindBy(id = "filter_value_input")
WebElement searchNameField;
@FindBy(id = "search_button")
WebElement searchCertificateButton;

@FindBy(id = "(//button[text()=\"Pokaż role\"])[last()]")
WebElement showRoles;
@FindBy(id = "add_assignment_button")
WebElement addAssignmentButton;
@FindBy(id = "choose_role")
WebElement chooseRole;
@FindBy(id = "privilege_add")
WebElement saveNewRoleButton;

@FindBy(id = "(//button[text()=\"Pobierz\"])[last()]")
WebElement downloadCertificateButton;

@FindBy(id = "(//button[text()=\"Usuń\"])[last()]")
WebElement deleteCertificateButton;

@FindBy(xpath = "//p[contains(@id,'cn')]")
WebElement verifyCreateCert;




    private WebDriver driver;
    public Certificates(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnCertificatesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(certificatesButton));
        certificatesButton.click();}
    public void clickOnAddUserButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addUserButton));
        addUserButton.click();}
    public void typeIntoAddNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.sendKeys("Artur");}
    public void typeIntoAddEmailField(){addEmailField.sendKeys("artur@o2.pl");}
    public void typeIntoAddCityField(){addCityField.sendKeys("Warszawa");}
    public void typeIntoAddCountryField(){addCountryField.sendKeys("Polska");}
    public void typeIntoAddStateField(){addStateField.sendKeys("Stan");}
    public void typeIntoAddOrganisationField(){addOrganisationField.sendKeys("Organizacja");}
    public void typeIntoAddOrganisationalUnitField(){addOrganisationalUnitField.sendKeys("Dział");}
    public void loadFileWithCertificates(){

       chooseFile.sendKeys("C:\\Users\\DELL\\Downloads\\cert.crt");
       }
    public void clickSaveNewCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewCertidicate));
        saveNewCertidicate.click();

        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }}
    public void typeIntoSearchNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchNameField));
        searchNameField.sendKeys("Artur");}
    public void clickOnSearchCertificateButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchCertificateButton).click().build().perform();
    }
    public void validateTheCertificateCreation(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyCreateCert));

        List<WebElement> allElement= (List<WebElement>) verifyCreateCert;
        int count=allElement.size();
        String result=allElement.get(count-1).getText();

        assertEquals("imie",result);

    }
    public void clickIntoShowRoles(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(showRoles));

        showRoles.click();}
    public void clickAddAssignmentButton(){addAssignmentButton.click();}
    public void selectChooseRole(){
        Select select= new Select(chooseRole);
    select.selectByVisibleText("rola1");}
    public void clickOnSaveNewRoleButton(){saveNewRoleButton.click();}
    public void clickOnDownloadCertificateButton(){downloadCertificateButton.click();}
    public void clickOnDeleteCertificateButton(){deleteCertificateButton.click();}


}
