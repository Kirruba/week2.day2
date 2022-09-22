package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Select_Element {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().window().maximize();

		// Add Implicit waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Which is your favorite UI Automation tool?
		WebElement findElement = driver.findElement(By.className("ui-selectonemenu"));
		Select dd = new Select(findElement);
		dd.selectByVisibleText("Selenium");

		// Choose your preferred country
		WebElement findElement1 = driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
		findElement1.click();
		driver.findElement(By.xpath("//li[text()='India']")).click();

		// Confirm Cities belongs to Country is loaded
		Thread.sleep(5000);
		WebElement findElement2 = driver.findElement(By.xpath("//label[@id='j_idt87:city_label']"));
		findElement2.click();
		WebElement city = driver.findElement(By.xpath("//li[@id='j_idt87:city_2']"));
		String text1 = city.getText();
		System.out.println(text1);
		city.click();

		// Change the Country & check if City is changed
		Thread.sleep(5000);
		findElement1.click();
		driver.findElement(By.xpath("//li[text()='Germany']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		WebElement city1 = driver.findElement(By.xpath("//li[@id='j_idt87:city_1']"));
		String text2 = city1.getText();
		System.out.println(text2);
		city1.click();

		// Choose the Course
		driver.findElement(
				By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']/parent::button"))
				.click();
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//li[text()='Playwright']"));
		driver.executeScript("arguments[0].click();", findElement3);
		WebElement findElement4 = driver.findElement(By.xpath("//li[text()='PostMan']"));
		driver.executeScript("arguments[0].click();", findElement4);

		// Choose language randomly
		driver.findElement(By.xpath("//div[@id='j_idt87:lang']")).click();
		driver.findElement(By.xpath("//li[text()='Tamil']")).click();

		// Select 'Two' irrespective of the language chosen
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='j_idt87:value']")).click();
		driver.findElement(By.xpath("//li[text()='இரண்டு']")).click();

	}

}
