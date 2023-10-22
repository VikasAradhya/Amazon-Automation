package org.com.AmazonAuto.StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.com.AmazonAuto.PageObjectModel.CartPage;
import org.com.AmazonAuto.PageObjectModel.LandingPageAmazon;
import org.com.AmazonAuto.PageObjectModel.Productpage;
import org.com.AmazonAuto.PageObjectModel.SignIn;
import org.com.AmazonAuto.TestComponents.basetest;

import java.io.IOException;


public class StepDefnImpl extends basetest {
    public LandingPageAmazon lp;
    public Productpage pc;
    public CartPage cp;
    public SignIn sn;
    @Given("^I landed on Amazon WebPage$")
    public void iLandedOnAmazonWebPage() throws IOException {
       lp= launchapp();
    }

    @Given("^Search For Product(.+)$")
    public void searchForProduct(String pName) {
      pc= lp.searchproduct(pName);
    }

    @When("^I Add Product(.+) To Cart$")
    public void iAddProductToCart(String model) {
        pc.getProductByName(model);
        pc.SwitchwindowFocus();
       cp= pc.addToCart();
    }

    @And("^Go to CartPage and Set Qty(.+)$")
    public void goToCartPageAndSetQty(String Quantity) {
        cp.gotocartPage();
        cp.SetQuantity(Quantity);
        sn=cp.proceedCheckout();
    }

    @Then("^Login with email(.+) and pass (.+)$")
    public void loginWithEmailAndPass(String email, String password) {
        sn.enteremail(email);
        sn.enterPassword(password);
    }
}
