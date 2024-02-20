import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node11725 {
	int num;
	node11725 left;
	node11725 right;
	int parent;

	node11725() {
	}
}

class num11725 {
	int num1;
	int num2;
	boolean visited;

	public num11725(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		boolean visited = false;
	}
}

public class boj11725 {

	static node11725[] nodes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// node 배열에 번호 부여
		int N = Integer.parseInt(st.nextToken());
		nodes = new node11725[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new node11725();
			nodes[i].num = i;
		}

		Queue<num11725> que = new LinkedList<>(); // 부모-자식 연결하지 않은 쌍을 담아둘 큐

		// node 끼리 부모-자식 연결, 상위 노드부터.
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (num1 == 1 || num2 == 1) {// root 인 노드(node[1])이 있으면 root 메서드로 부모자식 연결
				root(num1, num2); 
			} else if (nodes[num1].parent != 0 || nodes[num2].parent != 0) {
				tree(num1, num2); // 부모가 있는 node[?]가 있으면 tree메서드로 노드쌍 연결
			} else {
				que.offer(new num11725(num1, num2)); // 나머지 노드쌍들은 que에 담음
			}
		}

		// 노드쌍들 하나씩 꺼내어 부모가 있으면 부모-자식 연결, 아니면 다시 que에 넣음
		if (!que.isEmpty()) {
			while (true) {
				num11725 a = que.poll(); // 노드쌍 연결 시도. 부모가 없으면 try를 받고 다시 que에 넣음
				int num1 = a.num1;
				int num2 = a.num2;
				String re = tree(num1, num2);
				if (re.equals("retry")) {
					que.offer(a);
				}

				if (que.isEmpty()) // 노드쌍이 없으면 트리 완성.
					break;
			}
		}
		
		for (int i = 2; i < N + 1; i++) { // node[2~N]까지의 부모 출력
			System.out.println(nodes[i].parent);
		}

	}

	// root메서드: node[1]과 node[?] 비교
	// node[1]이 부모 node[?]는 무조건 자식
	// node[?]는 부모=1임을 기록
	static void root(int num1, int num2) {
		if (num1 == 1) {
			if (nodes[num1].left == null) {
				nodes[num1].left = nodes[num2];
				nodes[num2].parent = num1;
			} else {
				nodes[num1].right = nodes[num2];
				nodes[num2].parent = num1;
			}
		} else {
			if (nodes[num2].left == null) {
				nodes[num2].left = nodes[num1];
				nodes[num1].parent = num2;
			} else {
				nodes[num2].right = nodes[num1];
				nodes[num1].parent = num2;
			}
		}
	}

	// tree메서드: node[?]과 node[??] 비교
	// node[?].parent가 0이 아닌 쪽은 부모가 있다 = 둘 중 node[?]가 부모임 -> node[??]가 자식
	// 둘 다 부모가 없으면 다시 que로 들어감.
	static String tree(int num1, int num2) {
		if (nodes[num1].parent != 0) {
			if (nodes[num1].left == null) {
				nodes[num1].left = nodes[num2];
				nodes[num2].parent = num1;
			} else {
				nodes[num1].right = nodes[num2];
				nodes[num2].parent = num1;
			}
			return "";
		} else if (nodes[num2].parent != 0) {
			if (nodes[num2].left == null) {
				nodes[num2].left = nodes[num1];
				nodes[num1].parent = num2;
			} else {
				nodes[num2].right = nodes[num1];
				nodes[num1].parent = num2;
			}
			return "";
		} else
			return "retry";
	}

}
