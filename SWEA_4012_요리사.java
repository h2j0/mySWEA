package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int[][] ingredient;
	static boolean[] choice;
	static int[] sel;
	static int A, B;
	static int ans;
	static int minAns;
	static int[] index;
	static int N, R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			ingredient = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			index = new int[N];
			for (int i = 0; i < N; i++) {
				index[i] = i;
			}
			choice = new boolean[N];
			sel = new int[R];
			minAns = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + tc + " " + minAns);
		} // tc

	}// main

	// nCr
	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			A = 0;
			B = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (choice[i] && choice[j]) {
						A += ingredient[i][j];
					} else if (!choice[i] && !choice[j]) {
						B += ingredient[i][j];
					}
				}
			}
			ans = Math.abs(A - B);
			if (minAns > ans)
				minAns = ans;

			return;
		} else if (idx == N) {
			return;
		}
		sel[sidx] = index[idx];
		choice[idx] = true;
		comb(idx + 1, sidx + 1); // 뽑고
		choice[idx] = false;
		comb(idx + 1, sidx); // 안뽑고
	}
}
