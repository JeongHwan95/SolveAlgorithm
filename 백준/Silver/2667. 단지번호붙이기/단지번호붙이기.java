import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

//2667번
// 풀었을 때 기쁨은 얼마 안된다.
// 시간의 대다수는 내가 풀어가는 과정임으로,
// 풀어가는 과정에서 기쁨과 재미를 찾아야 한다.
public class Main{
	
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean flag;
	static int count;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Integer> answer = new ArrayList<>();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				flag = false;
				count=0;
//				dfs(i, j);
				bfs(i, j);
				
				if(flag) {
					answer.add(count);
				}
			}
		}
		
		System.out.println(answer.size());
		Collections.sort(answer);
		answer.forEach(i -> {
			System.out.println(i);
		});
		
	}
	
	
	public static void bfs(int x, int y) {
		if(map[x][y]==0 || visited[x][y]) {
			return;
		}
		
		count++;
		flag=true;
		visited[x][y] = true;
		Integer[] add = {x, y};
		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.add(add);
		
		while(!queue.isEmpty()) {
			
			Integer[] curV = queue.poll();
			
			for(int i=0; i<4; i++) {
			
				int nextX = curV[0] + dx[i];
				int nextY = curV[1] + dy[i];
					
				if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
					continue;
				}
				
				if(!visited[nextX][nextY] && map[nextX][nextY]==1) {
					
					Integer[] newV = {nextX, nextY};
					queue.add(newV);
					visited[nextX][nextY] = true;
					count++;
				}
			}
			
		}
		
	}
	
	
	public static void dfs(int x, int y) {
		
		if(visited[x][y] || map[x][y]==0) {
			return;
		}
		
		visited[x][y] = true;
		flag = true;
		count++;
		
		for(int i=0; i<4; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
				continue;
			}
			
			if(map[nextX][nextY]==1 && !visited[nextX][nextY]) {
				dfs(nextX, nextY);
			}
		}
		
	}
} // end class
