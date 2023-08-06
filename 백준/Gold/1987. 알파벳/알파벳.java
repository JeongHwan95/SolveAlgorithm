import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = { -1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] map;
	static boolean[] alphabet = new boolean[26];
//	static List<Integer> candidates;
	static int numInFunction;
	static int[] num;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[2];
		
		{
			int i = 0;
			while(st.hasMoreTokens()) {
				
				num[i] = Integer.parseInt(st.nextToken());
				i++;
			} // while
			
			visited = new boolean[num[0]][num[1]];
			map = new int[num[0]][num[1]];
		}
		
		
		for(int i=0; i<num[0] ; i++) {
			
			String line = br.readLine();
			for(int j=0; j<num[1]; j++) {
				
				map[i][j] = (int)line.charAt(j) - 65;
			} // for
		} // for
		
//		candidates = new ArrayList<>();
		numInFunction = 1;
		alphabet[map[0][0]] = true;
		visited[0][0] = true;
		backtracking(0, 0);
		
//		Collections.sort(candidates);
//		System.out.println(candidates.get(candidates.size()-1));
		
		System.out.println(answer);
	} // main
	
	
	public static void backtracking(int x, int y) {
//		System.out.println("int x, int y : " +  x + ", " + y);
//		System.out.println("numInFunction, answer : " + numInFunction + ", " + answer);
		
		
		int nextX, nextY;
		for(int i=0; i<4; i++) {
			
			nextX = x + dx[i];
			nextY = y + dy[i];
			
			
			if(nextX >= 0 && nextY >= 0 && nextX < num[0] && nextY < num[1]) {
				
				if(visited[nextX][nextY]) continue;
				
				if(!alphabet[map[nextX][nextY]]) {
					
					numInFunction++;
					alphabet[map[nextX][nextY]] = true;
					visited[nextX][nextY] = true;

					backtracking(nextX, nextY);
					
					numInFunction--;
					alphabet[map[nextX][nextY]] = false;
					visited[nextX][nextY] = false;
					
				} // if
				else {
					
//					candidates.add(numInFunction);
					answer = answer > numInFunction ? answer : numInFunction;
				} // else
				
			} // if
			else {
				answer = answer > numInFunction ? answer : numInFunction;
			}
		} // for
	} // backtracking
	
	
} // end class
