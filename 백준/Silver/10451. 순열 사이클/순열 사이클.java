import java.io.IOException;
import java.util.Scanner;

//10451
//1, 2, 3, 4, 
public class Main {
	static int[] map;
	static boolean[] check;
	static int cycle;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int test=0; test<t; test++) {
			int n = sc.nextInt();
			cycle = 0;
			
			map = new int[n+1];
			for(int i=1; i<n+1; i++) {
				map[i] = sc.nextInt();
			}
			
			check = new boolean[n+1];
			for(int i=1; i<n+1; i++) {
				while(!check[i]) {
					dfs(i);
					cycle++;
				}
			}
			System.out.println(cycle);
		}
	}
	
	public static void dfs(int start) {
		check[start] = true;
		
		int next = map[start];
		while(!check[next]) {
			dfs(next);
		}
	}
}