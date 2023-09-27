package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class ClientLogin {
		WebDriver driver;
		
		public ClientLogin(WebDriver driver) {
			this.driver = driver;
		}
		
		public void loginToBankAccount() {
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			driver.findElement(By.name("username")).sendKeys("LuisShmuis");
			driver.findElement(By.name("password")).sendKeys("secret123");
			driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		}
}
