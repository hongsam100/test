import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());// 가로
		int h = Integer.parseInt(st.nextToken());// 세로

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());	//가로
		int c = Integer.parseInt(st.nextToken());	//세로
		int time = Integer.parseInt(br.readLine());

		r = r + time;
		int rRemainder = r % w;
		int rShare = (r - rRemainder) / w;
		
		if (rShare % 2 == 0) {
			r = rRemainder;
		} else
			r = w - rRemainder;
		
		c = c + time;
		int cRemainder = c % h;
		int cShare = (c - cRemainder) / h;

		if (cShare % 2 == 0) {
			c = cRemainder;
		} else
			c = h - cRemainder;

		System.out.printf("%d %d", r, c);

	}
}

//6 4
//5 3
//4
//
//6 4
//4 1
//8

// 이것도 되긴 함
////int[][] arr = new int[w + 1][h + 1];
//int dirr = 1;
//int dirc = 1;
////arr[r][c] = 1;
//for (int i = 0; i < time; i++) {
////	arr[r][c] = 0;
//	r = r + dirr;
//	c = c + dirc;
//	if (r > w || r < 0) {
//		dirr = dirr * (-1);
//		r = r + dirr * 2;
//	}
//	if (c > h || c < 0) {
//		dirc = dirc * (-1);
//		c = c + dirc * 2;
//	}
////	arr[r][c] = 1;
//}