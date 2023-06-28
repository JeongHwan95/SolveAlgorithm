import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Tomato{
	
	int x;
	int y;
	
	Tomato(int x, int y){
		this.x = x;
		this.y = y;
	} // constructor;
} // Tomato

public class Main {
	
	static int[][] map;
	static int countDay;
	static int M, N;
	static int ripenTomato;
	static int totalTomato;
	static ArrayDeque<Tomato> arrayDeque;
	static Map<Tomato, Integer> ripenDay;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		
		// The Block
		{	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arrayDeque = new ArrayDeque<>();
			ripenDay = new HashMap<>();
			ripenTomato = 0;
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			totalTomato = M*N;
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					
					int currTomato = Integer.parseInt(st.nextToken());
					if(currTomato == 1) {
						
						ripenTomato++;
						
						arrayDeque.addLast(new Tomato(i, j));
						ripenDay.put(arrayDeque.peekLast(), 0);
					} // if
					else if(currTomato == -1) {
						totalTomato--;
					}
					map[i][j] = currTomato;
				} // for
			} // for
			
			countDay = 0;
		} // block
		
		// BFS
		int answer = bfs();
		
		// Print the answer
		System.out.println(answer);
		
	} // main
	
	public static int bfs() {
		
		// 날들이 지나고 토마토가 다 익은 상황
		{
			int hello = 0;
			
			// 토마토가 다 익으면 탈출한다.
			while(!arrayDeque.isEmpty()) {
				
				if(ripenTomato == totalTomato) {
					
					return countDay; 
				} // if
				
				Tomato tomato = arrayDeque.pollFirst();
				int currX = tomato.x;
				int currY = tomato.y;
				int currDay = ripenDay.get(tomato);
//				System.out.println("Hello, countDay : " + hello++ + ", " 
//				+ currDay + ", " + currX + ", " + currY);
				
				for(int i=0; i<4; i++) {
					
					int nextX = currX + dx[i];
					int nextY = currY + dy[i];
					
					if(nextX<N && nextY<M && nextX>=0 && nextY>=0) {
//						System.out.println("Hello, countDay+1 : " + hello++ + ", " 
//						+ (currDay+1) + ", " + nextX + ", " + nextY);
						if(map[nextX][nextY]==0) {
							
							map[nextX][nextY] = 1;
							arrayDeque.addLast(new Tomato(nextX, nextY));
							ripenDay.put(arrayDeque.peekLast(), currDay+1);
//							System.out.println("currDay+1 : "+(currDay+1));
							countDay = currDay+1;
							ripenTomato++;
						} // if
					} // if
				} // for
			} // while
		} // block
		
		// queue를 다 돌았지만 토마토가 다 익지 못한 상황
		return -1;
	} // bfs()
} // class
