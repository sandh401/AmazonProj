package TestLayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseAmazonClass{

	PomLogin Log;
	public LoginTest(){
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void initsetup() throws Exception {
		initiation();
		Log = new PomLogin();
	 try {
		 Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test
	public void Title() {
		String actual = Log.verify();
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(actual, "Amazon Sign In");
		
	}
	
	
	  @DataProvider 
	  public Object[][] details(){ 
		  
		  Object result[][]=ExcelSheet.readdata("Sheet1"); 
		  return result; 
		  }
	  
	  @Test(dataProvider="details") 
	  public void Login(String email, String password) throws InterruptedException { 
		  
		  try {
	   
		 //  Thread.sleep(3000); 
		   Log.typeemail(email);
		 //  Thread.sleep(3000); 
	       Log.clickbtn1(); 
	     //  Thread.sleep(3000); 
	       Log.typepassword(password);
	      // Thread.sleep(3000); 
	       Log.clickbtn2();
	  
		  } catch(NoSuchElementException e) {
	
			 // e.printStackTrace();
			  
			  System.out.println("");
			  
		  }
		  
		  Thread.sleep(5000);
	  }
	 
		
	
		
		  @AfterMethod 
		  public void close() { 
			  driver.close();
			  
		  }
		 
	

}
