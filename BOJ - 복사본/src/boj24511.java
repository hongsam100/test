import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj24511 {
	public static void main(String[] args) throws IOException {
		// A줄
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		// B줄: 0101담기
		st = new StringTokenizer(br.readLine());
		Queue<Integer> queB = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queB.offer(Integer.parseInt(st.nextToken()));
		}

		// C줄: 우선 답이 될 B=0인 값들 stack, E에 입력받을 que 크기 설정
		st = new StringTokenizer(br.readLine());
		Stack<Integer> stackC = new Stack<>();
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			if (queB.poll() == 0) {
				stackC.push(c);
			}
		}
		int c = stackC.size();

		// D줄
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		// E줄: (stackC.pop) 하고 stackC - M번 까지 출력
		st = new StringTokenizer(br.readLine());
		Queue<Integer> answer = new LinkedList<>();
		if (M > c) {
			for (int i = 0; i < c; i++) {
				answer.offer(stackC.pop());
			}
			for (int i = 0; i < M - c; i++) {
				answer.offer(Integer.parseInt(st.nextToken()));
			}
		} else {
			for (int i = 0; i < M; i++) {
				answer.offer(stackC.pop());
			}
		}

		// 출력
		int ans = answer.size();
		for (int i = 0; i < ans; i++) {
			sb.append(answer.poll()).append(" ");
		}
		System.out.println(sb);
	}
}

// c줄 초기값은 stack -> 답에 넣기
//2째줄 0크기의 큐 -> 넘치면 답에 넣기
//답끼리 큐 출력
