import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int length;
	static int[][] map;
	static boolean[][] check;
	static int count;
	static List<Integer> countList = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String len = br.readLine();
		length = Integer.parseInt(len);
		map = new int[length][length];
		check = new boolean[length][length];
		
		// Complete to input elements into map 
		for(int i=0; i<length; i++) {
			
			String line = br.readLine();
			for(int j=0; j<length; j++) {
				
				if(line.charAt(j) == '0') {
					map[i][j] = 0;
				}
				else {
					map[i][j] = 1;
				} // if - else
			} // for
		} // for

		
		// Get counts as searching map through DFS
		for(int row = 0; row < length; row++) {
			for(int column = 0; column < length; column++) {
				
				count = 0;
				if(map[row][column] == 1 && check[row][column] == false) {
					count++;
					dfs(row, column);
				} // if
				
				// Get a count if count is not 0
				if(count != 0) {
//					System.out.println("row, column, count : " + row + ", " + column + ", " + count);
					countList.add(count);
				} // if
			} //for
		} // for
		
		
		// print answers
		Collections.sort(countList);
		System.out.println(countList.size());
		for(int answer : countList) {
			System.out.println(answer);
		} // for
		
		br.close();
		
	} // end main
	
	
	public static void dfs(int row, int column) {
//		System.out.println("dfs( " +row +", "+column + " )");
		check[row][column] = true;
		
		for(int i=0; i<4; i++) {
			
			int nextX = row + dx[i];
			int nextY = column + dy[i];
			
			
			if(nextX >= length || nextY >=length || nextX <= -1 || nextY <=-1) 
				continue;
			
			if(map[nextX][nextY] == 1 && check[nextX][nextY] == false ) {
				count++;
				dfs(nextX, nextY);
			} // if
		} // for
	} // dfs
	
} // end class
