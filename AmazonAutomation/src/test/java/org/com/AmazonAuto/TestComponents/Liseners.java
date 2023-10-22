package org.com.AmazonAuto.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.com.AmazonAuto.resources.ExtentReportNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Liseners extends basetest implements ITestListener {
    ExtentTest test;
    ExtentReports extent =  ExtentReportNG.getReporterObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {
       test= extent.createTest(result.getMethod().getMethodName());
       extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //test.log(Status.FAIL,"test Failed");
        extentTest.get().fail(result.getThrowable());
        try{
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //screenshot
        String filepath = null;
        try {
            filepath=getScreeenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }



    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
