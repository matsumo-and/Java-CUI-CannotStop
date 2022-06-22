package cannnotStop;

import java.util.Random;

public class Dice {
	private final int MIN = 1;
	private final int MAX = 6;
	private final Random random = new Random();

	public Dice() {
	}
	
	public int roll() {
		//num = random number from MIN to MAX
		int num = random.nextInt(MAX - MIN + 1) + MIN;
		return num;
	}
}
