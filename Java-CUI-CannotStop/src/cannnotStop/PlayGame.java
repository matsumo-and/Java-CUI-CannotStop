package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		while (true) {
			Integer[][] optionList = PlayerMethod.getCombination();
			int userChoise = PlayerMethod.getChoise(0, 2);
			int status = user.getStatus();
			
			for(int newNum : optionList[userChoise]) {
				
				if(user.isContainStatus(newNum)) {
					user.setLane(newNum);
				}else if (user.getStatus() < 3) {
					user.setLane(newNum);
					user.addStatus(newNum);
				}else {
					
				}
				
			}
			if(status <= 3) {}

			user.printLane();
			if (Player.getCompletedLane().size() == 3) {
				break;
			}
		}
	}

}
