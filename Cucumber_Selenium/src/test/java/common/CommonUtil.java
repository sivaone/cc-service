package common;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonUtil {
	
	private static WebDriver driver;
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(CommonUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
            System.out.println("Error loading config file");
			e.printStackTrace();

		}
	}

	public void createSauceWebDriverInstance() throws MalformedURLException {
		System.out.println("test");
		String URL = "https://srinivasuluj7:322eb9ab-60a7-4ba3-a1a1-aeb008424b9c@ondemand.saucelabs.com:443/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		 
		    driver = new RemoteWebDriver(new URL(URL), caps);
		 
		    /**
		     * Goes to Sauce Lab's guinea-pig page and prints title
		     */
		 
		    driver.get(properties.getProperty("appUrl"));
		    System.out.println("title of page is: " + driver.getTitle());
		 
		    driver.quit();
	}

	public void createWebDriverInstance() throws MalformedURLException{
		String driverPath = "";
		if(properties.getProperty("runOnSauce").equalsIgnoreCase("yes")){
			createSauceWebDriverInstance();
		}else{
			if(properties.getProperty("driver").contains("chrome")){
				driverPath = CommonUtil.class.getClassLoader().getResource(properties.getProperty("driver")).getPath();
				System.setProperty("webdriver.chrome.driver",driverPath);
				driver = new ChromeDriver();
				driver.get(properties.getProperty("appUrl"));
			}
		}
	}

	public WebElement fluentWaitForElement(final By locator) {
		WebElement element = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(250, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
				.ignoring(WebDriverException.class);

		try {
			return wait.until((d)-> d.findElement(locator));
		} catch (Exception t) {
			t.printStackTrace();
		}
		return element;
	}

	/**
	 *
	 * @param locator
	 * @return
	 */
	public Boolean fluentWaitForElementDisplayed(final By locator) {
		Boolean flag = false;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(250, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.ignoring(WebDriverException.class);
		try {
			return wait.until((d)-> d.findElement(locator).isDisplayed());
		} catch (Exception t) {
			t.printStackTrace();
		}
		return flag;
	}







}
