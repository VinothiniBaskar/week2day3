package elements.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch URL "https://leafground.com/radio.xhtml"
		driver.navigate().to("https://leafground.com/link.xhtml");

		// Maximize the browser
		driver.manage().window().maximize();

		// Give the implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// click the link
		WebElement homePage = driver.findElement(By.xpath("//div[@class='grid formgrid']//a[1]"));
		homePage.click();
		// back to the page
		driver.navigate().back();

		// To find which page is there without clicking the link
		WebElement withoutClick = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']"));
		// Passing the attribute value
		String title = withoutClick.getAttribute("href");
		// print the title
		System.out.println("This link is going to :" + title);

		Thread.sleep(1000);
		// click the link
		WebElement brokeLink = driver.findElement(By.xpath("//a[text()='Broken?']"));
		brokeLink.click();
		// get title
		String title1 = driver.getTitle();
		// Verify if the link is broken
		if (title1.contains("Error 404"))
			;
		{
			System.out.println("link broken");
		}

		driver.navigate().back();

		// duplicate link
		// if we give same homePage.click it give me stale element exception
		WebElement homePage1 = driver.findElement(By.xpath("//div[@class='grid formgrid']//a[1]"));
		homePage1.click();
		driver.navigate().back();

		// Get the number of links
		List<WebElement> countOfLinks = driver.findElements(By.tagName("a"));
		int size = countOfLinks.size();
		System.out.println("The number of Links in the page :" + size);

		// Get the number of links in layout
		driver.findElement(By.linkText("How many links in this layout?")).click();
		List<WebElement> total = driver.findElements(By.tagName("a"));
		int link2 = total.size();
		System.out.println("How many links in this layout :" + "" + link2);
		driver.navigate().back();

	}
}
