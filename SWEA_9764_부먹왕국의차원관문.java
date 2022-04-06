package SWEA;
import java.util.Scanner;

public class SWEA_9764_부먹왕국의차원관문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 입력

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int d = sc.nextInt();

			// 0의 개수를 세는 cntZero
			int cntZero = 0;
			// 결과값
			int ans = 0;
			// 도시 입력 받으면서
			for (int i = 0; i < n; i++) {
				if (sc.nextInt() == 0) { // 입력값이 0일 때의 경우의 수를 cnt한다
					cntZero++;
					if (cntZero == d) { // cntZero가 d가 되면 관문을 설치해야 함
						ans++;
						cntZero = 0; // 다시 카운트하기 위해 0으로 초기화
					}
				} else {
					cntZero = 0; // 1인 경우 관문 있는 경우이므로 cntZero초기화해줌
				}

			}

			// 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
