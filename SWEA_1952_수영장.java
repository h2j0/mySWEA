package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1952_수영장 {
	static int[] price;
	static int[] monCost;
	static int min;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1952.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4]; // 이용권
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			int[] mon = new int[12];// 이용 횟수
			for (int i = 0; i < 12; i++) {
				mon[i] = sc.nextInt();
			}
			// 입력 완

			monCost = new int[12]; // 한달 이용금액
			int num = price[1] / price[0];// 한달 이용권이 일일 이용권보다 싸지는 횟수
			for (int i = 0; i < 12; i++) {
				monCost[i] = mon[i] >= num ? price[1] : mon[i] * price[0];// 한달 이용권 or 일일 이용권 결정
			}

			min = price[3]; // 1년 이용권
			findCost(0, 0);

			System.out.println("#" + tc + " " + min);

		} // tc
	}// main

	private static void findCost(int idx, int sum) {
		// 종료시점
		if (idx >= 12) {
			if (min > sum) {
				min = sum;
			}
			return;
		}
		// 중간에 min보다 커지면 return
		if (sum > min) {
			return;
		}
		// 한달짜리 세달짜리 선택
		findCost(idx + 1, sum + monCost[idx]);
		findCost(idx + 3, sum + price[2]);
	}

}
