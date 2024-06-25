package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement dashboardText;

    public String getDashboardText() {
        log.info("Get dashboard text" + dashboardText.getText());
        return getTextFromElement(dashboardText);
    }
}
