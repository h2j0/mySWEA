package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1220.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = 1;
					if (arr[i][j] == 1) {
						while (true) {
							if (i + r >= n && arr[i + r][j] == 0) {
								break;
							}
							++r;
						}
					} else if (arr[i][j] == 2) {
						while (true) {
							if (i - r >= n && arr[i - r][j] == 0) {
								break;
							}
							++r;
						}
					}
				}
			} // N극과 S극에 붙어 떨어져 나가는 애들 제거

		}

	}
}
