import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] graph;
	static boolean[] arrForChecking;
	static int number;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		
		// Receive testCase
		String testCase = br.readLine();
		int t = Integer.parseInt(testCase);
		
		for(int i=0; i<t; i++) {
			
			// Receive the number of vertexes
			String numberOfElements = br.readLine();
			number = Integer.parseInt(numberOfElements);
			
			// Receive vertexes
			String arrOfElement = br.readLine();
			String[] element = arrOfElement.split(" ");
			
			// Store values into graph[][] with element[]
			// directional : graph[x][y] : x => y
			Main.graph = new int[number+1][number+1];
			for(int j=0; j<number; j++) {
				
				int e = Integer.parseInt(element[j]);
				
				Main.graph[j+1][e] = 1;
			} // for
			
			
			int answer = 0;
			Main.arrForChecking = new boolean[number+1];
			
			for(int j=1; j<number+1; j++) {
				if(Main.arrForChecking[j] == false) {
					answer++;
					dfs(j);
				} //if
			} // for
			sb.append(answer+"\n");
		} // for
		
		System.out.println(sb.toString());
	} // main
	
	
	public static void dfs(int start) {
		
		arrForChecking[start] = true;
		
		
		// Check
		// 1. Whether the vertex gets searched or not
		// 2. Whether the edge exists between vertexes
		for(int i=1; i<number+1; i++) {
			if(graph[start][i] == 1 && Main.arrForChecking[i]==false) {
				dfs(i);
			}//if
		} // for
	} // dfs
} // end class
