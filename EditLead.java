package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL(http://leaftaps.com/opentaps/control/main)
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// Add Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the username
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoSalesManager");

		// Enter the password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");

		// Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter first name
		driver.findElement(By.xpath("//div[@class='x-tab-panel-body x-tab-panel-body-top']//input[@name='firstName']"))
				.sendKeys("Kirruba Lakshmi");

		// Click Find leads button
		driver.findElement(By.xpath("//div[@class='x-panel-footer x-panel-footer-noborder']//button")).click();

		// Click on first resulting lead
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// Verify title of the page
		String oldtitle = driver.getTitle();
		String newtitle = "View Lead | opentaps CRM";

		if (oldtitle.equalsIgnoreCase(newtitle)) {
			System.out.println("The title is verified successfully");
		} else {
			System.out.println("The title is not verified successfully");
		}

		// Click Edit
		driver.findElement(By.linkText("Edit")).click();

		// Change the company name
		WebElement findElement = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		findElement.clear();
		findElement.sendKeys("TCS");

		// Click Update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		// Confirm the changed name appears
		String changeName = driver.findElement(By.xpath("//span[contains(text(),'TCS')]")).getText();

		String[] split = changeName.split(" ");

		if (split[0].equalsIgnoreCase("TCS"))

		{
			System.out.println("Company Name is verified successfully");
		} else {
			System.out.println("Company Name is not updated successfully");
		}

		// Close the browser (Do not log out)
		driver.close();
	}

}
