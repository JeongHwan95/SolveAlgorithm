import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static StringBuffer sb = new StringBuffer();
	static boolean[] arrayForChecking;
	static boolean[][] graph;
	static int N;
	static int M;
	static int V;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String[] information = line.split(" ");
		
		N = Integer.parseInt(information[0]);
		M = Integer.parseInt(information[1]);
		V = Integer.parseInt(information[2]);
		
		
		// Create a dataStructure for receving graph 
		graph = new boolean[N+1][N+1];
		
		
		// Store values of a graph into a dataStructure
		for(int i=1; i<M+1; i++) {
			line = br.readLine();
			String[] xy = line.split(" ");
			
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			
			graph[x][y] = graph[y][x] = true;
		} // for
		
		
		// This block exist for DFS
		{
			// Create an array for checking Whether to be through vertex or not
			arrayForChecking = new boolean[N+1];
					
			// Execute DFS and print it
			Main.dfs(V);
			System.out.println(sb.toString());
		}
		
		// This block exist for BFS
		{
			// Initialize StringBuffer and array for checking
			sb = new StringBuffer();
			arrayForChecking = new boolean[N+1];
			
			Main.bfs(V);
			System.out.println(sb.toString());
		}
	} // main

	
	
	public static void dfs(int start) {
		
		sb.append(start + " ");
		arrayForChecking[start] = true;
		
		for(int i=1; i<N+1; i++) {
			if(arrayForChecking[i]==false && graph[i][start]==true) {

				dfs(i);
			} // if
		} // for
	} // dfs()
	
	public static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		arrayForChecking[start] = true;
		sb.append(start+" ");
		
		
			
		while(!queue.isEmpty()) {
			int currentVertex = queue.poll();
			
			for(int i=1; i<N+1; i++) {
				
				if(graph[currentVertex][i]==true && arrayForChecking[i]==false) {
					queue.add(i);
					arrayForChecking[i] = true;
					sb.append(i+" ");
				} // if
			} // for
		} // while	
	}// bfs
} // end class
