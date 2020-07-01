package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Roles {

    @FindBy(id = "roles")
    WebElement rolesButton;

    @FindBy(id = "add_privilege_button")
    WebElement addRoleButton;
    @FindBy(id = "add_role_name")
    WebElement addRoleNameField;
    @FindBy(id = "add_role_description")
    WebElement addRoleDescriptionField;
    @FindBy(id = "role_add")
    WebElement saveNewRole;

    @FindBy(id = "edit_role_4")
    WebElement editRole;
    @FindBy(id = "edit_role_name")
    WebElement editRoleNameField;
    @FindBy(id = "edit_role_description")
    WebElement editRoleDesc;
    @FindBy(id = "role_edit")
    WebElement saveEditRole;


    @FindBy(id = "add_privilege_4")
    WebElement addPrivilageForNewRole;
    @FindBy(id = "choose_privilege")
    WebElement choosePrivilage;
    @FindBy(id = "privilege_add")
    WebElement savePrivilege;

    @FindBy(id = "open_folder_button_4")
    WebElement openRole;
    @FindBy(id = "delete_privilege_4_0")
    WebElement deletePrivilegeFromRole;

    @FindBy(id = "delete_role_4")
    WebElement deleteRole;


    private WebDriver driver;
    public Roles(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnRolesButton(){rolesButton.click();}
    public void clickOnAddRoleButton(){addRoleButton.click();}
    public void typeIntoAddRoleNameField(){addRoleNameField.sendKeys("test");}
    public void typeIntoAddRoleDescriptionField(){addRoleDescriptionField.sendKeys("Rola123");}
    public void clickOnSaveNewRole(){saveNewRole.click();}
    public void clickOnEditRole(){editRole.click();}
    public void typeIntoEditRoleNameField(){editRoleNameField.sendKeys("Rola123445");}
    public void typeIntoEditRoleDescription(){editRoleDesc.sendKeys("testEdycjiOpisu");}
    public void clickOnSaveEditRoleButton(){saveEditRole.click();}

    public void clickAddPrivilegeForNewRole(){addPrivilageForNewRole.click();}
    public void selectChoosePrivilege(){
        Select select = new Select(choosePrivilage);
        select.selectByIndex(1);
    }
    public void clickOnSavePrivilege(){savePrivilege.click();}
    public void clickOpenRole(){openRole.click();}
    public void clickOnDeletePrivilegeFromRoleButton(){deletePrivilegeFromRole.click();}
    public void clickDeleteRoleButton(){deleteRole.click();}

}
