import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	static String answer;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		int testCase = Integer.parseInt(t);
		
		sb = new StringBuilder();
		
		
		for(int i=0; i<testCase; i++) {
			
			answer = "";
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
					
			process(count, s);
			
		} // for
		
		System.out.println(sb.toString());
		
		br.close();
	} // main
	
	public static void process(int count, String s) {
		
		for(int i=0; i<s.length(); i++) {
			
			for(int j=0; j<count; j++) {
		
				answer += s.charAt(i);
			} // for
		} // for
		
		sb.append(answer);
		sb.append("\n");
	} // recursive
} // class
