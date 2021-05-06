package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

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
    @FindBy(xpath = "(//button[contains(@id,'list')])[last()]")
    WebElement chooseGroup;
    @FindBy(id = "choose_role")
    WebElement chooseRole;
    @FindBy(id = "AG_option")
    WebElement selectRole;
    @FindBy(id = "add_role_button")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteRoleButton;
    @FindBy(id = "delete_group")
    WebElement deleteGroupButton;
    @FindBy(id = "edit_group")
    WebElement editGroupButton;
    @FindBy(xpath = "(//p[contains(@id,'role_')])[last()]")
    WebElement checkRoleInGroup;
    @FindBy(xpath = "(//button[contains(@id,'_list_element')])")
    private List<WebElement> checkAddNewGroup;

    @FindBy(id = "add_member")
    WebElement btnAddUserToGroup;
    @FindBy(css = "[id*=\"mat-dialog\"] mat-checkbox>label")
    List<WebElement> checkboxSelectUserAddGroup;
    @FindBy(css = "[id*=\"username_\"]")
    List<WebElement> userListGroup;
    @FindBy(css = "[class*=\"mat-column-login\"]")
    List<WebElement> userBeforeAddGroup;
    @FindBy(id = "add_button")
    WebElement btnConfirmAddUserToGroup;
    @FindBy(css = "mat-checkbox[id*=\"user_choose_\"]")
    List<WebElement> checkboxDeleteUser;
    @FindBy(id = "delete_member")
    WebElement btnDeleteUser;

    @FindBy(css = "mat-checkbox[id*=\"admin_checkbox_\"]")
    List<WebElement> checkboxAdminGroup;




    private WebDriver driver;
    public GroupPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addUserToGroup(String user){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddUserToGroup));
        btnAddUserToGroup.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(userListGroup));
        for(int i=0; i<userListGroup.size();i++){
            String role=userListGroup.get(i).getText();
            if(role.equals(user)){

                checkboxSelectUserAddGroup.get(i+1).click();
            }
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddUserToGroup));

        btnConfirmAddUserToGroup.click();

    }

    public void verifyAddUserToGroup(String user){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*=\"mat-column-login\"]")));

            userBeforeAddGroup
                    .stream()
                    .filter(webElement -> Objects.equals(webElement.getText(), user))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + user));

        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*=\"mat-column-login\"]")));

            userBeforeAddGroup
                    .stream()
                    .filter(webElement -> Objects.equals(webElement.getText(), user))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + user));

        }
    }

    public void verifyDeleteUserFromGroup(String user) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*=\"mat-column-login\"]")));

            for (int i = 1; i < userBeforeAddGroup.size(); i++) {

                if (userBeforeAddGroup.get(i).getText().equals(user)) {
                    throw new IllegalArgumentException("User nie został usunięty");

                }
            }


        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*=\"mat-column-login\"]")));

            for (int i = 1; i < userBeforeAddGroup.size(); i++) {

                if (userBeforeAddGroup.get(i).getText().equals(user)) {
                    throw new IllegalArgumentException("User nie został usunięty");

                }
            }
        }
    }

    public void deleteUserWithGroup(String user){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(userBeforeAddGroup));
        for(int i=0; i<userBeforeAddGroup.size();i++){
            String role=userBeforeAddGroup.get(i).getText();
            if(role.equals(user)){

                checkboxDeleteUser.get(i-1).click();
            }
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteUser));
        btnDeleteUser.click();
    }
    public void assignUserAsAdminGroup(String user){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(userBeforeAddGroup));
        for(int i=0; i<userBeforeAddGroup.size();i++){
            String role=userBeforeAddGroup.get(i).getText();
            if(role.equals(user)){

                checkboxAdminGroup.get(i-1).click();
            }
        }

    }
    public void verifyAssignUserAsAdminGroup(String user){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(userBeforeAddGroup));
        for(int i=0; i<userBeforeAddGroup.size();i++){
            String role=userBeforeAddGroup.get(i).getText();
            if(role.equals(user)){

                String classAtr = checkboxAdminGroup.get(i-1).getAttribute("class");

                assertTrue(classAtr.contains("mat-checkbox-checked"));
            }
        }

    }

    @Step("clickOnGroupButton")
    public void clickOnGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(groupsButton));

        groupsButton.click();
        // groupsButton.click();
    }

    @Step("clickOnAddGroupButton")
    public void clickOnAddGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addGroupButton));
        addGroupButton.click();}
    @Step("typeIntoAddNameField")

    public void typeIntoAddNameField(String addName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.clear();
        addNameField.sendKeys(addName);}
    @Step("typeIntoAddDescriptionField")

    public void typeIntoAddDescriptionField(String description){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addDescriptionField));
        addDescriptionField.clear();
        addDescriptionField.sendKeys(description);}
    @Step("clickOnSaveNewGroupButton")

    public void clickOnSaveNewGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewGroupButton));
        saveNewGroupButton.click();}
    @Step("clickOnChooseGroup")

    public void clickOnChooseGroup(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseGroup));
        chooseGroup.click();}
    @Step("selectChooseRole")

    public void selectChooseRole(String role){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRole));
        chooseRole.click();
        WebElement chooseRole1= driver.findElement(By.id(role));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRole1));
        chooseRole1.click();}
    @Step("clickAddRoleButton")

    public void clickAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();}
    @Step("clickDeleteRoleButton")

    public void clickDeleteRoleButton() {


        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteRoleButton));
        deleteRoleButton.click();
    }


    @Step("clickOnDeleteGroupButton")

    public void clickOnDeleteGroupButton(String groupName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(checkAddNewGroup));


        String result = checkAddNewGroup.get(checkAddNewGroup.size() - 1).getText();


        if (result.equals(groupName)) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteGroupButton));
            deleteGroupButton.click();

        }else{
            throw new IllegalArgumentException("Nie ma takiej grupy");

        }

    }
    @Step("clickOnEditGroupButton")

    public void clickOnEditGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editGroupButton));
        editGroupButton.click();}


    @Step("validateAddRoleForGroup")
    public void validateAddRoleForGroup(String role) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkRoleInGroup));


        String result = checkRoleInGroup.getText();

        assertEquals(result, role);
    }

    @Step("validateDeleteRoleForGroup")
    public void validateDeleteRoleForGroup() {


        List<WebElement> allElement = driver.findElements(By.xpath("(//p[contains(@id,'role_')])[last()]"));

        assertTrue(allElement.isEmpty());


    }

    @Step("validateAddNewGroup")
    public void validateAddNewGroup(String groupName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkAddNewGroup.get(0)));
        boolean flag = false;
        for (WebElement element : checkAddNewGroup) {
            if (groupName.equals(element.getText())) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    public void chooseGroupWithList(String group){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(checkAddNewGroup));
        for(int i=0; i<checkAddNewGroup.size();i++){
            String role=checkAddNewGroup.get(i).getText();
            if(role.equals(group)){

                checkAddNewGroup.get(i).click();
            }
        }

    }


    @Step("validateDeleteGroup")
    public void validateDeleteGroup() {
        clickOnGroupButton();

        assertTrue(checkAddNewGroup.isEmpty() || !checkAddNewGroup.get(checkAddNewGroup.size() - 1).getText().equals("test123"));
    }

}
