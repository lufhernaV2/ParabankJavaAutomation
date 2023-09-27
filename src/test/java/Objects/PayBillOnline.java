package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PayBillOnline {
	
	WebDriver driver;
	
	public PayBillOnline(WebDriver driver) {
		this.driver = driver;
	}
	
	public void payOnlineBill() {
		// click on the 'Bill Pay' link
		driver.findElement(By.linkText("Bill Pay")).click();

		// fill out the payee information form
		driver.findElement(By.name("payee.name")).sendKeys("SpaceX Tesla");
		driver.findElement(By.name("payee.address.street")).sendKeys("332 Saturn Drive");
		driver.findElement(By.name("payee.address.city")).sendKeys("Lunar Landing");
		driver.findElement(By.name("payee.address.state")).sendKeys("California");
		driver.findElement(By.name("payee.address.zipCode")).sendKeys("90210");
		driver.findElement(By.name("payee.phoneNumber")).sendKeys("8135541511");
		driver.findElement(By.name("payee.accountNumber")).sendKeys("99800045");
		driver.findElement(By.name("verifyAccount")).sendKeys("99800045");
		driver.findElement(By.name("amount")).sendKeys("550.00");
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")).click();

	}
}
