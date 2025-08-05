package Utils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestDataGenerator {
	static Random rand = new Random();

	public static String GetRandomeFirstName() {
		String[] names = { "Ahmad", "Marwan", "Samer", "Sami" };
		return names[rand.nextInt(names.length)];
	}

	public static String GetRandomLastName() {
		String[] names = { "eslam", "esraa", "rahaf", "rema" };
		return names [rand.nextInt(names.length)];

	}

	public static String GetEmail(String first, String last) {
		return first + last + rand.nextInt(7000) + "@gmail.com";

	}

	public static String getRandomUserName(String first, String last) {
		return first + last + rand.nextInt(7000) ;

	}
	public static void CheckItemAvialbilit(WebDriver driver) {
		WebElement addToCartBtn = driver.findElement(By.className("productpagecart"));
        if (addToCartBtn.getText().equals("Out of Stock")) {
            System.out.println("Item is out of stock");
            return;
	}else {
		if (driver.getCurrentUrl().contains("product_id=116")) {
			driver.findElement(By.cssSelector("#option344748")).click();	
		
	}
        addToCartBtn.click();
		
		
		
	}

}
	}
