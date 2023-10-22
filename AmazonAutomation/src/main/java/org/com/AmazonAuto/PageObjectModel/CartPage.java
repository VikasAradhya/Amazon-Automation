package org.com.AmazonAuto.PageObjectModel;

import org.com.AmazonAuto.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement cartBtn;
    @FindBy(xpath = "//span[@id='a-autoid-0']")
    WebElement QtyBtn;
    @FindBy(xpath = "//ul[@role='listbox']")
    WebElement QtyUl;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
            WebElement proceedCheckout;

    By Qty = By.xpath("//li[@role='option']");
public void gotocartPage(){
        cartBtn.click();
}
//driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
//    WebElement Qty = driver.findElement(By.xpath("//ul[@role='listbox']"));
//    List<WebElement> QtyList = Qty.findElements(By.xpath("//li[@role='option']"));
//       for (WebElement Li : QtyList){
//        if(Li.getText().equals(Quantity)){
//            Li.click();
   //     }
  //  }
public void SetQuantity(String Quantity){
    QtyBtn.click();
    List<WebElement> QtyList = QtyUl.findElements(Qty);
    for (WebElement Li : QtyList){
        if (Li.getText().equals(Quantity)){
            Li.click();
        }
    }
}

//driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();

    public SignIn proceedCheckout(){
    proceedCheckout.click();
    return new SignIn(driver);
    }
}
