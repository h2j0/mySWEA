package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226_미로1_BFS {

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테케 입력 버리기
			map = new char[16][16];
			ans = 0;
			Pos st = null;
			boolean flag = true;
			for (int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
				// 한 행씩 돌면서 2 찾는데, 한번 찾으면 반복문 안들어간다
				if (flag) {
					for (int j = 0; j < 16; j++) {
						if (map[i][j] == '2') {
							st = new Pos(i, j);
							flag = false;
							break;
						}
					}
				}
			} // 입력 완

			boolean[][] visited = new boolean[16][16];

			// 1. 큐 생성
			Queue<Pos> q = new LinkedList<>();

			// 2. 시작점 넣기
			q.add(st);
			visited[st.r][st.c] = true;

			// 3. 큐가 공백이 될 떄까지
			while (!q.isEmpty()) {
				// 3-1. 하나 꺼내
				Pos curr = q.poll();

				if (map[curr.r][curr.c] == '3') {
					ans = 1;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];

					if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16)
						continue;
					if (map[nr][nc] == '1' || visited[nr][nc])
						continue;

					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			}
			System.out.println(ans);
		} // tc

	}// main

}
