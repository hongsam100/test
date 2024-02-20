import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split("");
		List<String> list = new ArrayList<>(Arrays.asList(arr));

		System.out.println(list.toString());//입력확인용
		
		while(!(list.isEmpty()) ) {
			for(int i = 0; i < list.size() - 1; i++) {
				if(!(list.get(i).equals("(")) & (list.get(i+1).equals(")"))) {
					continue;
				} else {
					list.remove(i);
					list.remove(i);
					System.out.println(list.size()); // 출력확인용
				}
					
			}
		}
		System.out.println("YES");
		
	
	}
}