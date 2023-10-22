package org.com.AmazonAuto.Tests;

import org.com.AmazonAuto.PageObjectModel.CartPage;
import org.com.AmazonAuto.PageObjectModel.Productpage;
import org.com.AmazonAuto.PageObjectModel.SignIn;
import org.com.AmazonAuto.TestComponents.basetest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitoderTest extends basetest {


    @Test(dataProvider = "getdata")
    public void  Submitorder(String pName,String model,String Quantity,String email,String password){

        Productpage pc = lp.searchproduct(pName);
        pc.getProductByName(model);
        pc.SwitchwindowFocus();
        CartPage cp = pc.addToCart();
        cp.gotocartPage();
        cp.SetQuantity(Quantity);
        SignIn sn = cp.proceedCheckout();
        sn.enteremail(email);
        sn.enterPassword(password);
    }

    @DataProvider
    public Object[][] getdata(){
        return  new Object[][]{{"iphone","Apple iPhone 14 Pro Max (256 GB) - Space Black","1","aradhyavikas123@gmail.com","Vicky@1996"}};
    }
}
