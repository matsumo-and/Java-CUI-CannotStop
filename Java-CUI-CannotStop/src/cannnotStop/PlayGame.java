package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		boolean isTurnFinished = false;
		while (!isTurnFinished) {
			Integer[][] optionList = PlayerMethod.getCombination();
			int userChoise = PlayerMethod.getChoise(0, 2);
			user.setLane(optionList[userChoise][0]);
			user.setLane(optionList[userChoise][1]);

			user.printLane2();
			if (Player.getCompletedLane().size() != 0) {
				isTurnFinished = true;
			}
		}
	}

}
