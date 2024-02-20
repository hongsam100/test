import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj5430 {
//	timeover
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int D = 0;
			char[] fx = st.nextToken().toCharArray();
			for(int i = 0; i < fx.length; i++) {
				if(fx[i] == 'D') D++;
			}
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken().replace("[", "").replace("]", "").replace(",", " ");
			String[] arrt = str.split(" ");
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(arrt[i]);
			}
			
			if(N < D) {
				System.out.println("error");
			} else {
				for(int i = 0; i < fx.length; i++) {
					if(fx[i] == 'D'){
						int[] arr2 = new int[arr.length - 1];
						for(int j = 0; j < arr.length-1; j++) arr2[j] = arr[j + 1];
						arr = arr2;
					} else if(fx[i] == 'R'){
						reverse(arr);
					}
				}
				System.out.println(Arrays.toString(arr));
			}
		}
		
	}
	
	
	
	public static int[] reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}
		return arr;
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

	
//	public static int[] delete(int[] arr) {
//		int[] arr2 = new int[arr.length-1];
//		for(int i = 1; i < arr.length; i++) {
//			arr2[i-1] = arr[i];
//		}
//		arr= arr2;
//		System.out.println(Arrays.toString(arr2));
//		return arr;
//	}

}
