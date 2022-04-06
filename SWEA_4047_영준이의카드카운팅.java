package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input4047.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			char[] cardArr = sc.nextLine().toCharArray();
			int[][] cnt = new int[4][14]; // 스페이드, 다이아, 하트, 클로버 순서
			for (int i = 0; i < cardArr.length; i = i + 3) {
				int num = (cardArr[i + 1] - '0') * 10 + (cardArr[i + 2] - '0');
				switch (cardArr[i]) {
				case 'S': // 스페이드
					cnt[0][num]++;
					break;
				case 'D': // 다이아몬드
					cnt[1][num]++;
					break;
				case 'H': // 하뜨
					cnt[2][num]++;
					break;
				case 'C': // 클로바
					cnt[3][num]++;
					break;
				}
			}

			int sum = 0;
			outer: for (int i = 0; i < 4; i++) {
				int cntcheck = 0;
				for (int j = 1; j < 14; j++) {
					cntcheck += cnt[i][j] == 1 ? 1 : 0;
					if (cnt[i][j] > 1) {
						sb.setLength(0); // sb 초기화
						sb.append("ERROR");
						break outer;
					}

				}
				sb.append(13 - cntcheck + " ");
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
