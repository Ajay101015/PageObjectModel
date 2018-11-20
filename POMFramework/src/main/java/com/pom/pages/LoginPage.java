package com.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name ="username")
		WebElement username;
	
	
	@FindBy(name="password")
	      WebElement password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement Signupopt;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement FreeCrmimg;
	
	//initializing object
	public void loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyTitle() {
		return driver.getTitle();
	}
	public boolean verifyImage() {
		return FreeCrmimg.isDisplayed();
	}
	public HomePage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginbtn);
		    	
return new HomePage();
	}
		
}
