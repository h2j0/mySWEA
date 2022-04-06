package SWEA;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in); 
		Scanner sc = new Scanner("5\r\n" + "1\r\n" + "2\r\n" + "11\r\n" + "1295\r\n" + "1692");
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int i = 1;
			int num = 0;
			Set<Integer> setNum = new HashSet<>();
			while (true) {
				num = n * i;
				String strNum = num + "";
				for (int j = 0; j < strNum.length(); j++) {
					setNum.add((int) strNum.charAt(j) - '0');
				}
				if (setNum.size() != 10) {
					i++;
				} else
					break;
			}

			System.out.println("#" + tc + " " + num);
		}

	}

}
