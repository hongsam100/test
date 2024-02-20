import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int last = Integer.MIN_VALUE;
			if(a.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				queue.offer(last); // add:실패시 exception // offer: 실패시 false
			} else if(a.equals("pop")) {
				try{System.out.println(queue.poll());}
				catch(Exception e) {System.out.println(-1);}
			}  else if(a.equals("size")) {
				System.out.println(queue.size());
			}  else if(a.equals("empty")) {
				if(queue.isEmpty()) System.out.println(1); else System.out.println(0);
			}	else if(a.equals("front")) {
				try {System.out.println(queue.peek());}
				catch(Exception e) {System.out.println(-1);}
			}  else if(a.equals("back")) {
				try {System.out.println(last);}
				catch(Exception e) {System.out.println(-1);}
			} 
			
		}
	}
}
