package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	static int[] clerk;
	static int N;
	static int B;
	static boolean[] sel;
	static int sum;
	static int min;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1486.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			clerk = new int[N];
			for (int i = 0; i < N; i++) {
				clerk[i] = sc.nextInt();
			}
			sel = new boolean[N];
			min = Integer.MAX_VALUE;
			powerset(0);

			System.out.println("#" + tc + " " + (min - B));
		} // tc
	}// main

	public static void powerset(int k) {
		// base case
		if (k == N) {
			sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += clerk[i];
				}
			}
			if (sum >= B && min > sum)
				min = sum;
			return;
		}
		// recursive case
		sel[k] = true; // 뽑고
		powerset(k + 1);
		sel[k] = false; // 안뽑고
		powerset(k + 1);

	}// powerset
}
