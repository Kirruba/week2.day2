package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Button_Element {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();

		// Click and Confirm title
		String oldTitle = driver.getTitle();
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String newTitle = driver.getTitle();

		if (oldTitle.equals(newTitle)) {
			System.out.println("Control stays");
		} else {
			System.out.println("Control has been moved successfully to " + newTitle);
		}

		// Navigate back to button page
		driver.navigate().back();

		// Confirm if the button is disabled
		boolean isDisabled = true;
		boolean enabled = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']")).isEnabled();
		if (enabled != isDisabled) {
			System.out.println("Text Box is Disabled");
		} else {
			System.out.println("Text Box is Enabled");
		}

		// Find the position of the Submit button
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Submit']"));
		Point location = findElement.getLocation();
		System.out.println("The position of the Submit button is:" + location);
//		int x=location.getX();
//		int y=location.getY();

		// Find the Save button color
		String color = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']")).getCssValue("color");
		System.out.println("Save Button color is: " + color);

		// Find the Save button background color
		String bcolor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']")).getCssValue("background-color");
		System.out.println("Save button Background color is: " + bcolor);

		// Find the height and width of Submit button
		Dimension size = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']/span[text()='Submit']"))
				.getSize();
		System.out.println("The Height of a button is: " + size.getHeight());
		System.out.println("The Width of a button is: " + size.getWidth());

		// Mouse over and confirm the color changed
		String cssValue = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"))
				.getCssValue("background-color");
		System.out.println("Color before Mouse over is: " + cssValue);

		WebElement findElement2 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement2).perform();
		String cssValue2 = findElement2.getCssValue("background-color");
		System.out.println("Color after Mouse over is: " + cssValue2);

		if (cssValue != cssValue2) {
			System.out.println("Color changed after Mouse Over");
		} else {
			System.out.println("Color not changed after Mouse Over");
		}

		// Click Image Button and Click on any hidden button
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		driver.findElement(By.xpath("//img[@id='j_idt88:j_idt102:j_idt104']")).click();

		// How many rounded buttons are there?
		List<WebElement> roundbutton = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		int size1 = roundbutton.size();
		System.out.println("Rounded buttons:" + size1);

	}

}
