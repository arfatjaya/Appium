package Jaya.AppiumTutorial;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public AndroidDriver driver;

	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		// run server auto matic

		/*
		 * AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new
		 * File(
		 * "C:\\Users\\samqu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
		 * )) .withIPAddress("127.0.0.1").usingPort(4723).build();
		 */

		// service.start();

		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("vivo V2151");
		option.setApp(
				"C:\\Users\\samqu\\eclipse-workspace\\AppiumTutorial\\src\\test\\java\\Resource\\ApiDemos-debug.apk");

	//	URL appiumServerURL = new URL("http://192.168.183.35:4723");
		URL appiumServerURL = new URL("http://127.0.0.1:4723");

		driver = new AndroidDriver(appiumServerURL, option);
	}
	
	// thismethod will long press
	
	public void longpress(WebElement ele) 
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration", 2000));
						
		
	}
	
	// this  method will keep on scrole based enad of page
	public void scrollToEnd()
	{
		
		boolean canScrollMore;
		do {
		  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));}
		while(canScrollMore);
		
		
		
	}
	//This gesture performs swipe gesture on the given element/area.
	
	public void swipeGesture(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}

}
