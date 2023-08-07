import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex{
	int node;
	int value;
	
	public Vertex(int node, int value) {
		
		this.node = node;
		this.value = value;
	}
}

public class Main {
	
	
	static int num;
	static int rel;
	static int[][] map;
	static boolean[] visited;
	static int miniValue = Integer.MAX_VALUE;
	static int numFromBFS;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		rel = Integer.parseInt(st.nextToken());
		map = new int[num+1][num+1];
		
		for(int i=0; i<rel; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		} // for
		
		
		int answer = 1;
		for(int i=1; i<=num; i++) {
			
			visited = new boolean[num+1];
			numFromBFS = bfs(i);
			
			if(miniValue > numFromBFS) {
				miniValue = numFromBFS;
				answer = i;
			}
		} // for
		
		System.out.println(answer);
	} // main
	
	
	public static int bfs(int v) {
	
		Queue<Vertex> queue = new ArrayDeque<>();
		queue.add(new Vertex(v, 0));
		visited[v] = true;
		
		int sum=0;
		while(!queue.isEmpty()) {
//			System.out.println("number : " + ++number);
			
			
			Vertex currVer = queue.poll();
			int curNode = currVer.node;
			int curValue = currVer.value;
			
			for(int i=1; i<num+1; i++) {
				
				if(map[curNode][i]==1 && !visited[i]) {
//					System.out.println("CurrNode, i : " + curNode + ", " + i);
					
					
					visited[i] = true;
					sum += curValue+1;
					queue.add(new Vertex(i, curValue+1));
				} // if
			} // for
			
		} // while
		
		
		return sum;
	} // bfs

	
} // end class
