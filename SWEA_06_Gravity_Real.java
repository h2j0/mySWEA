package SWEA;


import java.util.Scanner;

public class SWEA_06_Gravity_Real {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();

		// 박스 배열 생성
		int[] boxArr = new int[len];
		for (int i = 0; i < len; i++) {
			boxArr[i] = sc.nextInt();
		}

		int max = 0;
		// cnt는 블록이 가질 수 있는 최대 낙차
		// 자기보다 큰 값을 만나면 cnt를 1씩 빼준다

		for (int i = 0; i < len - 1; i++) {
			int cnt = len - 1 - i;
			for (int j = 1; j < len; j++) {
				if (boxArr[i] <= boxArr[j]) {
					cnt--;
				}
			}
			// 최대 낙차 구하기
			if (max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}
}
