package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.SignUpPage;
import Utils.DriverFactory;
import Utils.TestDataGenerator;

public class UserTests {
	WebDriver driver;
	SignUpPage signUpPage;
	String firstName;
	String lastName;
	String userName;
	String email;
	String password = "Test25@25";
	Random rand = new Random();

	@BeforeTest

	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://automationteststore.com/index.php?rt=account/create");
		signUpPage = new SignUpPage(driver);

	}

	@Test(priority = 1)
	public void testSignUp() throws InterruptedException {
		try {
			firstName = TestDataGenerator.GetRandomeFirstName();
			lastName = TestDataGenerator.GetRandomLastName();
			userName = TestDataGenerator.getRandomUserName(firstName, lastName);
			email = TestDataGenerator.GetEmail(firstName, lastName);

		} catch (Exception e) {
			System.out.println(e);
		}

		signUpPage.fillForm(firstName, lastName, email, "8595763214", userName, password);
		Assert.assertTrue(signUpPage.IsSignUpSuccess(), "Signup failed");

	}

	@Test(priority = 2)
	public void testLogout() throws InterruptedException {
		try {
			WebElement logoutButton = driver.findElement(By.linkText("Logoff"));
			logoutButton.click();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getPageSource().contains("You have been logged off your account."));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 3, dependsOnMethods = { "testSignUp" })
	public void testLogIn() throws InterruptedException {
		try {
			driver.findElement(By.partialLinkText("Login or register")).click();
			driver.findElement(By.id("loginFrm_loginname")).sendKeys(userName);
			;
			driver.findElement(By.id("loginFrm_password")).sendKeys(password);
			;
			driver.findElement(By.xpath("//button[@title='Login']")).click();
			Thread.sleep(1000);
			Assert.assertTrue(driver.findElement(By.id("customernav")).getText().contains(firstName), "Login failed");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 4)
	public void testaddToCardAndCheckout() throws InterruptedException {

		driver.get("https://automationteststore.com/");
		Thread.sleep(1000);
		List<WebElement> items = driver.findElements(By.className("prdocutname"));
		int RandomeIndex = rand.nextInt(items.size());
		items.get(RandomeIndex).click();

		Thread.sleep(2000);
		TestDataGenerator.CheckItemAvialbilit(driver);
		driver.findElement(By.linkText("Checkout")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Checkout navigation failed");

		Thread.sleep(1000);
	}

	@AfterTest
	public void teardown() {
		DriverFactory.quitDriver();
	}
}
