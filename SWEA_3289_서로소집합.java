package SWEA;
import java.util.Scanner;

public class SWEA_3289_서로소집합 {

	static int[] p;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt(); // 노드 수
			int M = sc.nextInt(); // 간선 수

			p = new int[N + 1];
			rank = new int[N + 1];

			// makeSet
			for (int i = 0; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				int calc = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				switch (calc) {
				case 0:
					union(a, b);
					break;
				case 1:
					if (findSet(a) == findSet(b))
						sb.append(1);
					else
						sb.append(0);
					break;
				}
			}
			sb.append("\n");
		} // tc
		System.out.println(sb);
	}// main

	// 대장 찾기
	public static int findSet(int x) {
		if (x != p[x])
			return p[x] = findSet(p[x]);
		return p[x];
	}

	// 합치기
	public static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		if (rank[x] > rank[y])
			p[y] = x;
		else {
			p[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}

	}
}
