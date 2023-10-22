package org.com.AmazonAuto.PageObjectModel;

import org.com.AmazonAuto.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn  extends AbstractComponent {
    WebDriver driver;
    public SignIn(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
//driver.findElement(By.cssSelector("#ap_email")).sendKeys("aradhyavikas123@gmail.com");
//       driver.findElement(By.cssSelector("#continue")).click();
//       driver.findElement(By.cssSelector("#ap_password")).sendKeys("Vicky@1996");
//       driver.findElement(By.cssSelector("#signInSubmit")).click();

    @FindBy(css = "#ap_email")
    WebElement EmailTextBox;

    @FindBy(css = "#continue")
    WebElement continueBtn;

    @FindBy(css = "#ap_password")
    WebElement passTextBox;

    @FindBy(css = "#signInSubmit")
    WebElement SignInBtn;

    public void enteremail(String email){
        EmailTextBox.sendKeys(email);
        continueBtn.click();
    }
    public void enterPassword(String password){
        passTextBox.sendKeys(password);
        SignInBtn.click();
    }
}
