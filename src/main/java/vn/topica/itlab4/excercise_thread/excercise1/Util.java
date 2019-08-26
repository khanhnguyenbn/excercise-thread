package vn.topica.itlab4.excercise_thread.excercise1;

import java.util.Random;

public class Util {

	// random number from min to max
	public static int randomInt(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt(max + 1 - min) + min;
		
		return randomNumber;
	}
}
