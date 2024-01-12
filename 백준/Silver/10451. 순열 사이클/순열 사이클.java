import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2178번
public class Main{
	
	static int count;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			StringTokenizer st = new StringTokenizer( br.readLine());
			for(int j=1; j<map.length; j++) {
				map[j][Integer.parseInt(st.nextToken())] = 1;
			}
			
			count = 0;
			visited = new boolean[N+1];
			for(int j=1; j<map.length; j++) {
				flag = false;
				dfs(j);
				
				if(flag)
					count++;
			} // for
			
			System.out.println(count);
		} // testcase For문
	}
	
	public static void dfs(int v) {
		if(!visited[v]) {
			flag = true;
			visited[v] = true;
		}else {
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
} // end class
