package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class GroupPage {

    @FindBy(id = "groups")
    WebElement groupsButton;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-user-priv/app-groups-management/div/div/div[1]/span")
    WebElement addGroupButton;
    @FindBy(id = "add_name")
    WebElement addNameField;
    @FindBy(id = "add_description")
    WebElement addDescriptionField;
    @FindBy(id = "group_add")
    WebElement saveNewGroupButton;
    @FindBy(xpath = "(//*[@class=\"mat-list-item-content\"])[last()]")
    WebElement chooseGroup;
    @FindBy(id = "choose_role")
    WebElement chooseRole;
    @FindBy(id = "mat-option-0")
    WebElement selectRole;
    @FindBy(id = "add_role_button")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteRoleButton;
    @FindBy(id = "delete_group")
    WebElement deleteGroupButton;
    @FindBy(id = "edit_group")
    WebElement editGroupButton;
    @FindBy(xpath = "//p[contains(@id,'role_')]")
    WebElement checkRoleInGroup;
    @FindBy(xpath = "//button[contains(@id,'_list_element')]")
    WebElement checkAddNewGroup;



    private WebDriver driver;
    public GroupPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(groupsButton));
        groupsButton.click();}
    public void clickOnAddGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addGroupButton));
        addGroupButton.click();}
    public void typeIntoAddNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.sendKeys("test123");}
    public void typeIntoAddDescriptionField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addDescriptionField));
        addDescriptionField.sendKeys("test opisu grupy");}
    public void clickOnSaveNewGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewGroupButton));
        saveNewGroupButton.click();}
    public void clickOnChooseGroup(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseGroup));
        chooseGroup.click();}
    public void selectChooseRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseRole));
        chooseRole.click();
       selectRole.click();}
    public void clickAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleButton));
        addRoleButton.click();}
    public void clickDeleteRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteRoleButton));
        deleteRoleButton.click();}
    public void clickOnDeleteGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteGroupButton));
        deleteGroupButton.click();}
    public void clickOnEditGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(editGroupButton));
        editGroupButton.click();}


    @Step("validateAddRoleForCertificate")
    public void validateAddRoleForCertificate() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkRoleInGroup));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "Super Admin");
    }

    @Step("validateAddRoleForCertificate")
    public void validateDeleteRoleForCertificate() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkRoleInGroup));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, "Super Admin");
    }

    @Step("validateAddRoleForCertificate")
    public void validateAddNewGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkAddNewGroup));

        List<WebElement> allElement = driver.findElements(By.xpath("//button[contains(@id,'_list_element')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "test123");
    }


    @Step("validateAddRoleForCertificate")
    public void validateDeleteGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkRoleInGroup));

        List<WebElement> allElement = driver.findElements(By.xpath("//button[contains(@id,'_list_element')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, "test123");
    }

}
