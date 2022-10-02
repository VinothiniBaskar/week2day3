package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonAttribute {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Launch URL "https://leafground.com/button.xhtml"
		driver.get("https://leafground.com/button.xhtml");

		// Give the implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Get the title of the page after click
		// driver.findElement(By.xpath("//span[text()='Click']")).click();
		System.out.println("The titile of the page is :" + driver.getTitle());

		// Verify if the button is enabled or not
		System.out.println(
				"The button  given button is not Enabled:" + driver.findElement(By.id("j_idt88:j_idt92")).isEnabled());

		// Get the location of the element by using getLocation method
		System.out.println("The Position of the element is :"
				+ driver.findElement(By.xpath("//div[@class='card']//span[2]")).getLocation());

		// Get the color of the element by using getCssValue method
		System.out.println("The color of the element is :"
				+ driver.findElement(By.xpath("(//div[@class='card'])[2]/following::span[text()='Save']"))
						.getCssValue("color"));

		// Get the height and width of the element by using getHeight and getWidth
		// method
		System.out.println("The Height of the element is :"
				+ driver.findElement(By.xpath("(//button[@id='j_idt88:j_idt98']//span)[2]")).getSize().getHeight());

		System.out.println("The width of the element is :"
				+ driver.findElement(By.xpath("(//button[@id='j_idt88:j_idt98']//span)[2]")).getSize().getWidth());

	}

}
