package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_01_Gravity_Fail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 박스 배열 생성
		int[] boxArr = new int[n];
		int maxIdx = 0; // 가장 높게 쌓이는 높이
		for (int i = 0; i < n; i++) {
			int max = 0;
			boxArr[i] = sc.nextInt();
			maxIdx = Math.max(maxIdx, boxArr[i]);
		}

		// 중력 회전 시킨 후 결과 배열
		int[] resArr = new int[maxIdx];
		for (int i = 0; i < n; i++) {
			for (int idx = 0; idx < boxArr[i]; idx++) {
				resArr[idx]++;
			}
		}
		System.out.println(Arrays.toString(resArr));
		
		// 반복문을 돌면서 뒤에서 나(i)보다 크거나 같은 값(j)을 만나면
		// ((n-1) - 나의 idx = 최대 낙차) - 쌓이는 블록수= 낙차
		// 나보다 큰 값이 없으면 마지막 인덱스 - 나의 idx
		// 최대 낙차는 maxRes
//		int maxRes = 0;
//		int res = 0;
//		for (int i = 0; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				if (boxArr[i] <= boxArr[j]) {
////					res = ;
//					break;
//				} else {
//					res = n - 1 - i;
//				}
//
//			}
//			for (int k = 0; k < n; k++) {
//				resArr[k] = res;
//			}
//
//			if (maxRes < res) {
//				maxRes = res;
//			}
//
//		}
//
//		System.out.println(maxRes);

	}
}
