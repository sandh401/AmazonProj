package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class PomSignIn extends BaseAmazonClass {
	
	
	//create object repository
	
	  @FindBy(css="#createAccountSubmit")
	  WebElement CreateAccbtn;
	  
	  @FindBy(id="ap_customer_name")
	  WebElement Name;
	 
	  @FindBy(xpath="//*[@id=\"ap_email\"]")
	  WebElement Email;
	 

	  @FindBy(id="ap_password")
	  WebElement Password;
	  

	  @FindBy(id="ap_password_check")
	  WebElement PasswordAgain;
	  
	  @FindBy(id="continue")
	  WebElement contibtn;
	 	
	 
	 	
	//initiate page elements         
	
	public void PomSignIn() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public void clickbtn1() {
		CreateAccbtn.click();
	}
	
	
	public void typename(String name) {
		Name.sendKeys(name);
	}
	
	public void typeemails(String emails) {
		Email.sendKeys(emails);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void typepasswordagain(String pass) {
		 PasswordAgain.sendKeys(pass);
	}
	
	public void clickbtn2() {
		contibtn.click();
	}


	public String verify() {
		return driver.getTitle();
	}
	

}
