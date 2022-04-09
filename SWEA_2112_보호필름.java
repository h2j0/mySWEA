package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int D, W, K; // 행(두께), 열, 통과 기준
	static int[][] film; // 필름을 저장할 친구
	static int ans;

//	static int[][] newFilm;
//	static int[] dc = { 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
//			newFilm = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
//					newFilm[i][j] = tmp;
				}
			} // 입력 받자

			ans = 987654321; // 정답을 초기화 하자~~

			wkdgksrjf(0, 0);

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main
		// 약품을 주입도 해보고 그냥도 내려보는 재귀함수
		// idx : 내가 지금 보고 있는 행, cnt : 약품을 주입한 횟수

	static void wkdgksrjf(int idx, int cnt) {

		// 끝까지 왔을 때 검사를 해야하나?
		if (isOk()) {
			if (ans > cnt)
				ans = cnt;
			return;
		}

		// 이미 구한 값보다 더 약물을 주입하는 경우는 필요없다
		if (ans < cnt)
			return;

		if (idx == D) {
			return;
			// 검사하고 return

		}

		// 약품 주입 X
		wkdgksrjf(idx + 1, cnt);

		// 원본을 저장해놓자
		int[] tmp = new int[W];// 원상복귀를 위해서 저장하자
		for (int i = 0; i < W; i++) {
			tmp[i] = film[idx][i];
		}

		// A약품 주입
		for (int i = 0; i < W; i++) {
			film[idx][i] = 0;
			wkdgksrjf(idx + 1, cnt + 1);
		}

		// B약품 주입
		for (int i = 0; i < W; i++) {
			film[idx][i] = 1;
			wkdgksrjf(idx + 1, cnt + 1);
		}

		// 원상복구를 해놓자
		for (int i = 0; i < W; i++) {
			film[idx][i] = tmp[i];
		}
	}

	// 통과 기준을 확인을 하자
	private static boolean isOk() {
		// 열을 고정하고 행을 확인
		// 열만큼 반복
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			boolean flag = false;
			// 내 이전값과 비교할 거니까 1부터 시작함
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c])// 이전과 일치하면 카운트 누적
					cnt++;
				else // 이전과 불일치하면 새롭게 출발
					cnt = 1;
				// 기준치를 넘겼다면
				if (cnt >= K) {
					flag = true;
					break;
				}
			} // 이번 열 검사 끝
				// flag가 false라면 (하나의 열이라도 통과 못했다면 나머지 열을 검사할 필요가 없으니까 바로 리턴)
			if (!flag)
				return false;
		}
		return true; // 위 과정에서 걸러지지 않았다면 기준을 통과한거야
	}// isOk

	static void injection(int idx, int num) {
		for (int i = 0; i < W; i++) {
			film[idx][i] = num;
		}
	}
}
