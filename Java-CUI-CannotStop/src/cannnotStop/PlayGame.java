package cannnotStop;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		while (true) {
			Integer[][] optionList = PlayerMethod.getCombination();
			
			boolean isContinue = false;
			if(user.getStatus() == 3) {
				for(Integer[] list : optionList) {
					for(int num : list) {
						if(user.isContainStatus(num)) {
							isContinue = true;
						}
					}
				}
			}
			
			if(user.getStatus() == 3 && !isContinue) {
				System.out.println("バーストしました");
				break;
				}
			
			int userChoise = PlayerMethod.getChoise(0, 2);
			
			if(user.getStatus() < 2) {
				for(int newNum : optionList[userChoise]) {
						user.setLane(newNum);
						user.addStatus(newNum);
				}
			}else if(user.getStatus() == 2){
				int optionA = optionList[userChoise][0];
				int optionB = optionList[userChoise][1];
				
				//どちらかの数字が既に進んでいるならばどちらも駒を進める
				if(user.isContainStatus(optionA) || user.isContainStatus(optionB)) {
					user.setLane(optionA);
					user.addStatus(optionA);
					
					user.setLane(optionB);
					user.addStatus(optionB);
				}else {
					System.out.println("どちらか選択してください：　(0:" + optionA + ", 1:" + optionB + ")");
					int optionChoise = PlayerMethod.getChoise(0, 1);
					if(optionChoise == 0) {
						user.setLane(optionA);
						user.addStatus(optionA);
					}else {
						user.setLane(optionB);
						user.addStatus(optionB);
					}
				}	
			}
			

			user.printLane();
			if (Player.getCompletedLane().size() == 3) {
				break;
			}
		}
	}
}
