package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {

		//int i = PlayerMethod.getChoise(0,1);

		Player user = new Player();
		
		for (int i = 1; i <= 10; i++) {
			Integer[][] optionList = PlayerMethod.getCombination();

			user.setLane(optionList[1][1]);
		}
	}

}
