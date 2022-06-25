package cannnotStop;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMethod {
	final static Scanner scanner = new Scanner(System.in);

	public PlayerMethod() {
	}

	public static int getChoise(int min, int max) {
		int decision = -1;

		System.out.println(String.format("%sから%sの数値を入力してください。", min, max));
		while (true) {
			try {
				decision = scanner.nextInt();
				if (decision <= max && decision >= min) {
					break;
				} else {
					System.out.println(String.format("%sから%sの数値を入力してください。", min, max));
				}
			} catch (Exception e) {
				System.out.println("数値を入力してください。");
				scanner.next();
			}
		}
		return decision;
	}

	public static ArrayList<Integer> getCombination() {
		ArrayList<Integer> combiList = new ArrayList<Integer>();

		int dice1 = Dice.roll();
		int dice2 = Dice.roll();
		int dice3 = Dice.roll();
		int dice4 = Dice.roll();

		System.out.println(
				String.format("サイコロの目：{%s, %s, %s, %s}", dice1, dice2, dice3, dice4));

		System.out.println(
				String.format("1 {%s, %s}: %s ", dice1, dice2, dice1+dice2)
				+ String.format("{%s, %s}: %s ", dice1, dice3, dice1+dice3)
				);

		return combiList;
	}

}
