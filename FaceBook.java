package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Download and set the path
		WebDriverManager.chromedriver().setup();

		// Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Maximize the window
		driver.manage().window().maximize();

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Create New Account button
		driver.findElement(
				By.xpath("//button[@name='login']//following::a[@data-testid='open-registration-form-button']"))
				.click();

		// Enter the first name
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='firstname']"))
				.sendKeys("Kirruba");

		// Enter the last name
		driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@name='lastname']")).sendKeys("Lakshmi");

		// Enter the emailId
		driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@name='reg_email__']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@name='reg_email_confirmation__']"))
				.sendKeys("abc@gmail.com");

		// Enter the password
		driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@ id='password_step_input']"))
				.sendKeys("SeleniumAutomation@#030922");

		// Handle all the three drop downs for Birthday
		WebElement eachOption = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dd = new Select(eachOption);
		dd.selectByValue("26");

		WebElement findElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select mm = new Select(findElement);
		mm.selectByVisibleText("Mar");

		WebElement findElement2 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yy = new Select(findElement2);
		yy.selectByValue("1996");

		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
