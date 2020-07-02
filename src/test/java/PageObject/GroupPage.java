package PageObject;

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(xpath = "//*[@id=\"choose_role\"]/div/div[1]")
    WebElement chooseRole;
    @FindBy(id = "add_role_button")
    WebElement addRoleButton;
    @FindBy(id = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteRoleButton;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-user-priv/app-groups-management/div/div/div[2]/div/div[1]/div[2]/button[1]")
    WebElement deleteGroupButton;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-user-priv/app-groups-management/div/div/div[2]/div/div[1]/div[2]/button[2]")
    WebElement editGroupButton;



    private WebDriver driver;
    public GroupPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnGroupButton(){groupsButton.click();}
    public void clickOnAddGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addGroupButton));
        addGroupButton.click();}
    public void typeIntoAddNameField(){addNameField.sendKeys("test123");}
    public void typeIntoAddDescriptionField(){addDescriptionField.sendKeys("test opisu grupy");}
    public void clickOnSaveNewGroupButton(){saveNewGroupButton.click();}
    public void clickOnChooseGroup(){chooseGroup.click();}
    public void selectChooseRole(){
        Select select = new Select(chooseRole);
        select.selectByVisibleText("rola1");}
    public void clickAddRoleButton(){addRoleButton.click();}
    public void clickDeleteRoleButton(){deleteRoleButton.click();}
    public void clickOnDeleteGroupButton(){deleteGroupButton.click();}
    public void clickOnEditGroupButton(){editGroupButton.click();}



}
