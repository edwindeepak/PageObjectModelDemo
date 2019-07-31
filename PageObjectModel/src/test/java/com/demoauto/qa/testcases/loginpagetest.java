package com.demoauto.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demoauto.qa.base.TestBase;
import com.demoauto.qa.pages.Loginpage;
import com.demoauto.qa.pages.Registerpage;

public class loginpagetest extends TestBase {
	Loginpage  loginpage;
	Registerpage registerpage;
	
	
	public loginpagetest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new Loginpage();
	}
	
	@Test(priority = 1)
	public void loginpagetitletest() {
		String title  = loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Index");
	}
	
	@Test(priority = 2)
	public void logotest() {
		boolean flag=loginpage.validatelogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void signinbuttontest() {
		boolean flag = loginpage.signinbutton();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void skipsigninbuttontest() {
		boolean flag=loginpage.skipsigninbutton();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 5)
	public void entertest() {
		registerpage = loginpage.enter(prop.getProperty("emailid"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
