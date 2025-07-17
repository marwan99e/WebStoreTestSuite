package Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	WebDriver driver;
	Random rand = new Random();

	public SignUpPage(WebDriver thedriver) {

		this.driver = thedriver;
	}

	By firstName = By.xpath("//*[@id=\"AccountFrm_firstname\"]");
	By LastName = By.xpath("//*[@id=\"AccountFrm_lastname\"]");
	By Email = By.xpath("//*[@id=\"AccountFrm_email\"]");
	By Telepone = By.xpath("//*[@id=\"AccountFrm_telephone\"]");
	By Fax = By.xpath("//input[@id='AccountFrm_fax']");
	By Company = By.xpath("//input[@id='AccountFrm_company']");
	By Address1 = By.xpath("//input[@id='AccountFrm_address_1']");
	By Address2 = By.xpath("//input[@id='AccountFrm_address_2']");
	By City = By.xpath("//input[@id='AccountFrm_city']");
	By PostalCode = By.id("AccountFrm_postcode");
	By loginName = By.id("AccountFrm_loginname");
	By password = By.id("AccountFrm_password");
	By passwordConfirm = By.id("AccountFrm_confirm");
	By agreebox = By.id("AccountFrm_agree");
	By Continue = By.cssSelector(".btn.btn-orange.pull-right.lock-on-click");
	By Country = By.id("AccountFrm_country_id");
	By State = By.id("AccountFrm_zone_id");

	public void fillForm(String f, String l, String mail, String phone, String user, String pass, String firstname)
			throws InterruptedException {

		driver.findElement(firstName).sendKeys(l);
		driver.findElement(LastName).sendKeys(l);
		driver.findElement(Email).sendKeys(mail);
		driver.findElement(Telepone).sendKeys(phone);
		driver.findElement(Fax).sendKeys("962507799882");
		driver.findElement(Company).sendKeys("DFS");
		driver.findElement(Address1).sendKeys("Amman tlaaelAli");
		driver.findElement(Address2).sendKeys("Amman ShafaBadran");

		Select countrySelect = new Select(driver.findElement(Country));
		int countryCount = driver.findElement(Country).findElements(By.tagName("option")).size();
		countrySelect.selectByIndex(rand.nextInt(countryCount));

		Thread.sleep(1000);

		Select stateSelect = new Select(driver.findElement(State));
		int stateCount = driver.findElement(State).findElements(By.tagName("option")).size();
		stateSelect.selectByIndex(rand.nextInt(stateCount));

		driver.findElement(PostalCode).sendKeys("4455");
		driver.findElement(loginName).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(passwordConfirm).sendKeys(pass);
		driver.findElement(agreebox).click();
		driver.findElement(Continue).click();

	}

	public boolean IsSignUpSuccess() {
		return driver.getPageSource().contains("Your Account Has Been Created!");

	}

}
