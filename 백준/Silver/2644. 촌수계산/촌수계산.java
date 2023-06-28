import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS로 풀다가 DFS가 더 적합하다는 걸 깨닫고 DFS로 다시품..
public class Main {
	
	static int n;
	static int p1, p2;
	static Map<Integer, Integer> map;
	static int numberOfEdge;
	static int countPoint;
	static int[][] arrForMap;
	static boolean[] visited;
	static boolean flag;
	
	
	public static void main(String[] args) throws IOException{
		
		// input 입력받고 초기화 작업
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			p1 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			
			numberOfEdge = Integer.parseInt(br.readLine());
			int x, y;
			arrForMap = new int[n+1][n+1];
			visited = new boolean[n+1];
			countPoint = 0;
			flag = false;
			map = new HashMap<Integer, Integer>();
			for(int i=0; i<numberOfEdge; i++) {
				
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				arrForMap[x][y] = arrForMap[y][x] = 1;
			} // for
		} // The end of the block
		
		// Start DFS
		visited[p1] = true;
		int answer = dfs(p1);
		
		// Print the answer
		System.out.println(answer);
		
	} // main
	
	public static int dfs(int startPoint) {
		
		if(startPoint == p2) {
			flag = true;
			return countPoint;
		} // if
		
		for(int i=1; i<n+1; i++) {
			
			if(arrForMap[startPoint][i]==1 && !visited[i]) {
				visited[i] = true;
				countPoint++;
				dfs(i);
				
				if(flag) {
					return countPoint;
				}
					
					
				countPoint--;
			} // if
		} // for
		
		
		return -1;
	} // dfs
	
	public static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		
		visited[1] = true;
		map.put(start, 1);
		
		while(!queue.isEmpty()) {
			System.out.println(map.toString());
			
			int currentPoint = queue.poll();
			int relationNumber = map.get(currentPoint);
//			System.out.println(relationNumber);
			for(int i=1; i<n+1; i++) {
				if(arrForMap[currentPoint][i]==1 && !visited[i]) {
					map.put(i, relationNumber+1);
					visited[i] = true;
					queue.add(i);
				} // if
			} // for
		} // while
		
	} // end bfs
	
} // end class
