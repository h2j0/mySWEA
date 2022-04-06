package SWEA;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input1859.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			} // 입력 완

			long ans = 0; // ans 타입 주의해야 함

			int max = 0;

			// 뒤에서부터 탐색을 하는데
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] < max) { // 내가 max값보다 작다면 그 max값이 매도 시점임
					ans += max - arr[i]; // 따라서 max가 바뀌는 순간 그때 ans에 더해준다
				} else { // 뒤에서부터 나까지 범위에서 내가 max보다 크다면
					max = arr[i]; // 내가 max값이 된다

				}

			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}

