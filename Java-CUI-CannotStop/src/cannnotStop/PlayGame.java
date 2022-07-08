package cannnotStop;

import java.util.HashSet;

public class PlayGame {

	public static void main(String[] args) {
		Player user = new Player();

		while (true) {
			
			//サイコロを四回振って３通りの場合の数を出力する
			Integer[][] optionList = PlayerMethod.getCombination();
			
			//3種類進めてかつ、選択肢にもう進める駒がなければバーストフラグを立てる
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
				//選択肢が何もなければバースト
				if(!isContinue) {
					System.out.println("バーストしました");
					user.burstLanes();
					//break;
				}
			}
			
			int userChoise;
			switch(choiseList.size()) {
				case 0:
					//どのコマも進んでなく、３つの選択肢がある
					userChoise = PlayerMethod.getChoise(0, 2);
					break;
				case 1:
					//3種類駒を進めており、選択肢が１つ
					userChoise = (int)choiseList.toArray()[0];
					break;
				case 2:
					//3種類駒を進めており、選択肢が２つ
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
				}
			}else if(user.getStatus() == 2){
				int optionA = optionList[userChoise][0];
				int optionB = optionList[userChoise][1];
				
				//どちらかの数字が既に進んでいるならばどちらも駒を進める
				if(user.isContainStatus(optionA) || user.isContainStatus(optionB)) {
					user.setLane(optionA);
					user.setLane(optionB);
				}else {
					System.out.println("どちらか選択してください：　(0:" + optionA + ", 1:" + optionB + ")");
					int optionChoise = PlayerMethod.getChoise(0, 1);
					if(optionChoise == 0) {
						user.setLane(optionA);
					}else {
						user.setLane(optionB);
					}
				}	
			}else if(user.getStatus() == 3){
				int optionA = optionList[userChoise][0];
				int optionB = optionList[userChoise][1];
				
				if(user.isContainStatus(optionA) && user.isContainStatus(optionB)) {
					user.setLane(optionA);
					user.setLane(optionB);
				}else {
					if(user.isContainStatus(optionA)) {
						user.setLane(optionA);
					}else {
						user.setLane(optionB);
					}
				}	
			}
			//結果を表示
			user.printLane();
			
			System.out.println("手番を継続するか選択してください：　(0: 継続する 1: 手番を終了する)");
			int runOrStop = PlayerMethod.getChoise(0, 1);
			boolean isStopTurn = runOrStop == 0 ? false : true;
			if(isStopTurn) {
				//レーンの進捗を確定する。
				user.completeLane();
			}
			
			if (Player.getCompletedLane().size() == 3) {
				System.out.println("勝利しました。");
				break;
			}
		}
	}
}
