package Objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ParabankAccountCreation {
	
	WebDriver driver;
	
	public ParabankAccountCreation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signUp() {
		Random random = new Random();
		String[] firstNames = {"John", "Sue", "Curly", "Maria", "Evelyn", "Luis"};
		String[] lastNames = {"Pantoja", "Hernandez", "Acme", "Morfa", "Gomez", "Smith"};
		String randomGeneratedFirstName = firstNames[random.nextInt(firstNames.length)];
		String randomGeneratedLastName = lastNames[random.nextInt(lastNames.length)];
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		// click on the register button on the home page
		driver.findElement(By.linkText("Register")).click();
		
		// inputting all the information in the form
		driver.findElement(By.name("customer.firstName")).sendKeys(randomGeneratedFirstName);
		driver.findElement(By.name("customer.lastName")).sendKeys(randomGeneratedLastName);
		driver.findElement(By.id("customer.address.street")).sendKeys("7273 Testing Street");
		driver.findElement(By.id("customer.address.city")).sendKeys("TestingVille");
		driver.findElement(By.name("customer.address.state")).sendKeys("Florida");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys("33813");
		driver.findElement(By.name("customer.phoneNumber")).sendKeys("8136765566");
		driver.findElement(By.name("customer.ssn")).sendKeys("078-66-7898");
		driver.findElement(By.name("customer.username")).sendKeys("LuisShmuis");
		driver.findElement(By.name("customer.password")).sendKeys("secret123");
		driver.findElement(By.name("repeatedPassword")).sendKeys("secret123");
		driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
		
		// confirm that the account was created successfully!
		WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
		String successMessageText = "Your account was created successfully. You are now logged in.";
		try {
			Assert.assertEquals(successMessage.getText(), successMessageText);
			System.out.println("This test has passed");
		} catch(AssertionError e) {
			System.out.println("This test has failed");
		}
	}
		
}
