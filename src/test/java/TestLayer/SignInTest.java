package TestLayer;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomSignIn;
import testdata.ExcelSheet;

public class SignInTest extends BaseAmazonClass{
	
	PomSignIn Sign;
	
	
	public SignInTest(){
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void initsetup() throws Exception {
		initiation();
		Sign = new PomSignIn();
		
	 try {
		 Thread.sleep(1000);
		 Sign.clickbtn1();
			
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/*
	 * @Test(priority=1) public void Title() { String actual = Sign.verify(); try {
	 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } Assert.assertEquals(actual,
	 * "Amazon Registration");
	 * 
	 * }
	 */
	
	
	  @DataProvider 
	  public Object[][] details(){
	  
	  Object result[][]=ExcelSheet.readdata("Sheet2");
	  return result;
	  }
	  
	
	  @Test(priority=1, dataProvider="details") 
	  public void SignInTest1(String name, String emails, String password, String passwordAgain) throws InterruptedException { 
		  
		  try {
	   
		 //  Thread.sleep(3000); 
		   //Sign.clickbtn1(); 
		   Sign.typename(name);
		   Sign.typeemails(emails);
		 //  Thread.sleep(3000); 
	
	     //  Thread.sleep(3000); 
		   Sign.typepassword(password);
		   Sign.typepasswordagain(passwordAgain);
	      // Thread.sleep(3000); 
		   Sign.clickbtn2();
	  
		  } catch(NoSuchElementException e) {
	
			 // e.printStackTrace();
			  
			  System.out.println("");
			  
		  }
		  
		  Thread.sleep(1000);
	  }
	 
		
	
		/*
		 * @AfterMethod public void close() { driver.close();
		 * 
		 * }
		 */
		 

}
