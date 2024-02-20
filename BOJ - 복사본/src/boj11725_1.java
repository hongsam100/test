import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class nodePair11725 {
	int num1;
	int num2;

	public nodePair11725(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}

public class boj11725_1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// node 배열에 번호 부여
		int N = Integer.parseInt(st.nextToken());
		int nodes[][] = new int[N - 1][3];
		int parent[] = new int[N + 1];

		// node 끼리 부모-자식 연결, 상위 노드부터.
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			nodes[i][0] = Integer.parseInt(st.nextToken());
			nodes[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			if (nodes[i][0] == 1 || nodes[i][1] == 1) {
				nodes[i][2] = 1;
				if (nodes[i][0] == 1) {
					parent[nodes[i][1]] = nodes[i][0];
				} else {
					parent[nodes[i][0]] = nodes[i][1];
				}
			}
		}

		boolean b = true;
		while (b) {
			for (int i = 0; i < N - 1; i++) {
				if ((parent[nodes[i][0]] != 0 || parent[nodes[i][1]] != 0) && nodes[i][2] == 0) {
					nodes[i][2] = 1;
					if (parent[nodes[i][0]] != 0) {
						parent[nodes[i][1]] = nodes[i][0];
					} else {
						parent[nodes[i][0]] = nodes[i][1];
					}
				}
			}

			// node쌍을 다 써봤으면 완료됨. while문 종료
			b = false;
			for (int i = 0; i < N - 1; i++) {
				if (nodes[i][2] == 0) {
					b = true;
				}
			}

		}
		System.out.println(Arrays.toString(parent));
//		for (int i = 2; i < N + 1; i++) { // node[2~N]까지의 부모 출력
//			System.out.println(parent[i]);
//		}

	}

}
