package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFunctionality {
	private WebDriver driver;

	By searchPlace = By.id("APjFqb");
	By search = By.xpath("//input[@name='btnk']");
	By searchMutlipleResults = By.xpath("//ul[@role='listbox']");

	public SearchFunctionality(WebDriver driver) {
		this.driver = driver;
	}

	public void searchResult(String query) {
		WebElement searchBox = driver.findElement(searchPlace);
		searchBox.sendKeys(query);

	}

	public void clickOnSearch() {
WebElement searchbtn = driver.findElement(search);
searchbtn.click();
	}
public void clickOnFirstResult() {

	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(searchMutlipleResults)).click();

       	
	
	}
}
