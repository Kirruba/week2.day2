package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_TextBox_Element {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Type your name
		driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("Kirruba");

		// Append Country to this City
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).sendKeys(" India");

		// Verify if text box is disabled
		boolean isDisabled = true;
		boolean enabled = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']")).isEnabled();
		if (enabled != isDisabled) {
			System.out.println("Text Box is Disabled");
		} else {
			System.out.println("Text Box is Enabled");
		}

		// Clear the typed text
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).clear();

		// Retrieve the typed text
		String attribute = driver.findElement(By.xpath("//input[@name='j_idt88:j_idt97']")).getAttribute("value");
		System.out.println("The Retrieved text is: " + attribute);

		// Type email and Tab. Confirm control moved to next element
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("Hi", Keys.TAB);

		// Type about yourself
		driver.findElement(By.id("j_idt88:j_idt101"))
				.sendKeys("I am Kirruba having 1 yr & 8 months of Experience with TCS.");

		// Text Editor
		driver.findElement(By.xpath("//div[@id='j_idt88:j_idt103_editor']/div"))
				.sendKeys("Selenium Learning in Progress.");

		// Just Press Enter and confirm error message
		Thread.sleep(5000);
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);

		String text = driver.findElement(By.xpath("//span[@id='j_idt106:thisform:j_idt110_error-detail']")).getText();
		if (text.equals("Age is mandatory")) {
			System.out.println("Error message is Confirmed");
		} else {
			System.out.println("Error message is not Confirmed");
		}

		// Click and Confirm Label Position Changes
		Thread.sleep(5000);
		WebElement findElement2 = driver.findElement(By.xpath("//label[text()='Username']"));
		Point location1 = findElement2.getLocation();
		// System.out.println(location1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
		Thread.sleep(5000);

		// h5[text()='Click and Confirm Label Position Changes']/following::input)[1]

		Point location2 = findElement2.getLocation();
		// System.out.println(location1);

		if (location1 != location2) {
			System.out.println("Label position is moved");
		} else {
			System.out.println("Label position is not moved");
		}

		// Type your name and choose the third option
		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Kirruba");
		driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//li[text()=3]")).click();

		// Type your DOB (mm/dd/yyyy) and confirm date chosen
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys("3/26/1996");

		// Type number and spin to confirm value changed
		Thread.sleep(5000);
		String text1 = "1";
		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys(text1);
		System.out.println("Given spin value is:" + text1);

		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/a"));
		findElement.click();
		findElement.click();

		String text2 = driver.findElement(By.id("j_idt106:j_idt118_input")).getAttribute("aria-valuenow");
		System.out.println("Changed Spin value after 2 spin's is:" + text2);
		if (text1 != text2) {
			System.out.println("Value after spin is changed successfully");
		} else {
			System.out.println("Value after spin is not changed");
		}

		// Type random number (1-100) and confirm slider moves correctly
		Thread.sleep(5000);
		WebElement findElement3 = driver
				.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Point location3 = findElement3.getLocation();

		driver.findElement(By.xpath("//input[@id='j_idt106:slider']")).sendKeys("50");

		Point location4 = findElement3.getLocation();

		if (location3 != location4) {
			System.out.println("Slider has moved correctly");
		} else {
			System.out.println("Slider is not moved correctly");
		}

		// Click and Confirm Keyboard appears
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).click();
		boolean displayed = driver.findElement(By.xpath(
				"//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']"))
				.isDisplayed();
		if (displayed == true) {
			System.out.println("Keyboard appeared successfully");
		} else {
			System.out.println("Keyboard appeared not successfully");
		}

		// Custom Toolbar
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_editor']/div[@class='ql-editor ql-blank']"))
				.sendKeys("Hi");

	}

}
