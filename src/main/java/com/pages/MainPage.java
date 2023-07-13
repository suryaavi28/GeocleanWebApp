package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;

	By un = By.id("username");  //This is for Username
	By otp = By.xpath("//*[text() = 'Send OTP']");   //This is for OTP 
	By registrationvaldiation = By.xpath("//*[text()='You are not registered with us.']"); //This is for Validation of registration message
	By yourOTP = By.xpath("//*[contains(text(), 'Your OTP is:')]");
	By LoginBtn = By.xpath("//button[text()='Login']"); //This is for Login Button
	By otpenter = By.id("otp");//This is to entering OTP

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void yourOTPclick() {
	 String otpToEnter=	driver.findElement(yourOTP).getText();
	 System.out.println(otpToEnter);
	 String otp = otpToEnter.substring(13);
	 System.out.println(otp);
	 driver.findElement(otpenter).clear();
	 driver.findElement(otpenter).sendKeys(otp);
	
	}
	
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public void enterMobNoUn(String MobUn) {
		driver.findElement(un).clear();
		driver.findElement(un).sendKeys(MobUn);

	}

	public boolean clickonSendOTP() {
		driver.findElement(otp).isEnabled();
		return true;
	}

	public void clickOnValidOTP() {

		driver.findElement(otp).click();

	}

	public boolean validationMsgOnRegistration() {
		driver.findElement(registrationvaldiation).isDisplayed();
		return true;
	}

	public boolean clickableOTP() {
		driver.findElement(otp).isEnabled();
		return true;

	}

	public void enterUsername(String username) {
		WebElement uname = driver.findElement(un);
		uname.clear(); // Clear existing value (if any)
		uname.sendKeys(username);
	}

//	    public int getUsernameLength() {
//	        String usernameValue = driver.findElement(un).getAttribute("pattern");
//	        System.out.println(driver.findElement(un).getAttribute("pattern"));
//	       System.out.println( usernameValue.length());
//	        return usernameValue.length();
//	    }

	public String placeHolder() {
		String ph = driver.findElement(un).getAttribute("placeholder");
		System.out.println(ph);
		return ph;

	}
	
	public void clickOnLoginBtn() {
		driver.findElement(LoginBtn).click();
	}
	
	public DashBoardPage enterValidMobNoandValidOTP() throws InterruptedException {
		enterUsername("7990489641");
		Thread.sleep(4000);
		clickOnValidOTP();
		Thread.sleep(4000);
		yourOTPclick();
		Thread.sleep(4000);
		clickOnLoginBtn();
		Thread.sleep(4000);
		return new DashBoardPage(driver);
		
	}
	
	
    
}
