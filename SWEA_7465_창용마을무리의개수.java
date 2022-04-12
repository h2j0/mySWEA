package SWEA;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {
	static int[] p;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 노드 수
			int M = sc.nextInt(); // 간선 수
			
			p = new int[N + 1];
			rank = new int[N + 1];

			// makeSet
			for (int i = 0; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a,b);
			}
			
			// 내가 대장인 애 찾기
			int ans = 0;
			for(int i=1;i<=N;i++) {
				if(i == p[i]) 
					ans++;
			}
				
			System.out.println("#" + tc+ " "+ans);
		} // tc
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
