package SWEA;
import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_7236_저수지의물의총깊이구하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input7236.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 저수지 크기
			String[][] board = new String[N][N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				board[i] = sc.nextLine().split(" ");
			}
			
			int minG = 987654321;
			int cntG = 0;
			int cntW = 0;
			outer: for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < N - 1; c++) {
					cntW = 0;
					cntG = 0;

					for (int i = 0; i < 8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (board[nr][nc].equals("W")) {
							cntW++;
						} else {
							cntG++;
						}
					}
					if (cntW == 8) {
						break outer;
					}
					minG = Math.min(minG, cntG);
				}
			}
			System.out.print("#" + tc + " ");
			if (cntW == 8) {
				System.out.print(8);
			} else if (cntG == 8) {
				System.out.print(1);
			} else {
				System.out.print(8 - minG);
			}
			System.out.println();
		}

	}
}
