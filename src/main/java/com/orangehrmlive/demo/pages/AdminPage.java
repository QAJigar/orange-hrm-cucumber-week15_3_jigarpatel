package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {
    private static final Logger log = LogManager.getLogger(AdminPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-body']/nav[1]/ul[1]/li[1]/span[1]/i[1]")
    WebElement user;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-body']/nav[1]/ul[1]/li[2]/span[1]/i[1]")
    WebElement job;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-body']/nav[1]/ul[1]/li[3]/span[1]/i[1]")
    WebElement organization;

    public void UserManagement() throws InterruptedException {
        log.info("Selecting User: " + user.toString());
        clickOnElement(user);
        Thread.sleep(1000);
    }

    public void ClickJob() throws InterruptedException {
        log.info("Clicking on Job: " + job.toString());
        clickOnElement(job);
        Thread.sleep(1000);
    }

    public void ClickOrganization() {
        log.info("Clicking on Organization: " + organization.toString());
        clickOnElement(organization);
    }
}
