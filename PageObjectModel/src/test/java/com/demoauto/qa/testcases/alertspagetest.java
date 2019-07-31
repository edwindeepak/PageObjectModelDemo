package com.demoauto.qa.testcases;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demoauto.qa.base.TestBase;
import com.demoauto.qa.pages.Alertspage;
import com.demoauto.qa.pages.Loginpage;
import com.demoauto.qa.pages.Registerpage;

public class alertspagetest extends TestBase {

	Loginpage  loginpage;
	Registerpage registerpage;
	Alertspage alertspage;
	
	public alertspagetest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new Loginpage();
		registerpage=loginpage.enter(prop.getProperty("emailid"));
		alertspage=registerpage.switchtolink();
	}
	
	@Test(priority = 1)
	public void altpagetitletest() {
		String title  = alertspage.validatealertpagetitle();
		Assert.assertEquals(title, "Alerts");
	}
	@Test(priority = 2)
	public void altpagelogotest() {
		boolean flag=alertspage.validatealertpagelogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void alttexttest() {
		String alttext=alertspage.validatealerttext();
		Assert.assertEquals(alttext, "Press a Button !", "alerttext");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
