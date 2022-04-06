package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_11315_오목판정 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input11315.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next().toCharArray();

			} // 입력완

			// 가로확인
			boolean flag = false;
			int cnt;
			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - 5; j++) {
					cnt = 0;
					for (int k = 0; k < 5; k++) {
						if (arr[i][j + k] == 'o') {
							cnt++;
						}
						if (cnt == 5) {
							flag = true;
							break outer;
						}
					}
				}
			}

			// flag가 false로 나올 때만
			// 세로확인
			if (!flag) {
				outer: for (int i = 0; i <= n - 5; i++) {
					for (int j = 0; j < n; j++) {
						cnt = 0;
						for (int k = 0; k < 5; k++) {
							if (arr[i + k][j] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break outer;
							}
						}
					}
				}
			}

			// 대각선 좌상에서 우하로
			if (!flag) {
				outer: for (int i = 0; i <= n - 5; i++) {
					for (int j = 0; j <= n - 5; j++) {
						cnt = 0;
						for (int k = 0; k < 5; k++)
							if (arr[i + k][j + k] == 'o') {
								cnt++;
							}
						if (cnt == 5) {
							flag = true;
							break outer;
						}
					}
				}
			}

			// 대각선 우상에서 좌하로
			if (!flag) {
				outer: for (int i = 0; i <= n - 5; i++) {
					for (int j = n - 1; j >= 4; j--) {
						cnt = 0;
						for (int k = 0; k < 5; k++) {
							if (arr[i + k][j - k] == 'o') {
								cnt++;
							}
							if (cnt == 5) {
								flag = true;
								break outer;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + (flag ? "YES" : "NO"));
		} // 테케
	}
}
