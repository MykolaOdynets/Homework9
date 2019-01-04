package Lits.Homework9;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

	// private WebDriver driver;
	private WebDriver webDriver;
	private final String CHROME_NAME = "chrome";
	private final String FIREFOX_NAME = "firefox";

	@BeforeMethod
	@Parameters("browserName")
	public void setupBrowser(String browserName) {

		if (browserName.equals(CHROME_NAME)) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			webDriver = new ChromeDriver(options);
		} else if (browserName.equals(FIREFOX_NAME)) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", false);

			webDriver = new FirefoxDriver(firefoxOptions);
		} else
			throw new IllegalArgumentException("You have passed invalid browser name");

		webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
	}

	@Test
	public void litsNavigationLessonsTest() throws InterruptedException {

		webDriver.get("https://google.com/");

		webDriver.findElement(By.xpath("//A[@class='gb_P'][text()='Gmail']")).click();
		webDriver.findElement(By.xpath("//A[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		webDriver.findElement(By.xpath("//INPUT[@id='identifierId']")).sendKeys("odkolya@gmail.com");
		webDriver.findElement(By.xpath("//SPAN[@class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.name("password")).sendKeys("selenium12");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		Thread.sleep(2000);
		
		
		
		// SPAN[@class='RveJvd snByac']

	}
}
