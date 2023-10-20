import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, M, R;
	static int min;
	static int[][] map;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException, InterruptedException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			} // for
		} // for
		
		min = Math.min(N, M);
		
		for(int i=1; i<=R; i++) {
			rotate();
		} // for
		
		print();
	} // main
	
	
	static void rotate() {
		
		for(int t=0; t<min/2; t++) {
			
			int x = t;
			int y = t;
			
			int temp = map[x][y];
			int id = 0;
			
			while(id < 4) {
				
				int nextX = x + dx[id];
				int nextY = y + dy[id];
				
				if(nextX >= t && nextY >= t && nextX < N - t && nextY < M - t) {
					
					map[x][y] = map[nextX][nextY];
					x = nextX;
					y = nextY;
				} // if
				else {
					
					id++;
				} // else
			} // while
			
			map[t+1][t] = temp;
		} // for
		
	} // rotate


	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {

				System.out.print(map[i][j] + " ");
			}
			
			System.out.println();
		}
	} // print
	
	
} // end class
