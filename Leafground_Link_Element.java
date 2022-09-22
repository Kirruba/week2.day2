package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground_Link_Element {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Take me to dashboard
		driver.findElement(By.xpath("//a[text()='Go to Dashboard']")).click();
		String title1=driver.getTitle();
		if(title1.contains("Dashboard")) {
			System.out.println("Dashboard is confirmed");
		}else {
			System.out.println("Dashboard is not confirmed");
		}
		driver.navigate().back();
		
		//Find my destination
		System.out.println(driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href"));
		
		//Am I broken link?
		driver.findElement(By.linkText("Broken?")).click();
		String title2 = driver.getTitle();
		if(title2.contains("404")) {
			System.out.println("Broken");
		}else {
			System.out.println("Not Broken");
		}
		driver.navigate().back();
		
		//Duplicate Link
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[2]")).click();
		driver.navigate().back();
		
		//Count Links
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		System.out.println(findElements.size());
		
		//Count Layout Links
		driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
		List<WebElement> findElements1 = driver.findElements(By.tagName("a"));
		System.out.println(findElements1.size());

	}

}
