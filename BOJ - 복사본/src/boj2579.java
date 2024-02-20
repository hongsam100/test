
//계단 오르기
//연속으로 3계단까지 가능할 때
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] stair = new int[301];
		int[] score = new int[301];

		for (int i = 1; i < 1 + N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		// 꼭대기에서 시작해서 전계단과 전전계단을 비교 후 이동
		// 앞계단이면 다음에는 무조건 전전계단 이용

		score[1] = stair[1];
		score[2] = stair[1] + stair[2];
		score[3] = Math.max(stair[1], stair[2]) + stair[3];

		for (int n = 4; n <= N; n++) {
			score[n] = Math.max(score[n - 3] + stair[n - 1], score[n - 2]) + stair[n];
		}
//		System.out.println(Arrays.toString(stair));
		System.out.println(score[N]);

	}
//6
//40
//40
//20
//1
//20
//5
//
//	65 32 0
//	6 43 10
//	6 4 21
//	6 4 2 0

}
