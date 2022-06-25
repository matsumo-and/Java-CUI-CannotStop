package cannnotStop;

import java.util.ArrayList;

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

	private static final ArrayList<Integer> completedLane = new ArrayList<Integer>();

	private int successedLane = 0;
	private int status;
	private ArrayList<Integer> lanes = new ArrayList<Integer>();

	public Player() {
		status = 0;
		for (int i = 0; i <= 10; i++)
			lanes.add(0);
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

		switch (laneNum) {
		case 2:
			if (currentNum < MAX_LANE_TWO) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 3:
			if (currentNum < MAX_LANE_THREE) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 4:
			if (currentNum < MAX_LANE_FOUR) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 5:
			if (currentNum < MAX_LANE_FIVE) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 6:
			if (currentNum < MAX_LANE_SIX) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 7:
			if (currentNum < MAX_LANE_SEVEN) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 8:
			if (currentNum < MAX_LANE_EIGHT) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 9:
			if (currentNum < MAX_LANE_NINE) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 10:
			if (currentNum < MAX_LANE_TEN) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 11:
			if (currentNum < MAX_LANE_ELEVEN) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		case 12:
			if (currentNum < MAX_LANE_TWELVE) {
				lanes.set(index, currentNum + 1);
			} else {
				setCompletedLane(laneNum);
			}
			break;
		default:
		}
		for (int i : lanes) {
			System.out.print(i + ",");
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
