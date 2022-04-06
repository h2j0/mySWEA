package SWEA;
import java.util.Scanner;

public class SWEA_1226_미로1_재귀_교수님 {
	static char[][] map; // 미로를 저장할 2차원 배열
	// 4방향 델타를 정의해놓고 갑시다. 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N = 16;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc < 10; tc++) {
			sc.next(); // 테케 번호 버리기
			map = new char[N][N];
			ans = 0;
			int stR = -1;
			int stC = -1;
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				// 시작점 찾아 저장해놓자
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '2') {
						stR = i;
						stC = j;
					}
				}
			} // 입력
			dfs(stR, stC);
			System.out.println("#" + tc + " " + ans);
		} // tc
	}// main

	static void dfs(int r, int c) {
		// 1. 기본구간
		// 종료 조건
		if (map[r][c] == '3') {
			ans = 1;
			return;
		}
		// 2. 순환구간
		// 방문처리
		map[r][c] = '1'; // 벽으로 바꾼다
		// 내가 갈 수 있는 곳 가본다
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 이제 갈 수 있는 곳인지 확인하고 재귀 호출~~!
			// 내 안에 못들어오면 쳐내
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			// 벽이니? 쳐내
			if (map[nr][nc] == '1')
				continue;

			dfs(nr, nc);
		}

	}

}
