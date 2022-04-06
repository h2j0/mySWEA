package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_05_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;// 테스트 케이스는 10개
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt(); // 테케당 입력받는 개수

			// 배열 생성
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			// 앞에 두 개는 0이니까 2번부터 시작
			int idx = 2;

			while (idx < N - 2) {
				// 이전 두개값이랑 이후 두개값 비교해서 자신이 가장 크면
				if (arr[idx] > arr[idx - 1] && arr[idx] > arr[idx - 2]) {
					if (arr[idx] > arr[idx + 1] && arr[idx] > arr[idx + 2]) {
						ans += myFunc(idx, arr); // 함수 리턴값을 ans에 더해준다
					}
				}
				idx++;

			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	// 주변 값 중 max값에서 내 값을 빼면 조망권 확보된 세대수
	static int myFunc(int idx, int[] arr) {
		int max = 0;
		for (int i = idx - 2; i <= idx + 2; i++) {
			if (i != idx && arr[i] > max) {
				max = arr[i];
			}
		}
		return arr[idx] - max;
	}
}
