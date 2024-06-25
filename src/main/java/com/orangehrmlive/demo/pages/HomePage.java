package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement orangeHrmLogo;


    @CacheLookup
    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[1]/a")
    WebElement adminTab;


    public void clickOnAdminTab() {
        clickOnElement(adminTab);
        log.info("Click on admin tab " + adminTab.toString());
    }

    public Boolean isOrangeHrmLogoDisplayed() {
        log.info("check logo is displayed or not" + orangeHrmLogo.toString());
        return verifyThatElementIsDisplayed(orangeHrmLogo);
    }
}
