package SWEA;
import java.util.Scanner;

public class SWEA_기지국_비밀비밀 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("2\r\n" + "9\r\n" + "XXXXXXXXX\r\n" + "XXXHXXXXX\r\n" + "XXHAHXXHX\r\n"
				+ "XXHHXXXXX\r\n" + "XXXXXXXXX\r\n" + "XXAHHXXXX\r\n" + "XXHXXHAHX\r\n" + "XXAHXXHXX\r\n"
				+ "XXHXHXXXX\r\n" + "9\r\n" + "XXXHXXXXX\r\n" + "XXXHXXXXX\r\n" + "XXHCHXHHX\r\n" + "XXHHXXHXX\r\n"
				+ "XXXHXHBHH\r\n" + "XHAHHXXXX\r\n" + "XXHXXXHXX\r\n" + "XXAHXHAHX\r\n" + "XXHXHXXXX");
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = sc.next().toCharArray();
			} // 입력완

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					switch (map[r][c]) {
					case 'A':
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
								map[nr][nc] = 'O';
							}
						}
						break;
					case 'B':
						for (int k = 1; k <= 2; k++) {
							for (int i = 0; i < 4; i++) {
								int nr = r + dr[i] * k;
								int nc = c + dc[i] * k;
								if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
									map[nr][nc] = 'O';
								}
							}
						}
						break;
					case 'C':
						for (int k = 1; k <= 3; k++) {
							for (int i = 0; i < 4; i++) {
								int nr = r + dr[i] * k;
								int nc = c + dc[i] * k;
								if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
									map[nr][nc] = 'O';
								}
							}
						}
						break;
					default:
						break;
					}

				}
			}
			int cnt = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] == 'H') {
						cnt++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
