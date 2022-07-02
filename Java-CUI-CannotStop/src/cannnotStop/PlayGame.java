package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		while (true) {
			Integer[][] optionList = PlayerMethod.getCombination();
			int userChoise = PlayerMethod.getChoise(0, 2);
			
			int status = user.getStatus();
			if(status <= 3) {}
			user.setLane(optionList[userChoise][0]);
			user.setLane(optionList[userChoise][1]);

			user.printLane();
			if (Player.getCompletedLane().size() == 3) {
				break;
			}
		}
	}

}
