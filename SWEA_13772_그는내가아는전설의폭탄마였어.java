package SWEA;
import java.util.Scanner;

public class SWEA_13772_그는내가아는전설의폭탄마였어 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("1\r\n" + "7 3\r\n" + "1 8 1 4 2 5 1\r\n" + "1 5 2 6 7 2 3\r\n" + "7 9 5 5 1 9 8\r\n"
				+ "3 7 0 9 8 0 7\r\n" + "5 5 3 9 5 1 4\r\n" + "2 5 9 3 3 6 8\r\n" + "0 1 4 1 8 4 0");
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int power = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int[] pdr = { -1, 1, 0, 0 }; // plus모양의 dr
			int[] pdc = { 0, 0, -1, 1 }; // plus모양의 dc
			int[] mdr = { -1, -1, 1, 1 }; // multiply 모양의 dr
			int[] mdc = { -1, 1, -1, 1 }; // multiply 모양의 dc

			int pmax = 0;
			int mmax = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					int pcnt = map[r][c];
					int mcnt = map[r][c];

					for (int p = 1; p <= power; p++) {
						for (int i = 0; i < 4; i++) {
							int pnr = r + pdr[i] * p;
							int pnc = c + pdc[i] * p;
							if (pnr >= 0 && pnc >= 0 && pnr < n && pnc < n) {
								pcnt += map[pnr][pnc];
							}

							int mnr = r + mdr[i] * p;
							int mnc = c + mdc[i] * p;
							if (mnr >= 0 && mnc >= 0 && mnr < n && mnc < n) {
								mcnt += map[mnr][mnc];
							}
						}
					}
					pmax = Math.max(pcnt, pmax);
					mmax = Math.max(mcnt, mmax);
				}
			}
			int max = Math.max(pmax, mmax);

			System.out.println("#" + tc + " " + max);
		}

	}
}
