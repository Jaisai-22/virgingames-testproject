package com.virgingames.cucucmber;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


//@RunWith annotation tells about the test runner class to start executing our tests.
//This default run with cucumber// This is to open and close browser after every scenario with cucumber
@RunWith(Cucumber.class)
//@CucumberOptions() annotation is used to set some properties for our cucumber test like feature file, step definition, etc.
@CucumberOptions(
        features = ".",  // This is to read all features file
        plugin = {"pretty","html:target/cucumber-report/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html",
                "json:target/RunCuke/cucumber.json"},
        //This is for simple report generate default
        tags =  "@Smoke, @Sanity, @Regression" // This is to run with scenario

)


public class CukeTest {

    @AfterClass
    public static void setUp(){
        String projectPath = System.getProperty("user.dir");
        String reportConfigPath= projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
        Reporter.loadXMLConfig(reportConfigPath);
        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine","Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium","3.141.59");
        Reporter.setSystemInfo("Jana version","1.8.0_151");



    }

}
