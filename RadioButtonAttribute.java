package elements.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch URL "https://leafground.com/radio.xhtml"
		driver.get("https://leafground.com/radio.xhtml");

		// Maximize the browser
		driver.manage().window().maximize();

		// Give the implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// select the radio button
		WebElement browser = driver.findElement(By.xpath("//label[text()='Chrome']"));
		browser.click();
		System.out.println("i choose my favorite browser" + " " + browser.getText());

		// UnSelectable
		// Select the radio button
		driver.findElement(By.xpath("//label[text()='Bengaluru']")).click();

		// unselect the selected radio button
		WebElement unselect = driver.findElement(By.xpath("//label[text()='Bengaluru']"));
		unselect.click();
		boolean selected1 = unselect.isSelected();
		if (selected1) {
			System.out.println("radio button is selected");
		} else {
			System.out.println("radio button is unselected");
		}

		// Find the deafultBrowser
		WebElement deafultBrowser = driver.findElement(By.xpath("//label[text()='Safari']"));
		System.out.println("The Dafault browser is" + " " + deafultBrowser.getText());

		// Select the age group (only if not selected)
		WebElement r = driver.findElement(By.xpath("//label[text()='1-20 Years']"));
		r.click();
		Thread.sleep(1000);
		WebElement r1 = driver.findElement(By.xpath("//label[text()='41-60 Years']"));
		r1.click();

	}
}
