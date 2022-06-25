package cannnotStop;

import java.util.Random;

public class Dice {
	private static final int MIN = 1;
	private static final int MAX = 6;
	private static final Random random = new Random();

	public Dice() {
	}
	
	public static int roll() {
		//num = random number from MIN to MAX
		int num = random.nextInt(MAX - MIN + 1) + MIN;
		return num;
	}
}
