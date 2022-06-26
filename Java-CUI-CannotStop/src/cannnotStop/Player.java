package cannnotStop;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private static final int MAX_LANE_TWO = 3;
	private static final int MAX_LANE_THREE = 5;
	private static final int MAX_LANE_FOUR = 7;
	private static final int MAX_LANE_FIVE = 9;
	private static final int MAX_LANE_SIX = 11;
	private static final int MAX_LANE_SEVEN = 13;
	private static final int MAX_LANE_EIGHT = 11;
	private static final int MAX_LANE_NINE = 9;
	private static final int MAX_LANE_TEN = 7;
	private static final int MAX_LANE_ELEVEN = 5;
	private static final int MAX_LANE_TWELVE = 3;
	private static final HashMap<Integer, Integer> maxLaneMap = new HashMap<Integer, Integer>();
	private static final ArrayList<Integer> completedLane = new ArrayList<Integer>();

	private int successedLane = 0;
	private int status;
	private ArrayList<Integer> lanes = new ArrayList<Integer>();

	public Player() {
		status = 0;
		for (int i = 0; i <= 10; i++) {
			lanes.add(0);
		}
		maxLaneMap.put(2, MAX_LANE_TWO);
		maxLaneMap.put(3, MAX_LANE_THREE);
		maxLaneMap.put(4, MAX_LANE_FOUR);
		maxLaneMap.put(5, MAX_LANE_FIVE);
		maxLaneMap.put(6, MAX_LANE_SIX);
		maxLaneMap.put(7, MAX_LANE_SEVEN);
		maxLaneMap.put(8, MAX_LANE_EIGHT);
		maxLaneMap.put(9, MAX_LANE_NINE);
		maxLaneMap.put(10, MAX_LANE_TEN);
		maxLaneMap.put(11, MAX_LANE_ELEVEN);
		maxLaneMap.put(12, MAX_LANE_TWELVE);
	}

	public static ArrayList<Integer> getCompletedLane() {
		return completedLane;
	}

	public static void setCompletedLane(int laneNum) {
		completedLane.add(laneNum);
	}

	public static void resetCompletedLane() {
		completedLane.clear();
	}

	//サイコロの和である2はlanes[0]
	public void setLane(int laneNum) {
		int index = laneNum - 2;
		int currentNum = lanes.get(index);

		if (laneNum >= 2 && laneNum <= 12) {

			if (currentNum < maxLaneMap.get(laneNum)) {
				lanes.set(index, currentNum + 1);
			}
			//最大値に達した時点でそのレーンは完了。
			if (currentNum == maxLaneMap.get(laneNum)) {
				setCompletedLane(laneNum);
			}
		}
	}

	public void printLane() {
		int num = 2;
		for (int i : lanes) {
			System.out.print("lane " + String.format("%02d", num) + ":");

			for (int j = 1; j <= maxLaneMap.get(num); j++) {
				System.out.print(i >= j ? "■ " : "□ ");
			}
			System.out.println();
			num++;
		}
		System.out.println();
	}

	public void incrementStatus() {
		if (status <= 3) {
			status++;
		}
	}

	public void resetStatus() {
		status = 0;
	}

	public void incrementSuccessedLane() {
		if (successedLane <= 3) {
			successedLane++;
		}
	}

	public void resetSuccessedLane() {
		successedLane = 0;
	}

}
