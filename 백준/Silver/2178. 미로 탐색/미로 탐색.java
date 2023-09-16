import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2178번
public class Main {
	
	static class Position{
		
		int x, y, answer;
		
		Position(int x, int y, int answer){
			this.x = x;
			this.y = y;
			this.answer = answer;
		}
	} // Position
	
	static int N;
	static int M;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			} // for
		} // for
		
		
		int answer = bfs();
		
		System.out.println(answer);
	} // main
	
	public  static int bfs() {
		
		Queue<Position> queue = new ArrayDeque<>();
		visited[0][0] = true;
		queue.add(new Position(0, 0, 1));
		
		while(!queue.isEmpty()) {
			
			Position p = queue.poll();
			int x = p.x;
			int y = p.y;
			int answer = p.answer;
			
//			System.out.println("x, y : " + x + ", " + y);
			
			if(x == N-1 && y == M-1) {
				return answer;
			}
			
			for(int i=0; i<4; i++) {
//				System.out.println("answer : " + answer);
				
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
//				System.out.println("nextX, nextY : " + nextX + " " + nextY);
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M )
					continue;
				
				
				if(!visited[nextX][nextY] && map[nextX][nextY]==1) {
					
//					System.out.println("Check here");
					visited[nextX][nextY] = true;
					queue.add(new Position(nextX, nextY, answer+1));
					
				} // if
			} // for
		} // while
		return 0;
	} // bfs
	
} // end class