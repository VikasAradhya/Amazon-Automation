package org.com.AmazonAuto.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.com.AmazonAuto.TestComponents.basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class standAloneTest extends basetest {
    public static void main(String[] args) {
        String pName = "Apple iPhone 14 Pro Max (256 GB) - Space Black";
        String Quantity = "1";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
        driver.findElement(By.linkText(pName)).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("attach-close_sideSheet-link")).click();
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
       driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
        WebElement Qty = driver.findElement(By.xpath("//ul[@role='listbox']"));
        List<WebElement> QtyList = Qty.findElements(By.xpath("//li[@role='option']"));
       for (WebElement Li : QtyList){
           if(Li.getText().equals(Quantity)){
               Li.click();
           }
       }
       driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();


       driver.findElement(By.cssSelector("#ap_email")).sendKeys("aradhyavikas123@gmail.com");
       driver.findElement(By.cssSelector("#continue")).click();
       driver.findElement(By.cssSelector("#ap_password")).sendKeys("Vicky@1996");
       driver.findElement(By.cssSelector("#signInSubmit")).click();

    }


}
