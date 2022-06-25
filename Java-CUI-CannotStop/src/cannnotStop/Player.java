package cannnotStop;

import java.util.ArrayList;

public class Player {
	private final int MAX_LANE_TWO = 3;
	private final int MAX_LANE_THREE = 5;
	private final int MAX_LANE_FOUR = 7;
	private final int MAX_LANE_FIVE = 9;
	private final int MAX_LANE_SIX = 11;
	private final int MAX_LANE_SEVEN = 13;
	private final int MAX_LANE_EIGHT = 11;
	private final int MAX_LANE_NINE = 9;
	private final int MAX_LANE_TEN = 7;
	private final int MAX_LANE_ELEVEN = 5;
	private final int MAX_LANE_TWELVE = 3;
	
	private int status;
	private ArrayList<Integer> lanes = new ArrayList<Integer>();
	
	public Player() {
		status = 0;
		for(int i = 0; i <= 11; i++)
		lanes.add(null);
	}
}
