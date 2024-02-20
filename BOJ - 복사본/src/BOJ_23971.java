import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23971 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());	// 행
		int W = Integer.parseInt(st.nextToken());	// 열
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int row = 0;
		int col = 0;
		
		if((H % (N + 1)) == 0) {
			row = (int) Math.floor(H / (N + 1));
		} else { row = (int) Math.floor(H / (N + 1) + 1);}
			
		if((W % (M + 1)) == 0) {
			col = (int) Math.floor(W / (M + 1));
		} else { col = (int) Math.floor(W / (M + 1) + 1);}
		
		System.out.println(row * col);
	}
}
