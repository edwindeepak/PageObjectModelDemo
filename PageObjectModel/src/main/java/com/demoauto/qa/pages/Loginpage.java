package com.demoauto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoauto.qa.base.TestBase;

public class Loginpage extends TestBase {
	//Page Factory or Object Repository
	
	@FindBy(id="email")
	WebElement emailid;
	
	@FindBy(id="enterimg")
	WebElement signupbtn;
	
	@FindBy(xpath="//button[@id='btn1']")
	WebElement signinbtn;
	
	@FindBy(id="btn2")
	WebElement skipsigninbtn;
	
	@FindBy(id="logo")
	WebElement logo;
	
	//initializing page objects
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		return logo.isDisplayed();
	}
	
	public boolean signinbutton() {
		return signinbtn.isDisplayed();
	}
	
	public boolean skipsigninbutton() {
		return skipsigninbtn.isDisplayed();
	}
	
	public Registerpage enter(String eid) {
		emailid.sendKeys(eid);
		signupbtn.click();
		return new Registerpage();
	}
	
	
}
