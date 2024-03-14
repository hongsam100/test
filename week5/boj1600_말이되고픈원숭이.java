

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1600_말이되고픈원숭이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		int[][] visited = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 내려가고 오른쪽으로만 감. 그게 최소기 때문
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[] drr = { 2, 1, 2, 1, -1, -2, -1, -2 };
		int[] dcc = { 1, 2, -1, -2, -2, -1, 2, 1 };

		Queue<Integer[]> que = new LinkedList<>();
		int nr = 0;
		int nc = 0;

		// 좌표와K값만 넣음. 시작점0,0 K값,진행시간 순서로 넣음
		Integer[] a = { 0, 0, K, 0 };
		que.add(a);

		while (!que.isEmpty()) {
			a = que.poll();
			System.out.println(Arrays.toString(a));
			if (a[0] == R - 1 && a[1] == C - 1) {
				System.out.println(a[3]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				nr = a[0] + dr[i];
				nc = a[1] + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] == 0 && visited[nr][nc] == 0) {
					visited[nr][nc] = 1;
					Integer[] b = { nr, nc, a[2], a[3] + 1 };
					que.add(b);
				}
			}
			if (a[2] > 0) {
				for (int i = 0; i < 8; i++) {
					nr = a[0] + drr[i];
					nc = a[1] + dcc[i];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] == 0 && visited[nr][nc] == 0) {
						
						Integer[] b = { nr, nc, a[2] - 1, a[3] + 1 };
						que.add(b);
					}
				}
			}
			if (que.isEmpty()) {
				System.out.println(-1);
			}
		}

	}
}
