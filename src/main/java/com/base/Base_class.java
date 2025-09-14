package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import junit.framework.Assert;


abstract class Base_class {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	// launching browser
	protected static void Browserlaunch(String browsername) {

		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();

			} else if (browsername.equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();

			}
		} catch (Exception e) {
			Assert.fail("Error:Browser name is mismatch");
		}

		driver.manage().window().maximize();
	}
	// launching url

	protected static void Gettingurl(String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error:URL is mismatch");
		}

	}

	protected static void Navigatetourl(String url) {

		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("Error:Navigate to correct url");
		}
	}

	protected static void Navigationsmethods(String types) {

		try {
			if (types.equalsIgnoreCase("back")) {

				driver.navigate().back();
			} else if (types.equalsIgnoreCase("forward")) {

				driver.navigate().forward();
			} else if (types.equalsIgnoreCase("refresh")) {

				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("Error");
		}

	}

	protected static void inputvalue(WebElement element, String value) {

		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("Error:happened");
		}

	}

	protected static void inputvaluepass(WebElement elementone, String pass) {

		try {
			elementone.sendKeys(pass);
		} catch (Exception e) {
			Assert.fail("Error:occured");
		}

	}

	protected static void Checks(WebElement element) {

		try {
			boolean enable = element.isEnabled();
			System.out.println("the element is enabled" + enable);

			boolean display = element.isDisplayed();
			System.out.println("the element is diaplayed " + display);

			boolean select = element.isSelected();
			System.out.println("The element is selected" + select);
		} catch (Exception e) {
			Assert.fail("Error");
		}

	}

	protected static void currenturl() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Curent url is:" + " " + currentUrl);
		} catch (Exception e) {
			Assert.fail("Error:");
		}

	}

	protected static void retrivetext(String Element) {

		try {
			String text = driver.findElement(By.linkText(Element)).getText();
			System.out.println("The text is" + text);
		} catch (Exception e) {
			Assert.fail("Error:Enter correct passo");
		}

	}

	protected static void Titleretrive() {

		try {
			String title = driver.getTitle();
			System.out.println("The title of the page is:" + title);
		} catch (Exception e) {
			Assert.fail("Error:Fetch correctly");
		}
	}

	protected static void Attributeget() {

		try {
			String attribute = driver.findElement(By.id("email")).getAttribute("id");
			System.out.println("The attribute is" + attribute);
		} catch (Exception e) {
			Assert.fail("Error: get correct attrbute");
		}
	}

	protected static void getDropdownOptionsById(String elementId) {
		WebElement dropdown = driver.findElement(By.id(elementId));
		Select select = new Select(dropdown);
		boolean multiple = select.isMultiple();
		// WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println(multiple);

		List<WebElement> options = select.getOptions();

		System.out.println("Dropdown options are:");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

	}

	protected static void terminate() {

		driver.quit();
	}

	protected static void closewindow() {

		driver.close();
	}

	protected static void Acttionsmethod(String Visibletext) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for element with matching visible text
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[normalize-space(text())='" + Visibletext + "']")));

		// Scroll into view (sometimes hover fails otherwise)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

//			
		Actions action = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath(Visibletext));
		action.moveToElement(element1).perform();
		// action.click(element1);

	}

	protected static void ElementClick(WebElement element) {

		try {
			element.click();
		} catch (Exception e) {

			Assert.fail("Error:");
		}

	}

	protected static void getelement(WebElement element, String type, String value) {

		Select select = new Select(element);
		if (type.equalsIgnoreCase("index")) {

			int num = Integer.parseInt(value);
			select.selectByIndex(num);

		} else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);

		} else if (type.equalsIgnoreCase("text")) {

			select.selectByVisibleText(value);
		}

	}

	protected static void holdimplicit(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}

	protected static void staywait(int sec) {

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static void validation(WebElement actual, String expected) {

		Assert.assertEquals(actual.getText(), expected);
		System.out.println(actual.getText());
	}

	public static void extentReportStart(String location) {

		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	public static void extentReportTearDown(String location) throws IOException {

		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date(0));
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File(
				"C:\\Users\\saikr\\eclipse-workspace\\NaukriNew\\Screenshort\\.png" + "_" + timestamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();

	}

	public static void clearData(WebElement element) {
		element.clear();
	}

	public static void backspace() {
		try {
			Robot rbt = new Robot();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_A);
			rbt.keyPress(KeyEvent.VK_DELETE);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectNoticePeriod(String dataId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click dropdown
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dp_noticePeriod")));
		dropdown.click();

		// Build dependent xpath with dataId
		String optionXpath = String.format("//div[@id='dp_noticePeriod']//a[@data-id='%s']", dataId);

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public WebElement waitForVisibility(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickWhenReady(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void down() {
		try {
			Robot rbt = new Robot();
			staywait(3000);
			rbt.keyPress(KeyEvent.VK_DOWN);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enter() {

		Robot rbt;
		try {
			rbt = new Robot();
			staywait(8000);
			
			rbt.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setImplicitWait(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}

}
