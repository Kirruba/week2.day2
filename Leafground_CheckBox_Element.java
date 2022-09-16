package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_CheckBox_Element {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Basic Checkbox
		driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();

		// Notificatin for Ajax checkbox (Checked)
		WebElement findElement2 = driver.findElement(By.xpath("//h5[text()='Notification']/following::span"));
		driver.executeScript("arguments[0].click();", findElement2);

		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println("Ajax Checkbox is " + text);

		// Notificatin for Ajax checkbox (Unchecked)
		findElement2.click();
		Thread.sleep(5000);
		String text4 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println("Ajax Checkbox is " + text4);

		// Choose your favorite languages
		driver.findElement(By.xpath("//div[@class='ui-chkbox ui-widget']")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget'])[2]")).click();

		// Tristate Checkbox
		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']"));
		driver.executeScript("arguments[0].click();", findElement);

		Thread.sleep(5000);
		System.out.println("Tri State Checkbox for tick");
		String text1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(text1);

		findElement.click();
		Thread.sleep(5000);
		System.out.println("Tri State Checkbox for cross");
		String text2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(text2);

		findElement.click();
		Thread.sleep(5000);
		System.out.println("Tri State Checkbox for Unchecked");
		String text3 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println(text3);

		// Notification for Toggle Switch (Checked)
		WebElement findElement3 = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
		findElement3.click();
		Thread.sleep(5000);
		String text6 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println("Toggle Switch is " + text6);

		// Notification for Toggle Switch (UnChecked)
		findElement3.click();
		Thread.sleep(5000);
		String text7 = driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText();
		System.out.println("Toggle Switch is " + text7);

		// Verify if check box is disabled
		boolean isDisabled = true;
		boolean enabled = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt102_input']")).isEnabled();
		if (enabled != isDisabled) {
			System.out.println("Check Box is Disabled");
		} else {
			System.out.println("Check Box is Enabled");
		}

		// Select Multiple Values
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();
	}

}
