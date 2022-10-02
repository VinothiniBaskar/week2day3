package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputAttribute {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Launch URL "https://leafground.com/input.xhtml"
		driver.get("https://leafground.com/input.xhtml");

		// Give the implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the name by using XPath
		driver.findElement(By.xpath("//div[@class='grid formgrid']//input")).sendKeys("Vinothini Baskaran");

		// clear the existing text by using clear method and enter the city name
		driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).sendKeys("Trichy");

		// verify the filed is enabled or not
		System.out.println(driver.findElement(By.id("j_idt88:j_idt93")).isEnabled());

		// Clear the text by using clear method
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();

		// Get the text by using getAttribute method
		String text = driver.findElement(By.xpath("//input[@value='My learning is superb so far.']"))
				.getAttribute("value");
		System.out.println("The Retrieved Text is :" + text);

		// Enter the email id by using XPath
		driver.findElement(By.xpath("//input[@placeholder='Your email and tab']")).sendKeys("vinothini9198@gmail.com",
				Keys.TAB);

		// Enter the text by using XPath
		driver.findElement(By.xpath("//div[@class='col-12']//textarea"))
				.sendKeys("I am vinothini,currenly doing selenium webdriver testing course");

		// Enter the text by using XPath
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']//p")).sendKeys("Its a text Editor");

		// verify the error message
		driver.findElement(By.xpath("//div[contains(@class,'col-12 mb-2')]//input[1]")).sendKeys("", Keys.ENTER);
		String str = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		if (str.contains("Age is mandatory")) {
			System.out.println("I confirm the error message");

		} else {
			System.out.println("error message not found");

		}

		// Get the location of the element by using getLocation method
		System.out.println("The Location of the element is :"
				+ driver.findElement(By.xpath("//span[@class='ui-float-label']//input")).getLocation());
	}
}
