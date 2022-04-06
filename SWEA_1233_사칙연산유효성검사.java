package SWEA;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[][] tree = new String[n + 1][];
			for (int i = 1; i <= n; i++) {
				tree[i] = br.readLine().split(" ");
			}
			// 연산자는 자식 2개 가져야 함
			// 말단노드는 숫자만 가능
			int ans = 1;
			for (int i = 1; i <= n; i++) {
				// 노드의 값이 연산자일 때
				if (tree[i][1].equals("+") || tree[i][1].equals("-") || tree[i][1].equals("*")
						|| tree[i][1].equals("/")) {
					if (tree[i].length != 4) {
						ans = 0;
						break;
					}
				} // 말단노드는 숫자만 가능
					// 사이즈가 2인데 연산자 노드일 때 break
				if (tree[i].length == 2 && (tree[i][1].equals("+") || tree[i][1].equals("-") || tree[i][1].equals("*")
						|| tree[i][1].equals("/"))) {
					ans = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
}
