import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//가장 큰 증가하는 부분 수열
public class boj11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] arr = new int[N][2];
		// 0줄: 배열
		// 1줄: 수열sum
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}

		arr[0][1] = arr[0][0];

		for (int i = 1; i < N; i++) { // 나보다 작은 수가 있는 자리의 합의 max+나
			
				int max = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i][0] > arr[j][0]) {
						if (arr[j][1] > max) {
							max = arr[j][1];
						}
					}
				}
				arr[i][1] = max + arr[i][0];
			
		}
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			sum[i] = arr[i][1];
		}
//		System.out.println(Arrays.toString(sum));
		Arrays.sort(sum);
		System.out.println(sum[N - 1]);
	}
}

//6
//1 8 2 3 10 8