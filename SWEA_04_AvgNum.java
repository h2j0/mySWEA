package SWEA;

import java.util.Scanner;

public class SWEA_04_AvgNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) { // 테스트케이스 수만큼 반복
			int sum = 0;
			for (int cnt = 0; cnt < 10; cnt++) { // 입력받는 개수 10개
				sum += sc.nextInt();
			}
			
			// 반올림 round의 입력값은 소수여야함 
			// sum/10.0으로 소수 만들고 round하고 다시 int로 형변환
			int avg = (int) Math.round(sum / 10.0);
			System.out.println("#" + tc + " " + avg);
		}
	}
}
