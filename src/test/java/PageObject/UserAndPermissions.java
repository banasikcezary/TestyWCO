package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAndPermissions {

    @FindBy (id = "privileges_component_link")
    WebElement userAndPermission;
    @FindBy(id = "users")
    WebElement users;
    @FindBy(id = "add_user_button")
    WebElement addUserButton;
    @FindBy(id = "add_login")
    WebElement loginField;
    @FindBy(id = "add_first_name")
    WebElement firstNameField;
    @FindBy(id = "add_last_name")
    WebElement lastNameField;
    @FindBy(id = "add_email")
    WebElement emailField;
    @FindBy(id = "add_phone")
    WebElement phoneField;
    @FindBy(id = "user_add")
    WebElement saveUserButton;
    @FindBy (xpath = "//*[@id=\"mat-input-0\"]")
    WebElement searchUserField;
    @FindBy(id = "search_button")
    WebElement searchButton;
    @FindBy(id = "roles_0")
    WebElement showRoleButton;
    @FindBy(id = "add_assignment_button")
    WebElement addAssignmentButton;
    @FindBy(xpath = "//*[@id=\"choose_role\"]/div/div[1]")
    WebElement selectRole;
    @FindBy(id = "privilege_add")
    WebElement addRoleButton;
    @FindBy(id = "delete_0")
    WebElement deleteUser;


    private WebDriver driver;
    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnUserAndPermissionButton(){
        userAndPermission.click();
    }
    public void clickOnUserButton(){
        users.click();
    }
    public void clickOnAddUserButton(){
        addUserButton.click();
    }
    public void typeIntoLoginField(){
        loginField.sendKeys("Karol1");
    }
    public void typeIntoFirstNameField(){
        firstNameField.sendKeys("Karol");
    }
    public void typeIntoLastName(){
        lastNameField.sendKeys("Nowak");
    }
    public void typeIntoEmailField(){
        emailField.sendKeys("qwerty@o2.pl");
    }
    public void typeIntoPhoneField(){
        phoneField.sendKeys("666555777");
    }
    public void clickOnSaveNewUserButton(){
        saveUserButton.click();
    }
    public void typeIntoSearchUserField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchUserField));
        searchUserField.clear();
        searchUserField.sendKeys("Karol1");}
    public void clickOnSearchButton(){searchButton.click();}
    public void clickOnShowRoleButton(){showRoleButton.click();}
    public void clickOnAddAssignmentButton(){addAssignmentButton.click();}
    public void selectRole(){
        Select select = new Select(selectRole);
        select.selectByIndex(1);
    }
    public void clickAddRoleButton(){addRoleButton.click();}
    public void clickOnDeleteUser(){deleteUser.click();}

}
