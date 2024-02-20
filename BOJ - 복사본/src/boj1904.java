import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1904 {

//	static int factorial(int a) {
//		int num = 1;
//		if (a >= 1) {
//			for (int i = 1; i <= a; i++) {
//				num *= i;
//			}
//		}
//		return num;
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N=5일때 5c0 4c1 3c2

		int ans = 1; // 5C0
		int[][] combinations = new int[N / 2 + 1][2];
		for (int i = 0; i <= N / 2; i++) {
			combinations[i][0] = N - i; // 0행에는 00,1의 수
			combinations[i][1] = i; // 1행에는 00의 수
		}

		for (int i = 1; i <= N / 2; i++) {
			int com = 1;
			int[] dp = new int[combinations[i][0] + 1];
			dp[0] = 1;
			for (int j = 1; j <= combinations[i][1]; j++) {
				dp[j] = dp[j - 1] * (combinations[i][0] - j + 1);
				dp[j] /= j;
			}

//			System.out.println(dp[combinations[i][1]]);
			ans += dp[combinations[i][1]];
		}
//			System.out.println(factorial(N - i) / (factorial(i) * factorial(totalnum - i)));
//			ans += factorial(N - i) / (factorial(i) * factorial(totalnum - i));
//		System.out.println(Arrays.deepToString(combinations));
//		System.out.println(combinations);
		System.out.println(ans);
	}

}

//5
//0 5	1	5c0
//1 3	4	4c1
//2 1	3	3c2