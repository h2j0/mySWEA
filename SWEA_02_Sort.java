package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_02_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 입력받는 수 개수
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();

			}
			bubbleSort(tc, N, arr);
		}

	}

	static void bubbleSort(int T, int N, int[] arr) {
		for (int i = N - 1; i > 0; i--) {
			// 시작 부터 인접한 값을 비교해야하므로 등호가 생략
			for (int j = 0; j < i; j++) {
				// 인접한 두개의 수 중 앞의 친구가 더 크다면
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		System.out.print("#" + T + " ");
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}
