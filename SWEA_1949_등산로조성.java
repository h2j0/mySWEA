package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1949_등산로조성 {
	static class Pos {
		int height, r, c;

		public Pos(int r, int c, int height) {
			this.height = height;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1949.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					
				}
			} // 입력 완 

			List<Pos> topList = new ArrayList<>();
		} // tc
	}// main
}
