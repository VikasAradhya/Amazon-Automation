package org.com.AmazonAuto.PageObjectModel;

import org.com.AmazonAuto.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class Productpage extends AbstractComponent {
    WebDriver driver;
    public Productpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    By cart = By.id("add-to-cart-button");
    @FindBy(id = "add-to-cart-button")
    WebElement addcartBtn;
     @FindBy(id = "attach-close_sideSheet-link")
     WebElement closeSheet;
    //driver.findElement(By.linkText(pName)).click();
//    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
//        driver.findElement(By.id("add-to-cart-button")).click();
           //  driver.findElement(By.id("attach-close_sideSheet-link")).click();
public void getProductByName(String model){

    driver.findElement(By.linkText(model)).click();
}
    public void SwitchwindowFocus(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public CartPage addToCart(){
    try {
        waitForElementToAppear(cart);
        addcartBtn.click();
        closeSheet.click();

    }catch (Exception e){
        e.printStackTrace();
    }
        return new CartPage(driver);
    }


}
