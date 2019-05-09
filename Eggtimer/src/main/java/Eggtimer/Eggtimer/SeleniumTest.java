package Eggtimer.Eggtimer;

import static org.testng.Assert.assertTrue;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import junit.framework.AssertionFailedError;

public class SeleniumTest {

	public static WebDriver driver;
	@Rule
	ErrorCollector collector = new ErrorCollector();

	public SeleniumTest() {
		String path = System.getProperty("user.dir") + "/src/Resources/Config.properties";
		String browserType = UtilityClass.ReadPropertiesFile(path, "browser");
		browserType = browserType.toLowerCase();
		if (browserType.contains("ie")) {
			// To be implemented, cant test because of unavailability of windows machine
		} else if (browserType.contains("firefox")) {
			System.setProperty("webdriver.ge.driver", System.getProperty("user.dir") + "/Dependency/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserType.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Dependency/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.out.println("Browser not supported");
		}
	}

	public void NavigateToURL(String arg) {
		String path = System.getProperty("user.dir") + "/src/Resources/Config.properties";
		String url = UtilityClass.ReadPropertiesFile(path, arg);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public WebElement findObject(String name) throws Exception {
		WebElement element = null;
		String path = System.getProperty("user.dir") + "/src/Resources/OR.properties";
		String retVal = UtilityClass.ReadPropertiesFile(path, name);
		String[] tempval = retVal.split("~");
		if (tempval[0].equalsIgnoreCase("id"))
			element = driver.findElement(By.id(tempval[1]));
		else if (tempval[0].equalsIgnoreCase("xpath"))
			element = driver.findElement(By.xpath(tempval[1]));
		return element;
	}

	public void EnterInTextBox(String obj, String content) throws Exception {
		this.findObject(obj).clear();
		this.findObject(obj).sendKeys(content);
	}

	public void Click(String obj) throws Exception {
		this.findObject(obj).click();
	}

	public void VerifyPageCounter() throws Exception {

		try {
			int y = getTime();
			int[] intArray = new int[y + 1];
			for (int i = 0; i < y; i++) {
				intArray[i] = getTime();
				// System.out.println("Element at index " + i +
				// " : "+ intArray[i]);
				Thread.sleep(1000);
			}
			String done = "";
			int z = y;
			for (int j = 0; j < y; j++) {
				System.out.println(intArray[j]);
				System.out.println(z);

				if (intArray[j] == z) {
					System.out.println("Timer Worked at -- " + intArray[j]);
					System.out.println("pass");
				} else {
					System.out.println("Timer failed  -- " + intArray[j]);
					System.out.println("fail");
					System.out.println(" ");
					Assert.fail("Timer failed at " + intArray[j]);
				}
				z = z - 1;

			}

			driver.switchTo().alert().dismiss();
			Assert.assertEquals("Time Expired!", this.findObject("counter").getText());
			// "Expired timeout checked");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail("Unable to get the TimeExpired Popup");
		}

	}

	public int getTime() throws Exception {

		String x = this.findObject("counter").getText();
		String[] parts = x.split(" ");
		String part1 = parts[0];
		int tim = Integer.parseInt(part1);
		String y = driver.getTitle();
		return tim;

	}

	public void QuitDriver() {
		driver.quit();
	}

}
