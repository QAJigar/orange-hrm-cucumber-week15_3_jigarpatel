package com.orangehrmlive.demo.browserfactory;

import com.orangehrmlive.demo.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);
    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    static int implicitlyWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));


    public ManageBrowser(){
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/log4j2.properties");

    }

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else {
            //For other reporter --> System.out.println("Wrong browser");
            log.info("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Close Browser");
    }
}
