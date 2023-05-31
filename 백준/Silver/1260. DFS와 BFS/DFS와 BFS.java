

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int V;
	
	static int [][]graph;
	static StringBuffer sb;
	
	static boolean []visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();

		String input = br.readLine();
		String []inputArr = input.split(" ");
		
		
		// 정점 갯수
		N = Integer.parseInt(inputArr[0]);
		// 간선 갯수
		M = Integer.parseInt(inputArr[1]);
		// 탐색을 시작할 정점
		V = Integer.parseInt(inputArr[2]);
		
		
		graph = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			String arrS[] = s.split(" ");
			int x = Integer.parseInt(arrS[0]);
			int y = Integer.parseInt(arrS[1]);
			
			graph[x][y] = graph[y][x] = 1;
		}//for
	
		
		visited = new boolean[N+1];
		dfs(V);

		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);

		System.out.println(sb.toString());
	}//main
	
	
	public static void dfs(int V) {
		visited[V] = true;
		sb.append(V+" ");
		
		for(int i = 1; i <= N; i++) {
			if(graph[i][V]==1 && visited[i]==false) {
				dfs(i);
			}//if
		}//for
	}//dfs(int V)
	
	
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		visited[V] = true;
		queue.add(V);
		
		
		while(!queue.isEmpty()) {
			int queueV = queue.poll();
			sb.append(queueV+" ");	
			
			for(int i=1; i<= N; i++) {
				if(visited[i] == false && graph[i][queueV]==1) {
					queue.add(i);
					visited[i] = true;
				}//if
			}//for
		}//while
	}//bfs(int V)
}//class
