import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		}
		
		visited = new boolean[N+1];
		int answer = 0;
		for(int i=1; i<N+1; i++) {
			flag = false;
			bfs(i);
			
			if(flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void bfs(int v) {
		if(visited[v]) {
			return;
		}
		
		
		flag = true;
		visited[v] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		
		while(!queue.isEmpty()) {
			
			int curV = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!visited[i] && map[curV][i] == 1) {
					visited[i]= true;
					queue.add(i);
				}
			}
		}
	}
	
	
}




















//public class BackJoon11724 {
//
//	static int N;	// 정점 개수
//	static int M; 	// 간선 개수
//	static int map[][];
//	static boolean check[];
//	static int connectedComponent;
//	
//	public static void main(String[] args) throws IOException{
//		
//		// Receive the number of Vertex and edge
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String receive = br.readLine();
//		String[] arrForReceive = receive.split(" ");
//		N = Integer.parseInt(arrForReceive[0]);
//		M = Integer.parseInt(arrForReceive[1]);
//		
//		// Initialize
//		map = new int[N+1][N+1];
//		check = new boolean[N+1];
//		connectedComponent = 0;
//		
//		// Receive element into map[][]
//		for(int i=0; i<M; i++) {
//			
//			receive = br.readLine();
//			arrForReceive = receive.split(" ");
//			
//			int x = Integer.parseInt(arrForReceive[0]);
//			int y = Integer.parseInt(arrForReceive[1]);
//			
//			map[x][y] = map[y][x] = 1;
//		} // for
//		
//		// Start searching with dfs
//		{
//			//initialize
//			check = new boolean[N+1];
//			connectedComponent = 0;
//			
//			for(int i=1; i<N+1; i++) {
//				if(!check[i]) {
//					check[i] = true;
//					connectedComponent++;
//					dfs(i);
//				}
//			}
////			System.out.print("dfs: ");
////			System.out.println(connectedComponent);
//		}
//		
//		// Start searching with bfs
//		{
//			//initialize
//			check = new boolean[N+1];
//			connectedComponent = 0;
//			
//			for(int i=1; i<N+1; i++) {
//				if(!check[i]) {
//					bfs(i);
//					connectedComponent++;
//				}
//			} // for
////			System.out.print("bfs: ");
//			System.out.println(connectedComponent);
//		}
//		
//	} // main
//	
//	public static void dfs(int v) {
//		
//		for(int i = 1; i < N+1; i++) {
//			
//			if(!check[i] && map[v][i] == 1) {
//				check[i] = true;
//				dfs(i);
//			} // if
//		} // for
//	} // dfs
//	
//	public static void bfs(int v) {
//		
//		
//		Deque<Integer> queue = new LinkedList<>();
//		queue.addLast(v);
//		check[v] = true;
//		
//		while(!queue.isEmpty()) {
//			
//			int currentVertex = queue.pollFirst();
//			
//			for(int i=1; i<N+1; i++) {
//				if(!check[i] && map[currentVertex][i] == 1) {
//					check[i] = true;
//					queue.addLast(i);
//				} // if
//			}
//		} // while
//		
//	}
//} // end class
