package org.com.AmazonAuto.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
public void waitForElementToAppear(By findby){
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
}
public void waitforWebElementToLocated(WebElement findby){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(findby));
}
public void waitForElementToDisappear(WebElement findby){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.invisibilityOf(findby));
}

}
