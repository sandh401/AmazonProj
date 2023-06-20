package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class SortingTest extends BaseAmazonClass{

		PomLogin Log;
		public SortingTest(){
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
		
		/*
		 * @Test public void Title() { String actual = Log.verify(); try {
		 * Thread.sleep(5000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } Assert.assertEquals(actual,
		 * "Amazon Sign In");
		 * 
		 * }
		 */
		
		
		  @DataProvider 
		  public Object[][] details(){ 
			  
			  Object result[][]=ExcelSheet.readdata("Sheet1"); 
			  return result; 
			  }
		  
		  @Test(priority=1, dataProvider="details") 
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
		  
		       WebElement searchBox=driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
		        searchBox.sendKeys("teddy bear");
		        WebElement searchButton=driver.findElement(By.cssSelector((".nav-search-submit")));
		        searchButton.click();
		        
		        //dropdown
		        Select sort = new Select(driver.findElement(By.id("s-result-sort-select")));
		        sort.selectByVisibleText("Newest arrivals");
		    
			  } catch(NoSuchElementException e) {
		
				 // e.printStackTrace();
				  
				  System.out.println("");
				  
			  }
			  
			  Thread.sleep(5000);
		  }
		 
			/*
			 * @Test(priority=2)
			 * 
			 * public void Account(){
			 * 
			 * //Actions - used for mouse movement Actions a = new Actions(driver);
			 * a.moveToElement(driver.findElement(By.linkText("Hello, sign in"))).build().
			 * perform(); driver.findElement(By.partialLinkText("Your Orders")).click();
			 * 
			 * }
			 */
			
			  @AfterMethod 
			  public void close() { 
				  driver.close();
				  
			  }
			 

}
