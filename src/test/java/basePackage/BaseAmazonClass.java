package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseAmazonClass {
	
	//browser info WebDriver driver = new ChromeDriver();
		//url info
		//username and password
		
		public static Properties pro = new Properties();
		public static WebDriver driver;
		
		//step1
		public BaseAmazonClass(){
			
			try {
				
			FileInputStream file = new FileInputStream("C:\\Navjot\\AmazonProj\\src\\test\\java\\environmentvariables\\Config.properties");
			pro.load(file);
			
			
			}
			
			catch(FileNotFoundException e){
				e.printStackTrace();
				
			}
			
			catch(IOException a) {
				a.printStackTrace();
			}

		}
			//step 2
			@SuppressWarnings("deprecation")
			public static void initiation() throws Exception {
				
				String browsername = pro.getProperty("browser");
				if (browsername.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
					driver = new FirefoxDriver();
				} else if (browsername.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					//options.addArguments("--remote-allow-origins=*");
					driver = new ChromeDriver(options);
				}
				
				
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			        driver.get(pro.getProperty("url"));
		}

}
