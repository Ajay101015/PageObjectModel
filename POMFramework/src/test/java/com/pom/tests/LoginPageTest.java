package com.pom.tests;

import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;
import com.pom.testbase.TestBase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
  public LoginPageTest() {
	  super();
  }
  
  @BeforeMethod
  public void setUp() {
	  Intialization();
	  loginpage=new LoginPage();
	  homepage= new HomePage();
  }
  
  @Test(priority=1)
  public void verifyTitleTest() {
	  String title=loginpage.verifyTitle();
	  Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
  }
  
  @Test(priority=2)
  public void verifyImageTest() {
	  boolean flag=loginpage.verifyImage();
	  Assert.assertTrue(flag);
  }
  @Test(priority=3)
  public void loginTest() {
	 homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
