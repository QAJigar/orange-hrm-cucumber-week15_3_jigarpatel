package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Objects;

public class LoginTestSteps {
    @Given("I am on HomePage")
    public void iAmOnHomePage() {
    }

    //Enter username
    @When("Enter username")
    public void enterUsername() {
        new LoginPage().enterTextToUsername("Admin");
    }

    //Enter password
    @And("Enter password")
    public void enterPassword() {
        new LoginPage().enterTextToPassword("admin123");
    }

    //Click on Login Button
    @And("Click on Login Button")
    public void clickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    //Verify "Dashboard" Message
    @Then("Verify {string} Message should displayed")
    public void verifyMessageShouldDisplayed(String dashboardText) {
        Assert.assertEquals(new DashboardPage().getDashboardText(), dashboardText, "Dashboard text is not displayed");
    }

    //Login To The application
    @When("Login To The application with username {string} and password {string}")
    public void loginToTheApplicationWithUsernameAndPassword(String username, String password) {
        new LoginPage().loginToApplication(username, password);
    }

    //Verify Logo is Displayed
    @Then("Verify Logo is Displayed")
    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(new HomePage().isOrangeHrmLogoDisplayed(), "Logo is not displayed");
    }

    //Click on User Profile logo
    @And("Click on User Profile logo")
    public void clickOnUserProfileLogo() {
        new LoginPage().clickOnProfileLogo();
    }

    //Mouse hover on "Logout" and click
    @And("Mouse hover on Logout and click")
    public void mouseHoverOnAndClick() {
        new LoginPage().mouseHoverToLogoutAndClick();
    }

    //Verify the text "Login Panel" is displayed
    @Then("Verify the text {string} is displayed")
    public void verifyTheTextIsDisplayed(String loginText) {
        Assert.assertEquals(new LoginPage().getLoginText(), loginText, "Login Text is not displayed");
    }

    //Enter Username <username>
    @When("Enter Username {string}")
    public void enterUsername(String username) {
        new LoginPage().enterTextToUsername(username);
    }

    //Enter Password <password>
    @And("Enter Password {string}")
    public void enterPassword(String password) {
        new LoginPage().enterTextToPassword(password);
    }

    //Verify Error message <errorMessage>
    @Then("Verify Error message {string} as per username {string} and password {string}")
    public void verifyErrorMessageAsPerUsernameAndPassword(String errorMessage, String username, String password) {
        if (Objects.equals(username, "")) {
            Assert.assertEquals(new LoginPage().getUserNameFieldErrorMessage(), errorMessage);
        } else if (Objects.equals(password, "")) {
            Assert.assertEquals(new LoginPage().getPasswordFieldErrorMessage(), errorMessage);
        } else {
            Assert.assertEquals(new LoginPage().getInvalidCredentialErrorMessage(), errorMessage);
        }
    }
}
