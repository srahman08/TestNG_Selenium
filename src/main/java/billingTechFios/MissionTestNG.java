package billingTechFios;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MissionTestNG {
	WebDriver driver;
	String browser = "Edge";
	
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
		
	}else if(browser.equalsIgnoreCase("Edge")){
		System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		
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
	//log in data
	String userid = "demo@techfios.com";
	String pword = "abc123";
	
	USERNAME.clear();
	USERNAME.sendKeys(userid);
	PASSWORD.clear();
	PASSWORD.sendKeys(pword);
	SUBMIT.click();
	
	Thread.sleep(2000);
	WebElement DASHBOARDELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
	String realdashboardElement = DASHBOARDELEMENT.getText();
	Assert.assertEquals(realdashboardElement, "Dashboard","Wrong Answer" );
	Thread.sleep(1000);
	
	//WebDriverWait wait = new WebDriverWait(driver, 4);
		
	WebElement CUSTOMERTAB = driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
	WebElement ADDCUSTOMERTAB = driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/add/']"));
	
	Random rnd = new Random();
	int generateNumber = rnd.nextInt(999);
	CUSTOMERTAB.click();
	ADDCUSTOMERTAB.click();
	Thread.sleep(1000);
	By ACCOUNTNAME = By.xpath("//input[@id='account']");
	By EMAILADDRESS = By.xpath("//input[@id='email']");
	By PHONENUMBER = By.xpath("//input[@id='phone']");
	
	driver.findElement(ACCOUNTNAME).sendKeys("SHAMIM"+ generateNumber);
	driver.findElement(PHONENUMBER).sendKeys("347-592-5"+ generateNumber);
	driver.findElement(EMAILADDRESS).sendKeys(generateNumber+"shamim@shamim.com");
	Waittime(driver, 2, ACCOUNTNAME);
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//select[@id='cid']"))).build().perform();
	driver.findElement(By.xpath("//option[contains(text(),'Techfios')]")).click();
		
	}

	private void Waittime(WebDriver driver, int timeInSec, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
		
	}
	
	
	
	
	/*  @Test 
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
	*/

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
	
	