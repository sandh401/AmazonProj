package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class ShoppingCartTest  extends BaseAmazonClass{
	
	
	PomLogin Cart;
	public ShoppingCartTest(){
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void initsetup() throws Exception {
		initiation();
		Cart = new PomLogin();
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
		   Cart.typeemail(email);
		 //  Thread.sleep(3000); 
		   Cart.clickbtn1(); 
	     //  Thread.sleep(3000); 
		   Cart.typepassword(password);
	      // Thread.sleep(3000); 
		   Cart.clickbtn2();
	  
		   
		   WebElement searchBox=driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
	        searchBox.sendKeys("teddy bear");
	        WebElement searchButton=driver.findElement(By.cssSelector((".nav-search-submit")));
	        searchButton.click();
	        
	      //  WebElement searchButton=driver.findElement(By.cssSelector(("")));
	       // searchButton.click();
	   
	       driver.findElement(By.linkText(("Baby Girl Elephant"))).click();
	       driver.findElement(By.id(("add-to-cart-button"))).click();
	       
	     //  driver.findElement(By.linkText(("Baby Girl Elephant"))).click();
	     //  driver.findElement(By.id(("add-to-cart-button"))).click();
	       
		    WebElement searchBox1=driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
	        searchBox.sendKeys("makeup sponge");
	        WebElement searchButton1=driver.findElement(By.cssSelector((".nav-search-submit")));
	        searchButton.click();
	        driver.findElement(By.linkText(("Makeup Powder Puffs, 6 Pcs Triangle Cotton Powder Puff Loose Powder Puff…"))).click();
	        driver.findElement(By.id(("add-to-cart-button"))).click();
	       
	       Thread.sleep(5000);
	    
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
