package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1226_미로1_DFS {

	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테케 입력 버리기
			map = new char[16][16];
			visited = new boolean[16][16];
			int stR = 0;
			int stC = 0;
			boolean flag = true;
			for (int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
				// 한 행씩 돌면서 2 찾는데, 한번 찾으면 반복문 안들어간다
				if (flag) {
					for (int j = 0; j < 16; j++) {
						if (map[i][j] == '2') {
							stR = i;
							stC = j;
							flag = false;
							break;
						}
					}
				}
			} // 입력 완
			ans = 0;
			dfs(stR, stC);
			System.out.println(ans);
		} // tc

	}// main

	private static void dfs(int r, int c) {
		// 종료 조건
		if (map[r][c] == '3') {
			ans = 1;
			return;
		}
		// 방문처리
		visited[r][c] = true;

		// 네방향 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16)
				continue;
			if (visited[nr][nc] || map[nr][nc] == '1')
				continue;
			dfs(nr, nc);
		}
	}
}
