import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2667번
public class Main{
	
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(1);
		System.out.println(count-1);
	}
	
	public static void dfs(int v) {
		
		visited[v] = true;
		count++;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && map[v][i]==1) {
				dfs(i);
			}
		}
		
	}
} // end class
