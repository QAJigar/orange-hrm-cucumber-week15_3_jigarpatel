package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UsersTestSteps {
    @When("Login to Application")
    public void loginToApplication() {
        new LoginPage().loginToApplication("Admin", "admin123");
    }

    @And("click On Admin Tab")
    public void clickOnTab() {
        new HomePage().clickOnAdminTab();

    }

    @Then("Verify {string} text")
    public void verifyText(String systemUserText) {
        Assert.assertEquals(new ViewSystemUsersPage().getSystemUserText(), systemUserText, "System Users text is not displayed");
    }

    @When("click On Add button")
    public void clickOnAddButton() {
        new ViewSystemUsersPage().clickOnAddButton();
    }

    @And("verify addUser {string} Text")
    public void verifyAddUserText(String addUserText) {
        Assert.assertEquals(new ViewSystemUsersPage().getAddUserText(), addUserText, "Add User text is not displayed");
    }

    @When("Select User Role {string}")
    public void selectUserRole(String role) {
        new AddUserPage().selectUserRoleOption(role);
    }

    @And("enter Employee Name {string}")
    public void enterEmployeeName(String empName) throws InterruptedException {
        new AddUserPage().selectEmpNameFromAutoComplete(empName);
    }

    @And("enter username {string}")
    public void enterUsername(String username) {
        new AddUserPage().enterTextToUsername(username);
    }

    @And("Select status {string}")
    public void selectStatus(String status) {
        new AddUserPage().selectStatusOption(status);
    }

    @And("enter password {string}")
    public void enterPassword(String password) {
        new AddUserPage().enterTextToPassword(password);
    }

    @And("enter Confirm Password {string}")
    public void enterConfirmPassword(String confirmPassword) {
        new AddUserPage().enterTextToConfirmPassword(confirmPassword);
    }

    @And("click On Save Button")
    public void clickOnSaveButton() throws InterruptedException {
        new AddUserPage().clickOnSaveButton();
    }

    @Then("verify message {string}")
    public void verifyMessage(String successText) {
        Assert.assertEquals(new AddUserPage().getSuccessfullySavedText(), successText, "Successfully not saved");
    }

    @When("Enter Username {string} into System User section")
    public void enterUsernameIntoSystemUserSection(String username) {
        new ViewSystemUsersPage().enterTextToUsername(username);
    }

    @And("Select User Role {string} into System User section")
    public void selectUserRoleIntoSystemUserSection(String userRole) {
        new ViewSystemUsersPage().selectUserRoleOption(userRole);
    }

    @And("Select Status {string} into System User section")
    public void selectStatusIntoSystemUserSection(String status) {
        new ViewSystemUsersPage().selectStatusOption(status);
    }

    @And("Click on Search Button from System Users Page")
    public void clickOnSearchButtonFromSystemUsersPage() throws InterruptedException {
        new ViewSystemUsersPage().clickOnSearchButton();
    }

    @Then("Verify the User should be in Result list")
    public void verifyTheUserShouldBeInResultList() {
        Assert.assertEquals(new ViewSystemUsersPage().getUserFoundText(), "Jigar", "User is not displayed");
    }


    @When("Click on Check box")
    public void clickOnCheckBox() {
        new ViewSystemUsersPage().clickOnCheckBoxFromTable();
    }

    @And("Click on Delete Button")
    public void clickOnDeleteButton() {
        new ViewSystemUsersPage().clickOnDeleteButton();
    }

    @And("Click on Ok Button on Popup")
    public void clickOnOkButtonOnPopup() {
        new ViewSystemUsersPage().clickOnDeletePopupButton();
    }

    @And("verify user deleted message {string}")
    public void verifyUserDeletedMessage(String expectedText) {
        Assert.assertEquals(new ViewSystemUsersPage().getSuccessfullyDeletedText(), expectedText, "Successfully Deleted message is not displayed");
    }


    @And("Enter username {string} from System User section")
    public void enterUsernameFromSystemUserSection(String username) {
        new ViewSystemUsersPage().enterTextToUsername(username);
    }

    @And("Select User role {string} from System User page")
    public void selectUserRoleFromSystemUserPage(String userRole) {
        new ViewSystemUsersPage().selectUserRoleOption(userRole);
    }


    @And("Enter EmployeeName {string} from System User section")
    public void enterEmployeeNameFromSystemUserSection(String employeeName) throws InterruptedException {
        new ViewSystemUsersPage().selectEmpNameFromAutoComplete(employeeName);

    }

    @And("Select status {string} from System User section")
    public void selectStatusFromSystemUserSection(String status) {
        new ViewSystemUsersPage().selectStatusOption(status);
    }

    @Then("verify record found message {string}")
    public void verifyRecordFoundMessage(String expectedMessage) {
        Assert.assertEquals(new ViewSystemUsersPage().getRecordFoundText(), expectedMessage, "Record not match");
    }

    @Then("Verify username {string}")
    public void verifyUsername(String username) {
        Assert.assertEquals(new ViewSystemUsersPage().getUserFoundText(), username, "User is not found");
    }

    @And("Click on Reset Tab")
    public void clickOnResetTab() {
        new ViewSystemUsersPage().clickOnResetButton();
    }
}
