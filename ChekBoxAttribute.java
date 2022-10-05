package elements.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChekBoxAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch URL "https://leafground.com/checkbox.xhtml"
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();

		// Give the implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// check the basic check box selected or not
		Boolean checkbox = driver.findElement(By.xpath("//span[text()='Basic']")).isSelected();
		System.out.println("The Given checkbox is :" + checkbox);

		// Check the notification check box
		WebElement check = driver.findElement(By.xpath("//span[text()='Ajax']"));
		check.click();
		boolean value = check.isEnabled();
		System.out.println("The Given checkbox is :" + value);

		// check the favorite language checkboxs
		WebElement check1 = driver.findElement(By.xpath("//label[text()='Java']"));
		check1.click();
		boolean value1 = check1.isEnabled();
		System.out.println("The Given checkbox is :" + value1);

		WebElement check2 = driver.findElement(By.xpath("//label[text()='Python']"));
		check2.click();
		boolean value2 = check2.isEnabled();
		System.out.println("The Given checkbox is :" + value2);

		// check the Tri State Checkbox
		WebElement check3 = driver.findElement(
				By.xpath("//div[@data-iconstates='[\"\",\"ui-icon ui-icon-check\",\"ui-icon ui-icon-closethick\"]']"));
		check3.click();
		boolean value3 = check2.isEnabled();
		System.out.println("The Given checkbox is :" + value3);

		// check the Toggle Switch
		System.out.println("The Given Toggle switch is :"+driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).isSelected());

		// check the check box is disabled
		boolean checkboxDisabled = driver.findElement(By.xpath("//span[@class='ui-chkbox-label ui-state-disabled']"))
				.isSelected();
		if (checkboxDisabled == false) {
			System.out.println("The checkbox is disabled");
		} else {
			System.out.println("The checkbox is enabled");
		}

		// Multiple select checkbox
		driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-multiple')]")).click();

		WebElement w = driver
				.findElement(By.xpath("//div[@id='j_idt87:multiple_panel']/div[2]/ul[1]/li[1]/div[1]/div[2]"));
		w.click();
		WebElement w1 = driver
				.findElement(By.xpath("//div[@id='j_idt87:multiple_panel']/div[2]/ul[1]/li[2]/div[1]/div[2]"));
		w1.click();
		WebElement w2 = driver
				.findElement(By.xpath("//div[@id='j_idt87:multiple_panel']/div[2]/ul[1]/li[3]/div[1]/div[2]"));
		w2.click();

	}

}
