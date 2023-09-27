package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ApplyForLoan {
	WebDriver driver;
	
	public ApplyForLoan(WebDriver driver) {
		this.driver = driver;
	}
	
	public void applyForLoan() {
		
		// click here to request a loan
		driver.findElement(By.linkText("Request Loan")).click();
		
		// loan application
		driver.findElement(By.id("amount")).sendKeys("1500.00");
		driver.findElement(By.id("downPayment")).sendKeys("350.00");
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[4]/td[2]/input")).click();
		
		
		// confirm that the transfer was done successfully!
		WebElement loanConfirmation = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/div/p[1]"));
		String loanConfirmationText = "Congratulations, your loan has been approved.";
		try {
			Assert.assertEquals(loanConfirmation.getText(), loanConfirmationText);
			System.out.println("This test has passed");
		} catch(AssertionError e) {
			System.out.println("This test has failed");
		}
		
	}
}
