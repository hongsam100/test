import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5430_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			char[] RD = st.nextToken().toCharArray();
			Queue<Character> RD2 = new LinkedList<>(); // RD 큐
			for (int i = 0; i < RD.length; i++) {
				RD2.offer(RD[i]);
			}
			int rd = RD2.size();

			int[] arr = new int[Integer.parseInt(br.readLine())];
			Deque<Integer> deque = new LinkedList<>(); // 숫자열 deque

			String arrStr = br.readLine();
			String[] strArray = arrStr.split("\\[|\\]|,");

			for (int i = 0; i < arr.length; i++) {
				deque.addLast(Integer.parseInt(strArray[i + 1]));
			}
			// 숫자열에 숫자 담기

			int reverse = 0;
			for (int i = 0; i < rd; i++) {
				if (RD2.poll() == 'R') {
					reverse++;
				} else {
					try {
						if (reverse % 2 == 0) {
							deque.remove();
						} else {
							deque.removeLast();
						}
					} catch (Exception e) {
						sb.append("error").append("\n");
						break;
					}
				}

				if (RD2.size() == 0) {
					int dequesize = deque.size();
					if (dequesize == 0) {
						sb.append("[]\n");
					} else {
						if (reverse % 2 == 0) {
							sb.append("[");
							for (int ii = 0; ii < dequesize; ii++) {
								sb.append(deque.poll()).append(",");
							}
							sb.deleteCharAt(sb.length() - 1).append("]\n");

						} else {
							Deque<Integer> list2 = new LinkedList<>();
							while (deque.size() > 0) {
								list2.add(deque.pollLast());
							}

							sb.append("[");
							for (int ii = 0; ii < dequesize; ii++) {
								sb.append(list2.poll()).append(",");
							}
							sb.deleteCharAt(sb.length() - 1).append("]\n");
						}
					}
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}

//4
//RDD
//4
//[1,2,3,4]
//DD
//1
//[42]
//RRD
//6
//[1,1,2,3,5,8]
//D
//0
//[]
