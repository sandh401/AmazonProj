package pompackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;


public class PomLogin extends BaseAmazonClass{
	
	//create object repository
	
	  @FindBy(id="ap_email")
	  WebElement Email;
	 
	  @FindBy(id="continue")
	  WebElement Continuebtn;
	
	  @FindBy(id="ap_password")
	  WebElement Password;
	  
	  @FindBy(id="signInSubmit")
	  WebElement SignInbtn;
	 	
	//initiate page elements
	
	public PomLogin() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void typeemail(String email) {
		Email.sendKeys(email);
	}
	
	public void clickbtn1() {
		Continuebtn.click();
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn2() {
		SignInbtn.click();
	}
	
	public String verify() {
		return driver.getTitle();
	}
	

}
