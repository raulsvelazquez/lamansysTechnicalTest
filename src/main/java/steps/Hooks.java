package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Hooks {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Actions action;

	@Before
	public static void iniciar() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 25);
		action = new Actions(driver);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "El escenario fallo, referirse a la imagen adjunta.");
		}
	}

	@After
	public static void cleanDriver() {
		closeBrowser();
	}

	private static ChromeOptions chromeOptions(){
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("ignore-certificate-errors");
		return chromeOptions;
	}

	public void navigateToUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	private WebElement find(String locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void clickElement(String locator) {
		find(locator).click();
	}

	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}

	public String textFromElement(String locator) {
		return find(locator).getText();
	}

	public boolean elementIsDisplayed(String locator) {
		return find(locator).isDisplayed();
	}
}