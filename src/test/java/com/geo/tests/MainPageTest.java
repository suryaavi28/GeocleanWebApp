package com.geo.tests;

import static org.junit.Assert.assertArrayEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adc.base.TestBase;
import com.pages.MainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class MainPageTest extends TestBase {
	MainPage mp ;
	
	
	@BeforeMethod
	public void preBase() {
		setUp();
		mp = new MainPage(driver);
	}
	@Test(priority = 1,description = "Verifying title of the home page")//testng description
	@Description("title")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("title of the page")
	@Step("Click on the URL")
	@Severity(SeverityLevel.MINOR)
	public void verifyngTitleOfThePage_TC_MP_001() {
		String actual = mp.getTitleOfPage();
		String expected = "Geoclean";
		Assert.assertEquals(actual, expected);
		}
	@Test(priority = 2,description = "Verifying length of the username input ")//testng description
	@Description("length of the input")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Login of the page")
	@Step("Click on the URL")
	@Severity(SeverityLevel.NORMAL)
	  public void verifyUsernameMaxLength_TC_MP_002() throws InterruptedException {
        String username = "verylongihuihuihuih9y999h9h9h9hh9h*&Y****G&*G&*G*Guser"; // 37 characters
        mp.enterUsername(username); // Call the method from MainPage class
        Thread.sleep(4000);
//        int actualLength = mp.getUsernameLength();
        int expectedMaxLength = 32;

        Assert.assertTrue(username.length() <= expectedMaxLength, "Username length exceeds maximum allowed length");
    }
	@Test(priority = 3,description = "Verifying title of the home page")//testng description
	@Description("title")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("title of the page")
	@Step("Click on the URL")
	@Severity(SeverityLevel.MINOR)
	public void verifyingPlaceHolder_TC_MP_003() {
		String actual = mp.placeHolder();
		String ExpectedPH= "Email / Mobile Number";
		Assert.assertEquals(actual, ExpectedPH);
		
	}
	@Test(priority = 4,description = "Verifying Login with entering invalid email ID")//testng description
	@Description("Email ID")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Entering invalid email ID")
	@Step("Click on the URL")
	@Severity(SeverityLevel.NORMAL)	
	public void verifyingWithEnteringInvalidEmailID_TC_MP_004() {
		mp.enterMobNoUn("@gmail.com.geoclean");
		boolean enableOTP = mp.clickonSendOTP();
		Assert.assertEquals(enableOTP, false);
		
	}
	@Test(priority = 5,description = "VerifyingLogin with entering valid email ID")//testng description
	@Description("Email ID")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Entering valid email ID")
	@Step("Click on the URL")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyingWithEnteringValidEmailID_TC_MP_005() throws InterruptedException {
		mp.enterMobNoUn("ada@gmail.com");
		boolean enableOTP = mp.clickonSendOTP();
		Assert.assertEquals(enableOTP, true);
		mp.clickOnValidOTP();
		if (enableOTP==true) {
		boolean displayedValidation = mp.validationMsgOnRegistration();
		Thread.sleep(2000);
		Assert.assertEquals(displayedValidation, true);}else {
			System.out.println("THe test is failed");
		}
	}
	@Test(priority = 6,description = "Verifying Login with Invalid email id Test data-1")//testng description
	@Description("Email ID")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Entering with invalid email ID")
	@Step("Click on the URL")
	@Severity(SeverityLevel.MINOR)
	public void verifyingWithEnteringInValidEmailIDData1_TC_MP_006() throws InterruptedException {
		mp.enterMobNoUn("a@da@gmail.com.in");
		boolean enabledotp = mp.clickonSendOTP();
		Assert.assertEquals(enabledotp, false);
		if (enabledotp==true) {
		boolean clickable = mp.clickableOTP();
		Assert.assertEquals(clickable, false);}else{
			System.out.println("The test is Passed");
		}
	}
	@Test(priority = 7,description = "Verifying Login with Invalid email id Test data-2")//testng description
	@Description("Email ID")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Entering with invalid email ID")
	@Step("Click on the URL")
	@Severity(SeverityLevel.MINOR)
	public void verifyingWithEnteringInValidEmailIDData2_TC_MP_007() throws InterruptedException {
		mp.enterMobNoUn("dffdffsd@ga.cdaafdfdfaddaddadadffdasdsdfsdf");
		boolean enabledotp = mp.clickonSendOTP();
		Assert.assertEquals(enabledotp, false);
		if (enabledotp==true) {
		boolean clickable = mp.clickableOTP();
		Assert.assertEquals(clickable, false);}else{
			System.out.println("The test is Passed");
		}
	}
	@Test(priority = 8,description = "Verifying Login with valid email id Test data")//testng description
	@Description("Email ID")
	@Epic("Login")
	@Feature("Login Functionality")
	@Story("Entering with valid email ID")
	@Step("Click on the URL")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyingWithEnteringValidMobNoandOTP() throws InterruptedException {
		mp.enterValidMobNoandValidOTP();
		
	}
	 
@AfterMethod
public void tearDownTest() {
	tearDown();
}
	
	
	

}
