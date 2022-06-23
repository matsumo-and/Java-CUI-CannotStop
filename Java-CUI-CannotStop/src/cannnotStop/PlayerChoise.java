package cannnotStop;

import java.util.Scanner;

public class PlayerChoise {
	final static Scanner scanner = new Scanner(System.in);

	public PlayerChoise() {
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

}
