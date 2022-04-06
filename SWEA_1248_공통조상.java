package SWEA;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {
	static int[] arr;
	static int cnt;
	static List<Integer> treelist;
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input1248.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 입력받는 수를 배열로 생성
			arr = new int[2 * e + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 2 * e; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 2차원 배열 트리 생성
			tree = new int[v + 1][2];
			for (int i = 1; i < arr.length; i += 2) {
				if (tree[arr[i]][0] == 0) {
					tree[arr[i]][0] = arr[i + 1];
				} else {
					tree[arr[i]][1] = arr[i + 1];
				}
			}

			cnt = 0;

			// 공통 조상 찾기
			List<Integer> listA = findParents(a);
			List<Integer> listB = findParents(b);
			int parent = 1;

			outer: for (int i = 0; i < listA.size(); i++) {
				for (int j = 0; j < listB.size(); j++) {
					if ((int) listA.get(i) == (int) listB.get(j)) {
						parent = listA.get(i);
						break outer;
					}
				}
			}

			// 서브트리 크기 찾기
			findSize(parent);

			System.out.println("#" + tc + " " + parent + " " + cnt);
		}

	}

	// 조상 찾는 함수
	private static List<Integer> findParents(int a) {
		List<Integer> list = new ArrayList<>();
		// 루트에 도착할때 까지 반복문
		while (a > 1) {
			// 배열의 짝수번째 값이 자식 -> 자식에 접근해야 하므로 i가 2부터 2씩 증가
			for (int i = 2; i <= arr.length; i += 2) {
				// 자식 찾았다..!
				if (arr[i] == a) {
					// 그 앞의 값이 조상 -> 조상을 list에 추가
					list.add(arr[i - 1]);
					a = arr[i - 1];
					break;
				}
			}
		}
		return list;
	}

	// VLR
	static void findSize(int idx) {
		cnt++; // 카운트 증가

		if (tree[idx][0] != 0) // 왼쪽 자식
			findSize(tree[idx][0]);

		if (tree[idx][1] != 0) // 오른쪽 자식
			findSize(tree[idx][1]);
	}

}