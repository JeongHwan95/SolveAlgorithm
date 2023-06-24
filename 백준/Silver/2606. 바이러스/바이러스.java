import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N;
	static int K;
	static boolean[] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화 및 입력 과정
		{	
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			
			visited = new boolean[N+1];
			visited[1] = true;
			map = new int[N+1][N+1];
			
			for(int i=0; i<K; i++) {
				
				String line = br.readLine();
				String[] arrForToken = line.split(" ");
				
				int v1 = Integer.parseInt(arrForToken[0]);
				int v2 = Integer.parseInt(arrForToken[1]);
				
				map[v1][v2] = map[v2][v1] = 1;
			} // for
		} // finish the block
		
		// bfs 
		int count = bfs(1);
		
		// 답을 출력
		System.out.println(count);
	} // end main
	
	public static int bfs(int startPoint) {
		
		int answer = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(startPoint);
		
		
		while(!queue.isEmpty()) {
			
			int intCurrent = queue.poll();
			for(int i=1; i<=N; i++) {
				
				if(map[intCurrent][i] == 1 && !visited[i]) {
					
					visited[i] = true;
					answer++;
					queue.add(i);
				} // if
			} // for
		} // while
		
		return answer;
	} // bfs
} // end class
