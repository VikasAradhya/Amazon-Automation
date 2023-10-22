package org.com.AmazonAuto.PageObjectModel;

import org.com.AmazonAuto.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPageAmazon extends AbstractComponent {

WebDriver driver;
    public LandingPageAmazon(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement SearchBox;

    //       driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement Searchbtn;
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
   By SearchRes= By.xpath("//div[@data-component-type='s-search-result']");
    public void launchapp(){
        driver.get("https://www.amazon.in/");

    }
    public Productpage searchproduct(String pName){
        SearchBox.sendKeys(pName);
        Searchbtn.click();
        waitForElementToAppear(SearchRes);
        return new Productpage(driver);
    }

}
