package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShopPage {

    @FindBy(id = "shop_component_link")
    WebElement shopTab;
    @FindBy(id = "BLL_input")
    WebElement BLL_input;
    @FindBy(id = "NREC_input")
    WebElement txtRecInput;

@FindBy(id = "NAPI_input")
WebElement txtApiInput;
@FindBy(id = "NANP_input")
WebElement txtPersonalizedMessageInput;
@FindBy(id = "CID_input")
WebElement txtOppbInput;
@FindBy(id = "NTAG_input")
WebElement txtTagInput;
@FindBy(id = "ONLY_ + TEF_input")
WebElement txtMessageEnglishFemaleInput;
@FindBy(id = "ONLY_ + TPF_input")
WebElement txtMessagePolishFemaleInput;
@FindBy(id = "ONLY_ + TPM_input")
WebElement txtMessagePolishMaleInput;
@FindBy(id = "ONLY_ + NIVR_input")
WebElement txtVipInput;
@FindBy(id = "ONLY_ + DAL_input")
WebElement txtDetailedAuditLogsInput;






    @FindBy(id = "RCP_input")
WebElement txtPackage1000MinutesRec;
@FindBy(css = "[class=\"mat-row ng-star-inserted\"]:nth-of-type(1)>td:nth-of-type(2)")
WebElement txtActualValuePackage;


    @FindBy(id = "save_changes")
    WebElement saveChangeButton;
    @FindBy(id = "buy_package")
    WebElement buyPackage;
    @FindBy(id = "available_additional_packets")
    WebElement additionalFundsAvailableTab;
    @FindBy(xpath = "(//*[(@class='mat-radio-button mat-accent')])[46]")
    WebElement valuePackage;
    @FindBy(xpath = "(//*[(@class=\"mat-radio-container\")])[1]")
    WebElement lowestValuePackage;
    @FindBy(xpath = "//p[contains(text(),'Funkcjonalności zostały zapisane')]")
    WebElement checkTextDialog;
    @FindBy(xpath = "(//*[contains(text(), 'Centralka nie posiada wystarczającej liczby nieskonfigurowanych czarnych list do sprzedania')])[last()]")
    WebElement checkNotAllowDialog;
    @FindBy(xpath = "(//*[contains(text(), 'Centralka nie posiada wystarczającej liczby nieskonfigurowanych komunikatów spersonalizowanych do sprzedania. Włączony jest komunikat firmowy, proszę go wyłączyć i spróbować ponownie.')])[last()]")
    WebElement checkNotAllowDialogForPersonalizedMessage;
    @FindBy(xpath = "//p[contains(text(),'Kupiono pakiet')]")
    WebElement checkTextDialogAdditionalPackage;

    @FindBy(id = "USR_input")
    WebElement userField;

    @FindBy(id = "save_modal_button")
    WebElement saveModalButton;
    @FindBy(id = "7 zł_option")
    WebElement chooseOption;

    @FindBy(id = "NWTL_input")
    WebElement wtlInput;
    @FindBy(xpath = "(//*[text()=\"Brak możliwości zakupu pakietu o mniejszej wartości. Skontaktuj się z Biurem Obsługi Klienta.\"])")
    WebElement alertBuyLowerPackage;


    private WebDriver driver;

    public ShopPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickOnShopTab")

    public void buyNewUserFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(userField));

        Integer a = Integer.parseInt(userField.getAttribute("value"));
        Integer newValue = a + 1;
        userField.clear();
        userField.sendKeys(newValue.toString());
    }

    public void sellUserFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(userField));


        Integer a = Integer.parseInt(userField.getAttribute("value"));
        Integer newValue = a - 1;

        userField.clear();
        userField.sendKeys(newValue.toString());
    }

    @Step("clickOnShopTab")

    public void clickOnShopTab() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shopTab));

List<WebElement> elementList=driver.findElements(By.id("BLL_input"));
        if(elementList.isEmpty()){
            shopTab.click();
        }
    }

    //    @Step("buyNewFaxFunctionalitiesWithExceedingTheAmount")
//    public void buyNewFaxFunctionalitiesWithExceedingTheAmount (){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
//        webDriverWait.until(ExpectedConditions.visibilityOf(presentationByMajorNumberField));
//        webDriverWait.ignoring(TimeoutException.class);
//
//        presentationByMajorNumberField.clear();
//        presentationByMajorNumberField.sendKeys("20000");
//    }
    @Step("buyNewFaxFunctionalities")
    public void buyNewBlackListFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(BLL_input));

        Integer a = Integer.parseInt(BLL_input.getAttribute("value"));
        Integer newValue = a + 1;

        BLL_input.clear();
        BLL_input.sendKeys(newValue.toString());
    }
    public void buyNewRecordingFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtRecInput));

        Integer a = Integer.parseInt(txtRecInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtRecInput.clear();
        txtRecInput.sendKeys(newValue.toString());
    }
    public void sellRecordingFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtRecInput));


        Integer a = Integer.parseInt(txtRecInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtRecInput.clear();
        txtRecInput.sendKeys(newValue.toString());
    }
//////////////////////////////////////////////////////


    public void buyNewApiFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtApiInput));

        Integer a = Integer.parseInt(txtApiInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtApiInput.clear();
        txtApiInput.sendKeys(newValue.toString());
    }
    public void sellApiFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtApiInput));


        Integer a = Integer.parseInt(txtApiInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtApiInput.clear();
        txtApiInput.sendKeys(newValue.toString());
    }

    public void buyNewPersonalizedMessageFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPersonalizedMessageInput));

        Integer a = Integer.parseInt(txtPersonalizedMessageInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtPersonalizedMessageInput.clear();
        txtPersonalizedMessageInput.sendKeys(newValue.toString());
    }
    public void sellPersonalizedMessageFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPersonalizedMessageInput));


        Integer a = Integer.parseInt(txtPersonalizedMessageInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtPersonalizedMessageInput.clear();
        txtPersonalizedMessageInput.sendKeys(newValue.toString());
    }




    public void buyNewOppbFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtOppbInput));

        Integer a = Integer.parseInt(txtOppbInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtOppbInput.clear();
        txtOppbInput.sendKeys(newValue.toString());
    }
    public void sellOppbFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtOppbInput));


        Integer a = Integer.parseInt(txtOppbInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtOppbInput.clear();
        txtOppbInput.sendKeys(newValue.toString());
    }


    public void buyNewTagFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtTagInput));

        Integer a = Integer.parseInt(txtTagInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtTagInput.clear();
        txtTagInput.sendKeys(newValue.toString());
    }
    public void sellTagFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtTagInput));


        Integer a = Integer.parseInt(txtTagInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtTagInput.clear();
        txtTagInput.sendKeys(newValue.toString());
    }

    public void buyNewMessageEnglishFemaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessageEnglishFemaleInput));

        Integer a = Integer.parseInt(txtMessageEnglishFemaleInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtMessageEnglishFemaleInput.clear();
        txtMessageEnglishFemaleInput.sendKeys(newValue.toString());
    }
    public void sellMessageEnglishFemaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessageEnglishFemaleInput));


        Integer a = Integer.parseInt(txtMessageEnglishFemaleInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtMessageEnglishFemaleInput.clear();
        txtMessageEnglishFemaleInput.sendKeys(newValue.toString());
    }
    public void buyNewMessagePolishFemaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessagePolishFemaleInput));

        Integer a = Integer.parseInt(txtMessagePolishFemaleInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtMessagePolishFemaleInput.clear();
        txtMessagePolishFemaleInput.sendKeys(newValue.toString());
    }
    public void sellMessagePolishFemaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessagePolishFemaleInput));


        Integer a = Integer.parseInt(txtMessagePolishFemaleInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtMessagePolishFemaleInput.clear();
        txtMessagePolishFemaleInput.sendKeys(newValue.toString());
    }

    public void buyNewMessagePolishMaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessagePolishMaleInput));

        Integer a = Integer.parseInt(txtMessagePolishMaleInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtMessagePolishMaleInput.clear();
        txtMessagePolishMaleInput.sendKeys(newValue.toString());
    }
    public void sellMessagePolishMaleFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtMessagePolishMaleInput));


        Integer a = Integer.parseInt(txtMessagePolishMaleInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtMessagePolishMaleInput.clear();
        txtMessagePolishMaleInput.sendKeys(newValue.toString());
    }


    public void buyNewVipFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtVipInput));

        Integer a = Integer.parseInt(txtVipInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtVipInput.clear();
        txtVipInput.sendKeys(newValue.toString());
    }
    public void sellVipFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtVipInput));


        Integer a = Integer.parseInt(txtVipInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtVipInput.clear();
        txtVipInput.sendKeys(newValue.toString());
    }

    public void buyNewDetailedAuditLogsFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtDetailedAuditLogsInput));

        Integer a = Integer.parseInt(txtDetailedAuditLogsInput.getAttribute("value"));
        Integer newValue = a + 1;

        txtDetailedAuditLogsInput.clear();
        txtDetailedAuditLogsInput.sendKeys(newValue.toString());
    }
    public void sellDetailedAuditLogsFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtDetailedAuditLogsInput));


        Integer a = Integer.parseInt(txtDetailedAuditLogsInput.getAttribute("value"));
        Integer newValue = a - 1;

        txtDetailedAuditLogsInput.clear();
        txtDetailedAuditLogsInput.sendKeys(newValue.toString());
    }


    ////////////////////////////////////////////

    public void buyNewPackage1000MinutesRecFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPackage1000MinutesRec));

        Integer a = Integer.parseInt(txtPackage1000MinutesRec.getAttribute("value"));
        Integer newValue = a + 1;

        txtPackage1000MinutesRec.clear();
        txtPackage1000MinutesRec.sendKeys(newValue.toString());
    }

    public void checkBuyValuePackage1000MinutesRecInConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtActualValuePackage));

        Integer a = Integer.parseInt(txtActualValuePackage.getAttribute("value"));

        assertEquals(a, "1000");
    }
    public void checkSellValuePackage1000MinutesRecInConfiguration() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtActualValuePackage));

        Integer a = Integer.parseInt(txtActualValuePackage.getAttribute("value"));

        assertEquals(a, "0");
    }
    public void sellPackage1000MinutesRecFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPackage1000MinutesRec));


        Integer a = Integer.parseInt(txtPackage1000MinutesRec.getAttribute("value"));
        Integer newValue = a - 1;

        txtPackage1000MinutesRec.clear();
        txtPackage1000MinutesRec.sendKeys(newValue.toString());
    }


    public void buyNewWhiteListFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(wtlInput));

        Integer a = Integer.parseInt(wtlInput.getAttribute("value"));
        Integer newValue = a + 1;

        wtlInput.clear();
        wtlInput.sendKeys(newValue.toString());
    }

    @Step("sellFaxFunctionalities")
    public void sellBlackListFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(BLL_input));


        Integer a = Integer.parseInt(BLL_input.getAttribute("value"));
        Integer newValue = a - 1;

        BLL_input.clear();
        BLL_input.sendKeys(newValue.toString());
    }

    public void sellWhiteListFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(wtlInput));


        Integer a = Integer.parseInt(wtlInput.getAttribute("value"));
        Integer newValue = a - 1;

        wtlInput.clear();
        wtlInput.sendKeys(newValue.toString());
    }

    @Step("clickOnSaveChangeButton")
    public void clickOnSaveChangeButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveChangeButton));
        saveChangeButton.click();
    }

    @Step("clickOnBuyPackageButton")
    public void clickOnBuyPackageButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buyPackage));
        buyPackage.click();
    }

    @Step("clickOnAdditionalFundsAvailableTab")
    public void clickOnAdditionalFundsAvailableTab() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(additionalFundsAvailableTab));
        additionalFundsAvailableTab.click();
    }

    @Step("selectValuePackageWithList")
    public void selectValuePackageWithList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(valuePackage));
       valuePackage.click();

    }


    public void selectLowestValuePackageWithList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lowestValuePackage));
        lowestValuePackage.click();

    }

    public void checkSavingConfirmationText() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkTextDialog));
       assertEquals(checkTextDialog.getText(), "Funkcjonalności zostały zapisane");

        webDriverWait.until(ExpectedConditions.visibilityOf(saveModalButton));
        saveModalButton.click();
    }

    public void checkNotAllowSavingConfirmationText() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkNotAllowDialog));
        assertEquals(checkNotAllowDialog.getText(), "Centralka nie posiada wystarczającej liczby nieskonfigurowanych czarnych list do sprzedania");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

    }
    public void checkNotAllowSavingConfirmationTextForPersonalizedMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkNotAllowDialogForPersonalizedMessage));
        assertEquals(checkNotAllowDialogForPersonalizedMessage.getText(), "Centralka nie posiada wystarczającej liczby nieskonfigurowanych komunikatów spersonalizowanych do sprzedania. Włączony jest komunikat firmowy, proszę go wyłączyć i spróbować ponownie.");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

    }
    public void checkNotAllowSavingLowerPackageMoneyMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(alertBuyLowerPackage));
        assertEquals(alertBuyLowerPackage.getText(), "Brak możliwości zakupu pakietu o mniejszej wartości. Skontaktuj się z Biurem Obsługi Klienta.");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();



    }

    public void checkSavingAdditionalPackageConfirmationText() {

        assertEquals(checkTextDialogAdditionalPackage.getText(), "Kupiono pakiet");
    }



}
