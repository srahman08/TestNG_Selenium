package billingTechFios;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WindowHandler {
WebDriver driver;
		@Test
		public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String windowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@class='_yb_1t044']")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@class='rapid-noclick-resp _yb_ljo01']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'XPath Tutorial - W3Schools')]")).click();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for(String i : windowHandles) {
		System.out.println(i);
		driver.switchTo().window(i);
		}
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		}
	
}
