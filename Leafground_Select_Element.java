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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Which is your favorite UI Automation tool?
		WebElement findElement = driver.findElement(By.className("ui-selectonemenu"));
		Select dd = new Select(findElement);
		dd.selectByVisibleText("Selenium");

		// Choose your preferred country
		driver.findElement(By.xpath("//div[@id='j_idt87:country']")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:country_items']/li[text()='India']")).click();

		// Confirm Cities belongs to Country is loaded
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='j_idt87:city']")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:city_items']/li[text()='Chennai']")).click();

		// Choose the Course
		driver.findElement(
				By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']/parent::button"))
				.click();
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		WebElement findElement1 = driver.findElement(By.xpath("//li[text()='Playwright']"));
		driver.executeScript("arguments[0].click();", findElement1);
		WebElement findElement2 = driver.findElement(By.xpath("//li[text()='PostMan']"));
		driver.executeScript("arguments[0].click();", findElement2);

		// Choose language randomly
		driver.findElement(By.xpath("//div[@id='j_idt87:lang']")).click();
		driver.findElement(By.xpath("//li[text()='Tamil']")).click();

		// Select 'Two' irrespective of the language chosen
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='j_idt87:value']")).click();
		driver.findElement(By.xpath("//li[text()='இரண்டு']")).click();

	}

}
