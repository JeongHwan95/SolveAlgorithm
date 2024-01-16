import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

//2468번
// 풀었을 때 기쁨은 얼마 안된다.
// 시간의 대다수는 내가 풀어가는 과정임으로,
// 풀어가는 과정에서 기쁨과 재미를 찾아야 한다.
public class Main{
	
	static int N;
	static int[][] map;
	static int count;
	static boolean flag;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int answer = 0;
		for(int rain=1; rain<=100; rain++) {
			
			count = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					flag = false;
					
//					bfs(i, j, rain);
					dfs(i, j, rain);
					
					if(flag) {
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int rain) {
		if(map[x][y]<rain || visited[x][y]) {
			return;
		}
		
		flag = true;
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
				continue;
			}
			
			if(!visited[nextX][nextY] && map[nextX][nextY]>=rain) {
				dfs(nextX, nextY, rain);
			}
		}
		
	}
	
	
	
	public static void bfs(int x, int y, int rain) {
		if(map[x][y]<rain || visited[x][y]) {
			return;
		}
		
		flag = true;
		visited[x][y] = true;
		Queue<Integer []> queue = new ArrayDeque<>();
		Integer[] add = {x, y};
		queue.add(add);
		
		while(!queue.isEmpty()) {
			
			Integer[] curV = queue.poll();
			
			for(int i=0; i<4; i++) {
				
				int nextX = curV[0] + dx[i];
				int nextY = curV[1] + dy[i];
				
				if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
					continue;
				}
				
				if(map[nextX][nextY]>=rain && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					Integer[] addV = {nextX, nextY};
					queue.add(addV);
				}
			}
			
		}
		
	}
} // end class
