package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4047_영준이의카드카운팅2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input4047.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 한 글자씩 쪼개면서 배열 생성
		// 첫 글자는 뽑아내고
		// 두 세글자는 숫자로 만들어준다
		// 네가지 카드 문양과 카운트는 이차원 배열로 저장
		// 첫 글자 S,D,H,C 마다 일차원 배열로 만들어주고 카드 숫자는 인덱스로, 값을 증가시켜 카운트해준다
		// 일차원 배열에 0번째방은 안쓰니까 이걸 카운트해주면 나중에 결과 계산하기 편하다

		for (int tc = 1; tc <= T; tc++) {
			char[] data = sc.next().toCharArray();
			for (int i = 0; i < data.length; i++) {
				char cardshape = data[i];
				int cardnum = (data[++i] - '0') * 10 + (data[++i] - '0');
			}

			System.out.println("#" + tc + " ");
		}
	}
}
