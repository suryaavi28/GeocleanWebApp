package com.adc.base;

import java.time.Duration;
import java.util.Properties;

import com.utilis.ReadConfigUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
     protected static WebDriver driver;
    static ReadConfigUtilities configUtils;

    @BeforeTest
    public static void setUp() {
        configUtils = new ReadConfigUtilities();
        configUtils.readConfig();

       
        String browser = configUtils.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")){
        	WebDriverManager.safaridriver().setup();
        	driver = new SafariDriver();
        }
        else{
            System.out.println("Please provide correct browser");
        }

        String url = configUtils.getProperty("url");
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
    }

//    @AfterTest
//    public static void tearDown() {
//        driver.quit();
//    }
}
