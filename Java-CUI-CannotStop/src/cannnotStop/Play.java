package cannnotStop;

public class Play {

	public static void main(String[] args) {
		Dice dice = new Dice();

		for (int i = 0; i < 10; i++) {
			System.out.println(dice.roll());
		}
	}

}
