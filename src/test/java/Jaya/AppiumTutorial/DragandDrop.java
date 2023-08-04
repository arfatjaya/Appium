package Jaya.AppiumTutorial;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DragandDrop  extends BaseTest{
	@Test
	public void appiumTest() throws MalformedURLException
	
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_ddot_1"));
		
	 
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 560
			));

	String actual=	driver.findElement(By.id("")).getText();
	Assert.assertEquals(actual, "Dropped!");
}
}


