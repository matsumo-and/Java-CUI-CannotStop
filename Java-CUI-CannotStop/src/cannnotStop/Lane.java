package cannnotStop;

public enum Lane {

	TWO(3), THREE(5), FOUR(7), FIVE(9), SIX(11), SEVEN(13), EIGHT(11), NINE(9), TEN(7), ELEVEN(5), TWELVE(3);

	private final int id;

	private Lane(int id) {
		this.id = id;
	}

	public int getInt() {
		return this.id;
	}

}
