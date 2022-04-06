package SWEA;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1940_가랏RC카 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1940.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int v = 0;
			int d = 0;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int a;
				switch (x) {
				case 0:
					d += v;
					break;
				case 1:
					a = sc.nextInt();
					v += a;
					d += v;
					break;
				case 2:
					a = sc.nextInt();
					if (a > v) {
						v = 0;
					} else {
						v -= a;
					}
					d+=v;
					break;
				}

			}

			System.out.println("#" + tc + " " + d);
		}
	}
}
