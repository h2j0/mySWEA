package SWEA;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_5249_최소신장트리 {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int V = sc.nextInt();// 정점
			int E = sc.nextInt(); // 간선

			// 간선 배열 저장
			int[][] edges = new int[E][3];

			for (int i = 0; i < E; i++) {
				edges[i][0] = sc.nextInt(); // 시작점
				edges[i][1] = sc.nextInt(); // 끝점
				edges[i][2] = sc.nextInt(); // 가중치
			} // 입력 완

			// 가중치 기준 오름차순 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			p = new int[V + 1]; // 0부터 V까지
			// makeSet
			for (int i = 0; i < V + 1; i++) {
				p[i] = i;
			}

			// mst 만들기
			// 간선 V 개 선택하면 break
			int cost = 0; // 비용 저장
			int cnt = 0; // 간선 선택 개수
			for (int i = 0; i < E; i++) {
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);
				// 조상이 다르면 합치기
				if (px != py) {
					union(px, py);
					cost += edges[i][2];
					cnt++;
				}
				if (cnt == V)
					break;
			}
			System.out.println("#" + tc + " " + cost);
		} // tc

	}// main

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}
