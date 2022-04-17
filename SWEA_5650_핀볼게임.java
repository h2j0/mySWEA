package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {

	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int[][] wormhole; // 웜홀 (1-6 / 2-7 / ... 이런식으로 세트)
	static int cnt;
	static int N;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2];
			wormhole = new int[11][2];

			for (int i = 0; i < N + 2; i++) {
				map[0][i] = map[i][0] = map[N + 1][i] = map[i][N + 1] = 5;
			}
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;

					if (tmp > 5) {
						if (wormhole[tmp - 5][0] == 0) {
							wormhole[tmp - 5][0] = i;
							wormhole[tmp - 5][1] = j;

						} else {
							wormhole[tmp][0] = i;
							wormhole[tmp][1] = j;
						}
					}
				}
			} // 입력 받으면서 웜홀 저장
			ans = 0;
			// 맵 값이 0이면 네방향 모두 가보기
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (map[r][c] == 0) {
						for (int d = 0; d < 4; d++) {
							play(r, c, d);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // tc

	}// main

	static void play(int stR, int stC, int d) {
		int r = stR;
		int c = stC;
		int score = 0;

		while (true) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if ((nr == stR && nc == stC) || map[nr][nc] == -1) {
				ans = Math.max(ans, score);
				return;
			}
			switch (map[nr][nc]) {
			case 5:
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 3;
				else
					d = 2;
				score++;
				break;
			case 1:
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 3;
				else if (d == 2)
					d = 0;
				else
					d = 2;
				score++;
				break;
			case 2:
				if (d == 0)
					d = 3;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 1;
				else
					d = 2;
				score++;
				break;
			case 3:
				if (d == 0)
					d = 2;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 3;
				else
					d = 1;
				score++;
				break;
			case 4:
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 2;
				else if (d == 2)
					d = 3;
				else
					d = 0;
				score++;
				break;

			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				int holeNum = map[nr][nc];
				if (nr == wormhole[holeNum][0] && nc == wormhole[holeNum][1]) {
					nr = wormhole[holeNum - 5][0];
					nc = wormhole[holeNum - 5][1];
				} else if (nr == wormhole[holeNum - 5][0] && nc == wormhole[holeNum - 5][1]) {
					nr = wormhole[holeNum][0];
					nc = wormhole[holeNum][1];
				}
				break;
			}// switch

			r = nr;
			c = nc;
		}

	}

}
