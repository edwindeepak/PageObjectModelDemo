package com.demoauto.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demoauto.qa.utils.Testutils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
		public TestBase() {
			prop = new Properties();
			FileInputStream ip;
			try {
				ip = new FileInputStream("C:\\Users\\Edwin\\eclipse-workspace\\"
						+ "PageObjectModel\\src\\main\\java\\com\\demoauto\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				}
		
		
		public static void initialization() {
						
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edwin\\Desktop\\New folder\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Testutils.pageloadtimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutils.implicitwait, TimeUnit.SECONDS);
			driver.get("http://demo.automationtesting.in/Index.html");;
		}
		

}
