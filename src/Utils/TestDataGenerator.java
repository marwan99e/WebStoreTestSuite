package Utils;

import java.util.Random;

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

}
