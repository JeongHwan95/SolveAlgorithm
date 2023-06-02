import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//Complete
public class Main {
	
	static int graph[][];
	static int row;
	static int column;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static int answerForDfs = 0;
	static boolean arrForDfs[][];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Process first row from user
		String line = br.readLine();
		String[] rowAndColumn = line.split(" ");
		row = Integer.parseInt(rowAndColumn[0]);
		column = Integer.parseInt(rowAndColumn[1]);
		
		
		// Store an array into dataStructure
		graph = new int[row][column];
		
		for(int i=0; i<row; i++) {
			
			line = br.readLine();
			
			for(int j=0; j<column; j++) {
				if(line.charAt(j) == '1') {
					graph[i][j] = 1;
				}
				else {
					graph[i][j] = 0;
				} // if - else
			} // for
		} // for
		
		/*
		// Get an answer by BFS and print it
		int answer = bfs();
		System.out.println(answer);
		*/
		
		// Get an answer by DFS and print it
		bfs();
		
		System.out.println(graph[row-1][column-1]);
		
		br.close();
		
	} // main
	
	
	public static void bfs() {
		
		// Create everthing to be need
		Integer[] arrForQueue;
		boolean[][] arrForChecking = new boolean[row][column];
		Queue<Integer[]> queue = new LinkedList<>();
		arrForQueue = new Integer[] {0, 0};
		queue.add(arrForQueue);
		arrForChecking[0][0] = true;
		
		
		// Circulate an graph
		while(!queue.isEmpty()) {
			
			arrForQueue = queue.poll();
			int x = arrForQueue[0];
			int y = arrForQueue[1];
			
			for(int i=0; i<dx.length; i++) {
				
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
//				System.out.println("nextX: " + nextX);
//				System.out.println("nextY: " + nextY);
				
				
				// Check Whether x and y get out from range of the graph
				if( nextX >= 0 && nextX < row && nextY >= 0 && nextY < column ) {
					
					// check
					// 1. Whether the point already get searched or not
					// 2. The point have a value of 1
					if(arrForChecking[nextX][nextY]==false 
							&& graph[nextX][nextY] >= 1) {
						
						arrForChecking[nextX][nextY] = true;
						graph[nextX][nextY] = graph[x][y] + 1;
						arrForQueue = new Integer[] { nextX, nextY }; 
						queue.add(arrForQueue);
					} // if
				} // if
			} // for circulating dx, dy
		} // while
	} // bfs()	
} // end class

