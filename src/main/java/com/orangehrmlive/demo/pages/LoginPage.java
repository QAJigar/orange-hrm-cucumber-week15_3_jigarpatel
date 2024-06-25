package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(className = "orangehrm-login-button")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement profileLogo;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//li//a[text()='Logout']")
    WebElement logout;

    @CacheLookup
    @FindBy(className = "orangehrm-login-title")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']/following::span[1]")
    WebElement usernameRequiredErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']/following::span[1]")
    WebElement passwordRequiredErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialsErrorMessage;


    public void clickOnProfileLogo() {
        clickOnElement(profileLogo);
        log.info("Click on profile logo" + profileLogo.toString());
    }

    public void mouseHoverToLogoutAndClick() {
        mouseHoverToElementAndClick(logout);
        log.info("Mouse Hover to Logout and click " + logout.toString());
    }

    public String getLoginText() {
        log.info("Get login text" + loginText.getText());
        return getTextFromElement(loginText);
    }

    public void enterTextToUsername(String username) {
        sendTextToElement(usernameField, username);
        log.info("Enter username: " + username + "to username field" + usernameField.toString());
    }

    public void enterTextToPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter password: " + password + "to password field" + passwordField.toString());

    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Click on login button" + loginButton.toString());
    }

    /**
     * this method will  login to application
     *
     * @param username
     * @param password
     */
    public void loginToApplication(String username, String password) {
        enterTextToUsername(username);
        enterTextToPassword(password);
        clickOnLoginButton();
        log.info("Login to application");
    }

    public String getUserNameFieldErrorMessage() {
        log.info("Get UserName Field Error Message " + usernameRequiredErrorMessage.getText());
        return getTextFromElement(usernameRequiredErrorMessage);
    }

    public String getPasswordFieldErrorMessage() {
        log.info("Get Password Field Error Message " + passwordRequiredErrorMessage.getText());
        return getTextFromElement(passwordRequiredErrorMessage);
    }

    public String getInvalidCredentialErrorMessage() {
        log.info("Get Invalid Credentials Error Message" + invalidCredentialsErrorMessage.getText());
        return getTextFromElement(invalidCredentialsErrorMessage);
    }

}
