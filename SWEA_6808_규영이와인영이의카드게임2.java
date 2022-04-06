package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임2 {
	static int N = 9;
	static int[] kCard; // 규영이 카드
	static List<Integer> iCard; // 인영이 카드
	static int[] totCard; // 1부터 18까지 카드
	static boolean[] visited;
	static int[] res;
	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			totCard = new int[19];
			kCard = new int[9];
			iCard = new ArrayList<>();
			for (int i = 0; i <= 18; i++) {
				totCard[i] = i;
			} // 총 카드 입력

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				kCard[i] = tmp;
				totCard[tmp] = 0;
			} // 규영카드입력 동시에 총 카드 배열의 값을 0으로 변경

			for (int i = 1; i <= 18; i++) {
				if (totCard[i] != 0)
					iCard.add(totCard[i]);
			}
			// 인영이 카드 입력

			visited = new boolean[N];
			res = new int[N];
			win = 0;
			lose = 0;
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		} // tc
	}// main

	static void perm(int idx) {
		if (idx == 9) {
			// 카드 완성
			int kScore = 0;
			int iScore = 0;
			for (int i = 0; i < N; i++) {
				if (kCard[i] > res[i]) {
					kScore += (kCard[i] + res[i]);
				} else
					iScore += (kCard[i] + res[i]);
			}
			win += kScore > iScore ? 1 : 0;
			lose += kScore > iScore ? 0 : 1;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			res[idx] = iCard.get(i);
			visited[i] = true; // 썼어
			perm(idx + 1); // 내려가
			visited[i] = false; // 안썼어
		}
	}

}
