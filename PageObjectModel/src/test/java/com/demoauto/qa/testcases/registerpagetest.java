package com.demoauto.qa.testcases;

import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.demoauto.qa.base.TestBase;
import com.demoauto.qa.pages.Alertspage;
import com.demoauto.qa.pages.Loginpage;
import com.demoauto.qa.pages.Registerpage;
import com.demoauto.qa.utils.Testutils;

public class registerpagetest extends TestBase {

	Loginpage  loginpage;
	Registerpage registerpage;
	Alertspage alertspage;
	String sheetname="formdetails";
	
	public registerpagetest() {
		super();
	}
	@DataProvider
	public Object[][] getformdata() throws InvalidFormatException{
		Object data[][]= Testutils.getTestData(sheetname);
		return data;
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new Loginpage();
		registerpage=loginpage.enter(prop.getProperty("emailid"));
		}
	
	
	@Test(priority = 1,enabled = false)
	public void regpagetitletest() {
		String title  = registerpage.validateregpagetitle();
		Assert.assertEquals(title, "Register");
	}
	@Test(priority = 2,enabled = false)
	public void regpagelogotest() {
		boolean flag=registerpage.validateregpagelogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3, enabled = false)
	public void hmpglinktest() {
		loginpage = registerpage.homepagelink();
	}
	@Test(priority = 4, dataProvider="getformdata")
	public void formfilltest(String fname, String lname, String addr, String emailid, String phno, String skills, 
			String country, String year, String month, String day, String fpass) {
		
		registerpage.formfill(fname,  lname,  addr,  emailid,  phno,  skills, 
				 country,  year,  month,  day,  fpass);
		
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void switchtolinktest() {
		alertspage = registerpage.switchtolink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
