import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class nodePair11725_2 {
	int num1;
	int num2;
	int visited;

	public nodePair11725_2(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		visited = 0;
	}
}

public class boj11725_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// node 배열에 번호 부여
		int N = Integer.parseInt(st.nextToken());
		int parent[] = new int[N + 1];
		Queue<nodePair11725_2> que = new LinkedList<>();

		// node 끼리 부모-자식 연결, 상위 노드부터.
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (num1 == 1 || num2 == 1) {// root 인 노드(node[1])이 있으면 root 메서드로 부모자식 연결
				if (num1 == 1) {
					parent[num2] = 1;
				} else {
					parent[num1] = 1;
				}
			} else {
				que.offer(new nodePair11725_2(num1, num2)); // 나머지 노드쌍들은 que에 담음
			}
		}
		
		while (!que.isEmpty()) {
			nodePair11725_2 n = que.poll();
			int num1 = n.num1;
			int num2 = n.num2;
			if (parent[num1] != 0 || parent[num2] != 0) {
				n.visited = 1;
				if (parent[num1] != 0 && parent[num2] == 0) {
					parent[num2] = num1;
				} else if (parent[num2] != 0 && parent[num1] == 0) {
					parent[num1] = num2;
				}
			}
			if (n.visited == 0) {
				que.offer(n);
			}
		}

//		System.out.println(Arrays.toString(parent));
		for (int i = 2; i < N + 1; i++) { // node[2~N]까지의 부모 출력
			System.out.println(parent[i]);
		}

	}
}
