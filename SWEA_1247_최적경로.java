package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1247_최적경로 {
	static int N; // 고객수
	static int[][] dest;// 목적지
	static int[][] result; // 순열 정해졌을때
	static boolean[] visited; // 박문철이
	static int min;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1247.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int[] company = new int[2]; // 회사
			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			int[] home = new int[2]; // 집
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();

			dest = new int[N][2]; // N명의 고객
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					dest[i][j] = sc.nextInt();
				}
			}
			// 입력 완

			visited = new boolean[N]; // 박문철2
			result = new int[N + 2][2]; // perm 결과로 생성되는 배열
			result[0] = company; // 0번째는 회사
			result[N + 1] = home; // 마지막은 집 으로 해놓고 1~N번째만 perm 재귀 돈다
			min = Integer.MAX_VALUE;
			perm(1); // 1부터 perm
			System.out.println("#" + tc + " " + min);
		} // tc
	}// main

	private static void perm(int idx) {
		// 종료조건 - 다 선택했다
		if (idx == N + 1) {
			int dist = 0;
			boolean flag = true;
			for (int j = 0; j < result.length - 1; j++) {
				dist += Math.abs(result[j][0] - result[j + 1][0]); // x좌표
				dist += Math.abs(result[j][1] - result[j + 1][1]); // y좌표
				if (min < dist) { // 계산하고 있는 dist가 min보다 커지면
					flag = false; // flag false 처리하고
					break; // 빠져나간다
				}
			}
			if (flag) // 위에 if문에 안걸리면
				min = dist; // dist값이 최솟값
		}
		for (int i = 0; i < N; i++) {
			// 썼으면 쳐내
			if (visited[i])
				continue;
			result[idx] = dest[i];
			visited[i] = true; // 선택하고
			perm(idx + 1); // 내려가고
			visited[i] = false; // 안선택하고
		}
	} // perm
}