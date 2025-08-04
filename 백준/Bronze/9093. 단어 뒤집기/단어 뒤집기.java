

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[][] arr = new String[n][500];
		StringBuffer sb = new StringBuffer();
		
		
		for(int i = 0; i < n; i++) {
			String text = br.readLine();
			arr[i] = text.split(" ");
			
			// j가 의미하는 건 배열의 j번째 단어
			for(int j=0; j < arr[i].length; j++) {
				List<Character> stack = new ArrayList<Character>(); 

				for(int k = 0; k < arr[i][j].length(); k++) {
					stack.add(arr[i][j].charAt(k));
				}//for
				
				
				int size = stack.size();
				for(int m = 0; m < size; m++) {
					sb.append(stack.remove(stack.size()-1));
					
				}//for
				sb.append(" ");
			}//for
			sb.append("\n");
		}//for
		
		System.out.println(sb.toString());
	}//main
}//end class
