// 설탕 배달

import java.util.Scanner;

public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1,2,4,7 빼고는 다 가능.
		// 15마다 사이클을 반복함.
		// 15면 3포대(555)
		// 16이면 4포대(5533)
		// 31이면 3+4포대 15(555)+16(5533)
		// 61이면 45(5 9개)+16(5533)
		int N = sc.nextInt();

		if (N < 15) { // 15보다 작으면
			if (N == 1 || N == 2 || N == 4 || N == 7) { // 1247은 불가능
				System.out.println(-1);

			} else {

				start: for (int i = 3; i >= 0; i--) {
					for (int j = 0; j <= 10; j++) {
						int n = N;
						if (n - i * 5 - j * 3 == 0) {
							System.out.println(i + j);
							break start;
						}
					}
				}

			}
		} else { // 15 이상은 이렇게 봄(63: 15*3 + 18)
			int num15 = N / 15;
			N = N - (num15 - 1) * 15;

			// 제일 적게 들려면? 5포대를 많이 들어야함
			// 5포대를 5개부터 빼보고 3포대로 나누어 떨어지는걸 구함
			start: for (int i = 5; i >= 0; i--) {	
				for (int j = 0; j <= 10; j++) {
					int n = N;
					if (n - i * 5 - j * 3 == 0) {
						System.out.println((num15 - 1) * 3 + i + j);
						break start;
					}
				}
			}

		}
	}
}