package SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7087_문제제목붙이기 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in); 
		Scanner sc = new Scanner("3\r\n" + "5\r\n" + "Air\r\n" + "Dad\r\n" + "Ear\r\n" + "Blue\r\n" + "Ace\r\n"
				+ "3\r\n" + "Snow_White\r\n" + "A_Problem\r\n" + "Another_Problem\r\n" + "2\r\n" + "Good_Problem\r\n"
				+ "Better_Problem");
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] alpha = new int[26];
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				alpha[sc.next().charAt(0) - 'A']++;
			}

			int ans = 0;

			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] == 0) {
					break;
				} else {
					ans++;
				}

			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
