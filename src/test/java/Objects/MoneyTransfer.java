package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

	public class MoneyTransfer {
		WebDriver driver;
		
		public MoneyTransfer(WebDriver driver) {
			this.driver = driver;
		}
	
		public void transferMoneyToSavings() {
			String transferAmount = "15.00";
			
			driver.findElement(By.linkText("Transfer Funds")).click();
			driver.findElement(By.id("amount")).sendKeys(transferAmount);
			
			WebElement accountDropdown = driver.findElement(By.id("toAccountId"));
			Select accountSelection = new Select(accountDropdown);
			accountSelection.selectByVisibleText("15564");	
			
			driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")).click();
			
			// confirm that the transfer was done successfully!
			WebElement transferConfirmation = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1"));
			String transferConfirmationText = "Transfer Complete!";
			try {
				Assert.assertEquals(transferConfirmation.getText(), transferConfirmationText);
				System.out.println("This test has passed");
			} catch(AssertionError e) {
				System.out.println("This test has failed");
			}
			
		}
}
