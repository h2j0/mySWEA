package SWEA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String st = sc.next();
			int[] origin = new int[st.length()];
			for (int i = 0; i < st.length(); i++) {
				origin[i] = st.charAt(i) - '0';
			} // 입력 완

			int now = 0; // 현재 데이터값 - 초기상태가 0이므로 0으로 초기화
			int cnt = 0; // 바뀌는 횟수 cnt

			for (int idx = 0; idx < origin.length; idx++) {
				if ((now ^ origin[idx]) == 1) { // 현재 값이랑 메모리 데이터가 다르면
					cnt++; // 횟수 증가
					now ^= 1; // 현재값은 토글
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // 테케
	}
}
