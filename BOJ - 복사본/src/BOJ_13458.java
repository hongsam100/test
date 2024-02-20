import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < N; i++) {
			
			if(!((arr[i] - B) <= 0)) {
				
				if((arr[i] - B) % C == 0) {
					arr[i] = ( arr[i] - B ) / C + 1;
				} else { 
					arr[i] = (int) (Math.floor( (arr[i] - B) / C )  + 2);
				}
				
			} else {arr[i] = 1;}
		}
		
		long sum = 0;
		for(int i = 0; i < N ;i++) {
			sum += (long)arr[i];
		}
		
		System.out.println(sum);
		
		
	}
}
