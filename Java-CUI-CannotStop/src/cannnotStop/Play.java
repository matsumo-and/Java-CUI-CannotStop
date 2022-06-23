package cannnotStop;

public class Play {

	public static void main(String[] args) {
		Dice dice = new Dice();

		System.out.println(dice.roll());
		
		int i = PlayerChoise.getChoise(0,1);
		System.out.println(i);
	}

}
