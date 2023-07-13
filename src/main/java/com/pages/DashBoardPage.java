package com.pages;

import org.openqa.selenium.WebDriver;

public class DashBoardPage {
WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver= driver;
	}
	
	
	public String titleOfTheDashBoardPage() {
		return driver.getTitle();
	}
	
	
	
}
