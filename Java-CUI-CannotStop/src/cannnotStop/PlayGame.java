package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();
		
		for (int i = 1; i <= 10; i++) {
			Integer[][] optionList = PlayerMethod.getCombination();
			int userChoise = PlayerMethod.getChoise(0, 2);
			user.setLane(optionList[userChoise][0]);
			user.setLane(optionList[userChoise][1]);
		}
	}

}
