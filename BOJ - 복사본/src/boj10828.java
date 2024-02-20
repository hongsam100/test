import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		

		Stack<String> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			
			if(a.equals("push")) {
				stack.push(st.nextToken());
			} else if(a.equals("pop")) {
				try{System.out.println(stack.pop());}
				catch(Exception e) {System.out.println("-1");}
			}  else if(a.equals("size")) {
				System.out.println(stack.size());
			}  else if(a.equals("empty")) {
				if(stack.isEmpty()) System.out.println("1"); else System.out.println("0");
			}  else {
				try {System.out.println(stack.peek());}
				catch(Exception e) {System.out.println("-1");}
			} 
			
		}
		
	}
}
