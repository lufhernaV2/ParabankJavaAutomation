package Test_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.ApplyForLoan;
import Objects.ClientLogin;
import Objects.ParabankAccountCreation;
import Objects.PayBillOnline;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods_ParabankE2EFlows {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void createBankAccount() {
		ParabankAccountCreation bankHomePage = new ParabankAccountCreation(driver);
		bankHomePage.signUp();
	}
	
	@Test
	public void payBillOnline() {
		ClientLogin clientLogin = new ClientLogin(driver);
		PayBillOnline billPay = new PayBillOnline(driver);
		clientLogin.loginToBankAccount();
		billPay.payOnlineBill();
	}
	
	@Test
	public void applyForALoan() {
		ClientLogin clientLogin = new ClientLogin(driver);
		ApplyForLoan applyForLoan = new ApplyForLoan(driver);
		clientLogin.loginToBankAccount();
		applyForLoan.applyForLoan();
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}
}
