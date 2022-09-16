package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Radio_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Your most favorite browser
		driver.findElement(By.xpath("//label[text()='Chrome']")).click();
		String text = driver.findElement(By.xpath("//label[text()='Chrome']")).getText();
		System.out.println("Your most favorite browser: " + text);

		// UnSelectable
		driver.findElement(By.xpath("//label[text()='Chennai']")).click();
		String text1 = driver.findElement(By.xpath("//label[text()='Chennai']")).getText();
		System.out.println("UnSelectable: " + text1);

		// Find the default select radio button
		driver.findElement(By.xpath("(//label[text()='Safari'])[2]")).isSelected();
		String text2 = driver.findElement(By.xpath("(//label[text()='Safari'])[2]")).getText();
		System.out.println("Default selected radio button: " + text2);

		// Select the age group (only if not selected)
		boolean selected = driver.findElement(By.xpath("//label[text()='1-20 Years']")).isSelected();
		System.out.println(selected);
		if (!selected) {
			driver.findElement(By.xpath("//label[text()='1-20 Years']")).click();
		}
		String text3 = driver.findElement(By.xpath("//label[text()='1-20 Years']")).getText();
		System.out.println("Age Group not selected is: " + text3);

	}

}
