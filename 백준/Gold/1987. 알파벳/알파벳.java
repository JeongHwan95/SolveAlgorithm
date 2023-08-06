import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] input = new int[2];
	static int[][] map;
	static boolean[] alphabet;
	static boolean[][] visited;
	static int candidate = 0;
	static int answer = 0;
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		{
			int i = 0;
			while(st.hasMoreTokens()) {
				
				input[i] = Integer.parseInt(st.nextToken());
				i++;
			} // while
			
			map = new int[input[0]][input[1]];
			visited = new boolean[input[0]][input[1]];
			alphabet = new boolean[26];
			
		} // block
		
		
		for(int i=0; i<input[0]; i++) {
			
			String line = br.readLine();
			for(int j=0; j<input[1]; j++) {
				
				map[i][j] = (int)line.charAt(j)-65;
			} // for
		} // for
		

		candidate++;
		visited[0][0] = true;
		alphabet[map[0][0]] = true;
		backtracking(0, 0);
		
		System.out.println(answer);
	} // main
	
	public static void backtracking(int x, int y) {
		
		
		for(int i=0; i<4; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			
			if(nextX >= 0 && nextY >= 0 && nextX < input[0] && nextY < input[1]) {
				
				if(visited[nextX][nextY]) continue;
				
				if(alphabet[map[nextX][nextY]]) {
					
					answer = answer > candidate ? answer : candidate;
					
				} else {
					
					alphabet[map[nextX][nextY]] = true;
					visited[nextX][nextY] = true;
					candidate++;
					
					backtracking(nextX, nextY);
					
					alphabet[map[nextX][nextY]] = false;
					visited[nextX][nextY] = false;
					candidate--;
					
					
				} // if - else
				
			} // if
			else {
				
				answer = answer > candidate ? answer : candidate;
			}
		} // for
		
		
	} // backtracking
} // end class