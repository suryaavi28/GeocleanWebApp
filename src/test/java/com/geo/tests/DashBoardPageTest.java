package com.geo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adc.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.MainPage;

public class DashBoardPageTest extends TestBase {
	DashBoardPage db;
	MainPage mp ;
	
	@BeforeMethod
	public void preBase() throws InterruptedException {
		setUp();
		mp = new MainPage(driver);
		db= mp.enterValidMobNoandValidOTP();
	
	}
	
	
	@Test
	public void enterValidMobNoandInvalidOTP() {
		String title= db.titleOfTheDashBoardPage();
		Assert.assertEquals(title, "Geoclean");
	}
}
