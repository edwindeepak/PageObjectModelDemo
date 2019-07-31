package com.demoauto.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoauto.qa.base.TestBase;

public class Alertspage extends TestBase {
	//Page Factory or Object Repository
	
	@FindBy(xpath="//img[@src='original.png']")
	WebElement alertpglogo;
	
	@FindBy(xpath="//a[@href='#CancelTab']")
	WebElement okcancelaltlink;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement altboxdisplaylink;
	
	//Initialization
	
	public Alertspage()  {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String validatealertpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validatealertpagelogo() {
		return alertpglogo.isDisplayed();
	}
	
	public String validatealerttext() {
		okcancelaltlink.click();
		altboxdisplaylink.click();
		Alert a=driver.switchTo().alert();
		String alettext=a.getText();
		return alettext;
		}
	
	
	
	
}
