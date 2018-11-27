package Cucumber_Selenium.Cucumber_Selenium;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src\\test\\java\\features",glue= {"gluecode"},plugin = { "pretty", "html:target/htmlreports"})
@CucumberOptions(features="src\\test\\resources\\features",glue= {"gluecode"},plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true)
public class CucumberRunnerTest {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src\\test\\resources\\config\\report.xml"));
    
    }
}
