package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Privileges {




@FindBy(id = "privileges")
    WebElement privilegesButton;
@FindBy(id = "add_privilege_button")
WebElement addNewPrivillegeButton;
@FindBy(id = "add_name")
WebElement addNameField;
@FindBy(id = "privilege_add")
WebElement saveNewPrivilege;
@FindBy(id = "delete_7")
WebElement deletePrivilege;


    private WebDriver driver;
    public Privileges(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void clickOnPrivilegeButton(){privilegesButton.click();}
    public void clickOnAddPrivilegeButton(){addNewPrivillegeButton.click();}
    public void typeIntoAddNameField(){addNameField.sendKeys("testNameField");}
    public void clickOnSaveNewPrivilege(){saveNewPrivilege.click();}

    public void clickOnDeletePrivilegeButton(){deletePrivilege.click();}


}
