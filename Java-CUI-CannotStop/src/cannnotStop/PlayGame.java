package cannnotStop;

import java.util.HashSet;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		while (true) {
			
			//サイコロを四回振って３通りの場合の数を出力する
			Integer[][] optionList = PlayerMethod.getCombination();
			
			//
			HashSet<Integer> choiseList = new HashSet<>();
			boolean isContinue = false;
			if(user.getStatus() == 3) {
				int i = 0;
				for(Integer[] list : optionList) {
					for(int num : list) {
						if(user.isContainStatus(num)) {
							isContinue = true;
							choiseList.add(i);
						}
					}
					i++ ;
				}
			}
			
			if(user.getStatus() == 3 && !isContinue) {
				System.out.println("バーストしました");
				break;
			}
			
			int userChoise;
			switch(choiseList.size()) {
				case 0:
					userChoise = PlayerMethod.getChoise(0, 2);
					break;
				case 1:
					userChoise = (int)choiseList.toArray()[0];
					break;
				case 2:
					userChoise = PlayerMethod.getChoiseOfTwo(
							(int)choiseList.toArray()[0], (int)choiseList.toArray()[1]);
					break;
				default:
					userChoise = PlayerMethod.getChoise(0, 2);
					break;
			}
			
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
			}else {
				int optionA = optionList[userChoise][0];
				int optionB = optionList[userChoise][1];
				
				if(user.isContainStatus(optionA) && user.isContainStatus(optionB)) {
					user.setLane(optionA);
					user.addStatus(optionA);
					
					user.setLane(optionB);
					user.addStatus(optionB);
				}else {
					if(user.isContainStatus(optionA)) {
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
