package com.pom.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pom.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()  {
		 try{
			 prop = new Properties();
		 FileInputStream ip=new FileInputStream("C:\\Users\\PatidaA\\eclipse-workspace\\POMFramework\\src\\main\\java\\com\\pom\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Intialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver","C:\\Users\\PatidaA\\eclipse-workspace\\POMFramework\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equals("FireFox"))
		{
		System.getProperty("webdriver.gecko.driver","C:\\Users\\PatidaA\\eclipse-workspace\\POMFramework\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.page_load_implicit_timout, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
}
}