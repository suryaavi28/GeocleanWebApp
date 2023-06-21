package com.utilis;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	static WebDriver driver;
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	
	public WebElement elementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
		 return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public boolean waitForElementToBeSelected(WebDriver driver, By locator, int timeoutInSeconds) {
	    
	    return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
	   
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean waitForInvisibility(WebDriver driver, By locator, int timeoutInSeconds) {
	    
	    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
	   
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean waitForTextPresence(WebDriver driver, By locator, String text, int timeoutInSeconds) {
	   	    return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public boolean waitForTitleContains(WebDriver driver, String partialTitle, int timeoutInSeconds) {
	  
	    return wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
	
	public boolean waitForTitleIs(WebDriver driver, String title, int timeoutInSeconds) {
	   
	    return wait.until(ExpectedConditions.titleIs(title));
	}

	public WebDriver waitForFrameAndSwitchToIt(WebDriver driver, By frameLocator, int timeoutInSeconds) {
	    	    return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}


	public Alert waitForAlertDialog(WebDriver driver, int timeoutInSeconds) {
	   
	    return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public boolean waitForElementSelectionState(WebDriver driver, By locator, boolean isSelected, int timeoutInSeconds) {
	 
	    return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, isSelected));
	}


	
	

}
