import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 1260번
public class Main {
	
	static int N;
	static int M;
	static int V;
	
	static int map[][];
	static boolean visited[];
	static StringBuffer sb;
	
	public static void main(String[] args) throws IOException{ 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		
		for(int i=1; i<M+1; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		} // for
		
		visited = new boolean[N+1];
		visited[V] = true;
		sb.append(V+" ");
		dfs(V);
		
		visited = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
		
	} // end main
	
	
	public static void dfs(int v) {
		
		
		for(int i=1; i<=N; i++) {
			
			if(!visited[i] && map[i][v]==1) {
				visited[i]=true;
				sb.append(i+" ");
				dfs(i);
			} // if
		} // for
	} // dfs
	
	
	public static void bfs(int v) {
		
		visited[v] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			sb.append(x+" ");
			
			for(int y=1; y<N+1; y++) {
				
				if(!visited[y] && map[x][y] == 1) {
					
					visited[y] = true;
					queue.add(y);
					
				} // if
			} // for
		} // while
		
	} // bfs
} // end class