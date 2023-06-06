import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Complete
public class Main {

	static int[][] map;
	static boolean[][] check;
	static int num;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static int length;
	
	public static void main(String[] args) throws IOException{
		
		// Receive values
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		length = Integer.parseInt(n);

		// Put elements into map
		map = new int[length][length];
		check = new boolean[length][length];
		for(int i=0; i<length; i++) {
			
			String line = br.readLine();
			String[] arrForLine = line.split(" ");
			for(int j=0; j<length; j++) {
				map[i][j] = Integer.parseInt(arrForLine[j]); 
			} // for
		} // for
	
		
		int answer = 0;
		for(int rain=0; rain<100; rain++) {
			
			// When logic restart, these have to be initialize.
			num = 0;
			check = new boolean[length][length];
			
			for(int x=0; x<length; x++) {
				for(int y=0; y<length; y++) {
					
					if(map[x][y]>rain && !check[x][y]) {
						check[x][y] = true;
						num++;
						dfs(x, y, rain);
						
					} // if
				} // for
				

			} // for
			
//			if(answer < num ) {
//				System.out.println("num, rain: " + num + ", "+ rain);
//			} // if
//			
			answer = answer > num ? answer : num;
		} // for 
		
		System.out.println(answer);
	} // end main

	
	public static void dfs(int x, int y, int rain) {
		
		
		for(int i=0; i<4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			
			if(nextX <= -1 || nextX >= length || nextY <= -1 || nextY >= length) 
				continue;
			
			if(map[nextX][nextY] > rain && !check[nextX][nextY]) {
				check[nextX][nextY] = true;
				dfs(nextX, nextY, rain);
			} // if
		} // for
		
		
		
	} // end dfs(x, y, rain)
} // end class
