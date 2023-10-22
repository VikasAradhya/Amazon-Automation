package org.com.AmazonAuto.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="C:/Users/aradh/IdeaProjects/AmazonAutomation/src/test/java/org/com/AmazonAuto/Cucumber/Submitorder.feature",
glue = "org/com/AmazonAuto/StepDefination", monochrome = true, plugin = {"html:target/cucumber1.html"})
public class testngRunner extends AbstractTestNGCucumberTests {
}
