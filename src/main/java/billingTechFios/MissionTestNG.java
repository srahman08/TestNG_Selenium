package billingTechFios;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;
public class MissionTestNG {
	WebDriver driver;
	String browser = "chrome";
	@BeforeClass
public void readConfig() {
		Properties prop = new Properties();
		//FileReader InputStream BuffeReader Scanner 
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("User Browser: " + browser);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	
	@BeforeMethod
	public void iniTial () throws InterruptedException {

if (browser == "chrome") {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
		
	}else if(browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
//		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.techfios.com/billing/?ng=admin/");
	}
	@Test
	public void loginTestA () throws InterruptedException	{
	WebElement USERNAME = driver.findElement(By.xpath("//input[@id='username']"));
	WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']")); 
	WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));  
	USERNAME.clear();
	USERNAME.sendKeys("demo@techfios.com");
	PASSWORD.clear();
	PASSWORD.sendKeys("abc123");
	SUBMIT.click();
	Thread.sleep(2000);
	WebElement DASHBOARDELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
	String realdashboardElement = DASHBOARDELEMENT.getText();
	Assert.assertEquals(realdashboardElement, "Dashboard","Wrong Answer" );
	Thread.sleep(1000);
	}
	  @Test 
	  public void loginTestB () throws InterruptedException	{
			WebElement USERNAME = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']")); 
			WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));  
			USERNAME.clear();
			USERNAME.sendKeys("demo@techfios.com");
			PASSWORD.clear();
			PASSWORD.sendKeys("abc123");
			SUBMIT.click();
			Thread.sleep(2000);
			
	  WebElement DASHBOARDELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")); String
	  realdashboardElement = DASHBOARDELEMENT.getText();
	  Assert.assertEquals(realdashboardElement, "Dashboard1","Wrong Answer");
	  }
	  
	  @AfterMethod
	public void tearDown() {
 	driver.quit();
	}	

}













	/*
	SIGNOFFMENU.click(); Thread.sleep(1000); LOGOUT.click(); Thread.sleep(2000);
	
	boolean pageTitleDisplayStatus;
	try 
	{
		WebElement dashboardTtile = driver.findElement(By.xpath("//h2[contains(text(),'Contacts1')]"));
		pageTitleDisplayStatus = true;
		
	} catch (Exception e) {
		pageTitleDisplayStatus = false;
		e.printStackTrace();
	}
	
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Welcome Techfios')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
	Thread.sleep(2000);
	}*/
	
	