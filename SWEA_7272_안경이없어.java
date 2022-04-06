package SWEA;
import java.util.Scanner;

public class SWEA_7272_안경이없어 {
	static String newStr1;
	static String newStr2;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(
				"5\r\n" + "ABCD EFGH\r\n" + "ABCD PBZO\r\n" + "PRQO OQAD\r\n" + "ZXCV HJKL\r\n" + "BBBB BBB");

		// CEFGHIJKLMNSTUVWXYZ
		char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
		char[] two = { 'B' };
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String newStr1 = changeStr(str1);

			String str2 = sc.next();
			String newStr2 = changeStr(str2);

			String ans = "DIFF";
			if (newStr1.equals(newStr2)) {
				ans = "SAME";
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static String changeStr(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'B') {
				newStr += "B";
			} else if (str.charAt(i) == 'A' || str.charAt(i) == 'D' || str.charAt(i) == 'O' || str.charAt(i) == 'P'
					|| str.charAt(i) == 'Q' || str.charAt(i) == 'R') {
				newStr += "A";
			} else {
				newStr += "C";
			}
		}
		return newStr;
	}

}
