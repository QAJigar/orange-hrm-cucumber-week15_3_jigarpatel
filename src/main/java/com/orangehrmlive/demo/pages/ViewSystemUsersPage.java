package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewSystemUsersPage extends Utility {
    private final static Logger log = LogManager.getLogger(ViewSystemUsersPage.class);
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-filter-header-title']//h5[text()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6[text()='Add User']")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//label[text()='Username']/following::div[1]/input[@class='oxd-input oxd-input--active']")
    WebElement usernameField;

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
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='Status']/following::div[@class='oxd-select-wrapper'][1]")
    WebElement statusDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option']")
    List<WebElement> statusOptions;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span[@class='oxd-text oxd-text--span']")
    WebElement recordFoundText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border']//div[@role='cell'][2]/div")
    WebElement userFoundText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']")
    WebElement tableCheckBoxColumn;

    @CacheLookup
    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']/i[@class='oxd-icon bi-trash']")
    WebElement tableDeleteButton;

    @CacheLookup
    @FindBy(xpath = "//div[@role='document']//div[@class='orangehrm-modal-footer']/button[2]")
    WebElement yesDeleteButtonPopup;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")  //"//div[@class='oxd-toast-container oxd-toast-container--bottom']//p[2]"
    WebElement successfullyDeletedMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']//div[@role='option']")
    List<WebElement> empNameSuggesstionList;

    public String getSystemUserText() {
        log.info("Get system user text " + systemUsersText.getText());
        return getTextFromElement(systemUsersText);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
        log.info("Click on add button " + addButton.toString());
    }

    public String getAddUserText() {
        log.info("Get add user text " + addUserText.getText());
        return getTextFromElement(addUserText);
    }

    public void clickOnSearchButton() throws InterruptedException {
        clickOnElement(searchButton);
        log.info("Click on search button " + searchButton.toString());
        Thread.sleep(5000);
    }

    public void clickOnResetButton() {
        clickOnElement(resetButton);
        log.info("Click on reset button " + resetButton.toString());
    }

    public void enterTextToUsername(String username) {
        sendTextToElement(usernameField, username);
        log.info("Enter username: " + username + "to username field " + usernameField.toString());
    }

    public void selectUserRoleOption(String option) {
        clickOnElement(userRoleDropDown);
        List<WebElement> userRolesList = webElementList(userRoleOptions);
        for (WebElement e : userRolesList) {
            if (e.getText().contains(option)) {
                e.click();
                break;
            }
        }
        log.info("Select option '" + option + "' from user role dropdown field " + userRoleDropDown.toString());

    }


    public void selectStatusOption(String option) {
        clickOnElement(statusDropdown);
        List<WebElement> statusList = webElementList(statusOptions);
        for (WebElement e : statusList) {
            if (e.getText().contains(option)) {
                e.click();
                break;
            }
        }
        log.info("Select status option '" + option + "' from status dropdown field" + statusDropdown.toString());
    }

    public String getRecordFoundText() {
        log.info("Get record found text" + recordFoundText.getText());
        return getTextFromElement(recordFoundText);
    }

    public String getUserFoundText() {
        log.info("Get UserName found text" + userFoundText.getText());
        return getTextFromElement(userFoundText);
    }

    public void clickOnCheckBoxFromTable() {
        clickOnElement(tableCheckBoxColumn);
        log.info("Click on checkbox from user want to delete" + tableCheckBoxColumn.toString());
    }

    public void clickOnDeleteButton() {
        clickOnElement(tableDeleteButton);
        log.info("Click on delete button from user want to delete " + tableDeleteButton.toString());
    }

    public void clickOnDeletePopupButton() {
        clickOnElement(yesDeleteButtonPopup);
        log.info("Click on YesDelete Button from popup " + yesDeleteButtonPopup.toString());
    }

    public String getSuccessfullyDeletedText() {
        log.info("Get Successfully deleted message  " + successfullyDeletedMessage.getText());
        return getTextFromElement(successfullyDeletedMessage);
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
