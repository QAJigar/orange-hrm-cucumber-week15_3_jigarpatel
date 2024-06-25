package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddUserPage extends Utility {
    private static final Logger log = LogManager.getLogger(AddUserPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='User Role']/following::div[@class='oxd-select-wrapper'][1]")
    WebElement userRoleDropDown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option']")
    List<WebElement> userRoleOptions;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//label[text()='Username']/following::div[1]/input[@class='oxd-input oxd-input--active']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='Status']/following::div[@class='oxd-select-wrapper'][1]")
    WebElement statusDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option']")
    List<WebElement> statusOptions;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//label[text()='Password']/following::div[1]/input[@class='oxd-input oxd-input--active']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//label[text()='Confirm Password']/following::div[1]/input[@class='oxd-input oxd-input--active']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")  //"//div[@class='oxd-toast-container oxd-toast-container--bottom']//p[2]"
    WebElement successfullySavedMessage;

 /*   @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']")
    WebElement suggestionContainer;*/

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']//div[@role='option']")
    List<WebElement> empNameSuggesstionList;

    public void selectUserRoleOption(String option) {
        clickOnElement(userRoleDropDown);
        List<WebElement> userRolesList = webElementList(userRoleOptions);
        for (WebElement e : userRolesList) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
        log.info("Select option '" + option + "' from user role dropdown field" + userRoleDropDown.toString());
    }

    public void selectStatusOption(String option) {
        clickOnElement(statusDropdown);
        List<WebElement> statusList = webElementList(statusOptions);
        for (WebElement e : statusList) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
        log.info("Select status option '" + option + "' from status dropdown field");

    }

    public void enterTextToUsername(String username) {
        sendTextToElement(usernameField, username);
        log.info("Enter username: " + username + "to username field " + usernameField.toString());

    }

    public void enterTextToPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter password to password field " + passwordField.toString());
    }

    public void enterTextToConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
        log.info("Enter password to password field " + confirmPasswordField.toString());
    }

    public void clickOnSaveButton() throws InterruptedException {
        clickOnElement(saveButton);
        //Thread.sleep(1000);
        log.info("Click on save button " + saveButton.toString());
    }

    public void clickOnCancelButton() {
        clickOnElement(cancelButton);
        log.info("Click on cancel button" + cancelButton.toString());
    }

    public String getSuccessfullySavedText() {
        log.info("Get Successfully Saved Text" + successfullySavedMessage.getText());
        return getTextFromElement(successfullySavedMessage);
    }

    public void selectEmpNameFromAutoComplete(String empName) throws InterruptedException {
        sendTextToElement(employeeName, empName);
        Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //  wait.until(ExpectedConditions.visibilityOf(suggestionContainer));
        for (WebElement suggestion : empNameSuggesstionList) {
            if (suggestion.getText().equalsIgnoreCase(empName)) {
                suggestion.click();
                break;
            }
        }
        log.info("Enter Employee name" + empName + " and select EmployeeName " + employeeName.toString());
    }
}
