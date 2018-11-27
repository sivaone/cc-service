package common;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import pages.Repository;

public class CommonWorkflowUtil extends CommonUtil {

    public void performSearch(String searchItem){
        setValue(Repository.Common.txtSearch,searchItem);
        clickEnter(Repository.Common.btnGo);
    }
    
    public boolean validateElementDisplayed(String CSSValue){
    	if(fluentWaitForElementDisplayed(By.cssSelector(CSSValue))) {
        	return true;
        }else {
        	System.out.println("Element is not displayed");
        	return false;
        }
    }

    public void setValue(String CSSValue,String valueToSet){
    	if(fluentWaitForElementDisplayed(By.cssSelector(CSSValue))) {
        	fluentWaitForElement(By.cssSelector(CSSValue)).clear();
        	fluentWaitForElement(By.cssSelector(CSSValue)).sendKeys(valueToSet);
        }else {
        	System.out.println("Element is not displayed");
        }
    }
    
    public boolean clickElement(String CSSValue){
    	if(fluentWaitForElementDisplayed(By.cssSelector(CSSValue))) {
        	fluentWaitForElement(By.cssSelector(CSSValue)).click();
        	return true;
        }else {
        	System.out.println("Element is not displayed");
        	return false;
        }
    }

    public boolean clickEnter(String CSSValue){
        if(fluentWaitForElementDisplayed(By.cssSelector(CSSValue))) {
            fluentWaitForElement(By.cssSelector(CSSValue)).sendKeys(Keys.ENTER);
            return true;
        }else {
            System.out.println("Element is not displayed");
            return false;
        }
    }
}
