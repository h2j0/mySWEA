package SWEA;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽 먼저 가고 *2
// sb에 배열값 담고
// 오른쪽으로 이동 *2+1

public class SWEA_1231_중위순회 {
	static String[] arr;
	static StringBuilder sb;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			arr = new String[n + 1];
			
			// 배열에 알파벳 담기
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 숫자 버리고
				arr[i] = st.nextToken(); // 알파벳만 담기
			}

			function(1); // 루트에서 함수 호출
			System.out.println("#" + tc + " " + sb);

		}

	}

	static void function(int idx) {
		if (idx > n) // 크기보다 크면 반환
			return;
		function(idx * 2); // 왼쪽 자식
		sb.append(arr[idx]); // 노드 수행
		function(idx * 2 + 1); // 오른쪽 자식

	}

}
