package com.demoauto.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoauto.qa.base.TestBase;

public class Registerpage extends TestBase {
	//Page Factory or Object Repository
	
	@FindBy(xpath="//img//parent::a[@class='navbar-brand']")
	WebElement regpagetitlelogo;
	
	@FindBy(xpath="//a[@href='Index.html']")
	WebElement homepagelink;
	
	@FindBy(xpath="//a[@href='WebTable.html']")
	WebElement webtablelink;
	
	@FindBy(xpath="//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a")
	WebElement switchtolink;
	
	@FindBy(xpath="//a[@href='Alerts.html']")
	WebElement alertlink;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement fnamee;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lnamee;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	WebElement addre;
	
	@FindBy(xpath="//input[@type='email' and @ng-model='EmailAdress' ]")
	WebElement emaie;
	
	@FindBy(xpath="//input[@type='tel' and @ng-model='Phone' ]")
	WebElement phne;
	
	@FindBy(xpath="//input[@type='radio' and @value='Male']")
	WebElement rdbe;
	
	@FindBy(xpath="//input[@type='radio' and @value='Male']")
	WebElement ckbe;
	
	@FindBy(xpath="//input[@id='checkbox1' and @value='Cricket']")
	WebElement chbe;
	
	@FindBy(xpath="//div[@id='msdd']")
	WebElement lng1e;
	
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")
	WebElement lng2;
	
	@FindBy(id="Skills")
	WebElement skille;
	
	@FindBy(id="countries")
	WebElement countrye;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single']")
	WebElement seccon1e;
	
	@FindBy(xpath="//li[@class='select2-results__option' and text()='India']")
	WebElement seccon2e;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	WebElement monthe;
	
	@FindBy(id="daybox")
	WebElement daye;
	
	@FindBy(id="yearbox")
	WebElement yeare;
	
	@FindBy(id="firstpassword")
	WebElement fpasse;
	
	@FindBy(id="secondpassword")
	WebElement spasse;
	
	
	//initializing page objects
	
		public Registerpage()  {
			PageFactory.initElements(driver, this);
		}
		
	//actions	
		
		public String validateregpagetitle() {
			return driver.getTitle();
		}
		
		public boolean validateregpagelogo() {
			return regpagetitlelogo.isDisplayed();
		}
		
		public Loginpage homepagelink() {
			homepagelink.click();
			return new Loginpage();
		}
		
		public void formfill(String fname, String lname, String addr, String emailid, String phno, String skills, 
				String country, String year, String month, String day, String fpass) {
			fnamee.sendKeys(fname);
			lnamee.sendKeys(lname);
			addre.sendKeys(addr);
			emaie.sendKeys(emailid);
			phne.sendKeys(phno);
			rdbe.click();
			chbe.click();
			lng1e.click();
			//driver.manage().timeouts().implicitlyWait(Testutils.implicitwait, TimeUnit.SECONDS);
			lng2.click();
			Select skl= new Select(skille);
			skl.selectByVisibleText(skills);
			Select cont= new Select(countrye);
			cont.selectByVisibleText(country);
			seccon1e.click();
			seccon2e.click();
			Select yearsel=new Select(yeare);
			yearsel.selectByValue(year);
			Select monsel=new Select(monthe);
			monsel.selectByVisibleText(month);
			Select daysel=new Select(daye);
			daysel.selectByValue(day);
			fpasse.sendKeys(fpass);
			spasse.sendKeys(fpass);
			
			
		}
		
		public Alertspage switchtolink() {
			Actions a=new Actions(driver);
			a.moveToElement(switchtolink).build().perform();
			alertlink.click();
			return new Alertspage();
		}
	
	
}
