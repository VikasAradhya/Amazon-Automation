package org.com.AmazonAuto.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.com.AmazonAuto.PageObjectModel.LandingPageAmazon;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class basetest {
    protected  WebDriver driver;
   public LandingPageAmazon lp;
    public WebDriver initializeDriver() throws IOException {
        Properties pp = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//com//AmazonAuto//resources//GlobalData.properties");
        pp.load(fis);
        String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser") : pp.getProperty("browser");
        if (BrowserName.equals("chrome")){

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver(options);

        } else if (BrowserName.equals("firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeMethod
    public LandingPageAmazon launchapp() throws IOException {
        driver=initializeDriver();
        lp= new LandingPageAmazon(driver);
        lp.launchapp();
        return lp;
    }
    public String getScreeenshot(String testCasename, WebDriver driver) throws IOException {
        TakesScreenshot ts  = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "//Screenshot//" + testCasename + ".jpg");
        FileUtils.copyFile(src,dest);
        return System.getProperty("user.dir") + "//Screenshot//" + testCasename + ".jpg";
    }

}
