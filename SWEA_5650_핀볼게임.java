package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static List<Pos> wormhole;
	static Pos blackhole;
	static int cnt;
	static int N;
	static int score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input5650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];

			wormhole = new ArrayList<>(11);
			for (int i = 0; i <= 10; i++) {
				wormhole.add(null);
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if (tmp > 5) {
						Pos p = new Pos(i, j);
						if (wormhole.get(tmp - 5) == null)
							wormhole.set(tmp - 5, p);
						else
							wormhole.set(tmp, p);
					}
					if (tmp == -1)
						blackhole = new Pos(i, j);
				}
			} // 입력 받으면서 웜홀, 블랙홀 저장하기

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {
						// 한 칸씩 상하좌우 다 가봐
						// 갈 수 있으면 그 방향으로 dfs

						cnt = 0;
						play(r, c, d);

					}

				}
			}

		} // tc

	}// main

	static void play(int r, int c, int d) {
		visited[r][c] = true;

		int nr = r + dr[d];
		int nc = c + dc[d];
		//
		if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
			// 범위에 해당이 되고 방문하지 않았다면
			switch (map[nr][nc]) {

			case 0:
				dfs(nr, nc, d);
				break;
			case 1:
				score++;
				if (d == 2) // 좌 -> 상
					dfs(nr, nc, 0);
				else if (d == 1) // 하->우
					dfs(nr, nc, 3);
				else
					dfs(nr, nc, ((d + 2) % 4));
				break;
			
			case 2
				
			
			}

		}
		visited[r][c] = false;
	}

	// 순환
	// 박문철이

}
