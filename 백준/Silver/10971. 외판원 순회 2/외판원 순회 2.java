import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 밑에는 DFS로 어떻게든 풀었고 
// 이번 방식은 백트레킹으로 재구현
public class Main{
	
	static int N;
	static int[][] W;
	static int answer;
	static boolean visited[];
	static int startPoint;
	static int count=0;
	
	
	public static void main(String[] args) throws IOException{
		// Receive inputs
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			N = Integer.parseInt(line);
			
			W = new int[N][N];
			for(int i=0; i<N; i++) {
				
				line = br.readLine();
				String[] arrForLine = line.split(" ");
				for(int j=0; j<N; j++) {
					
					W[i][j] = Integer.parseInt(arrForLine[j]);
				} // for 
			} // for
		} 
		
		// This block for BackTracking
		{
			answer = 2147483647;
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				
				visited[i] = true;
				startPoint = i;
				backTracking(i, 0);
				visited[i] = false;
			} // for
		} 
		
		// This block for printing
		{
			System.out.println(answer);
		} 
	} // end main

	
	
	public static void backTracking(int vertex, int candidate) {
		// 탈출 조건
		{
			boolean flag = false;
			for(int i=0; i<N; i++) {
				
				if(visited[i] == false) {
					
					flag = true;
					break;
				} // if
			} // for
			
			if(!flag) {
				if(vertex != startPoint && W[vertex][startPoint] != 0) {
//					count++;
//					System.out.println(count + ". value : " + (candidate+W[vertex][startPoint]));
					answer = answer > candidate+W[vertex][startPoint] ? candidate+W[vertex][startPoint] : answer;
					visited[vertex] = false;
					return;
				} // if
			} // if
		} // The block
		
		// 조건에 만족할시에 백트레킹으로 시작.
		{
			for(int i=0; i<N; i++) {
				
				if(W[vertex][i] != 0 && !visited[i]) {
					
					visited[i] = true;
					backTracking(i, W[vertex][i]+candidate);
					visited[i] = false;
				} // if
			} // for
		} // The block
	} // end backTracking
} // end class










/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 이유 분석해보기..!
public class BackJoon10971 {
	static List<Integer> listForCandidates = new ArrayList<>();
	static int N;
	static int[][] W;
	static int startPoint;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt( br.readLine() );
		
		
		// Preparing and receive input
		boolean[] visited = new boolean[N];
		W = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			String[] arr = line.split(" ");
			
			for(int j=0; j<N; j++) {
				
				W[i][j] = Integer.parseInt(arr[j]);
			} // for
		} // for
		
		for(int i=0; i<N; i++) {
			
			visited = new boolean[N];
//			visited[i] = true;
			startPoint = i;
			dfs(i, 0, visited);
		} // for
		
		Collections.sort(listForCandidates);
		System.out.println(listForCandidates.get(0));
		
	} // main
	
	
	public static void dfs(int vertex, int candidate, boolean[] arrForVisiting) {
		
		boolean flag = false;
		boolean[] arrForVisiting1 = new boolean[N];
		arrForVisiting1[vertex] = true;
		for(int i=0; i<N; i++) {
			
			if(vertex == i) {
				
			}else {
				arrForVisiting1[i] = arrForVisiting[i];
			}
			if(!arrForVisiting1[i]) {
				flag = true;
			} // if
		} // for
		
		if(!flag) {
			
			if(vertex != startPoint && W[vertex][startPoint] != 0) {
//				System.out.println("vertex, candidate, W[vertex][startPoint], startPoint : " + vertex +", "+candidate + ", " + W[vertex][startPoint] + ", " + startPoint);

				listForCandidates.add(candidate+W[vertex][startPoint]);
			} // if
			return;
		} // if
		else {
			for(int i=0; i<N; i++) {
				if(W[vertex][i] != 0 && !arrForVisiting1[i]) {
//					System.out.println("w["+vertex+"]["+i+"], arrForVisiting[i], candidate : "
//							+ W[vertex][i] + ", " + arrForVisiting[i] + ", " + candidate);
//					arrForVisiting1[i] = true;
					dfs(i, candidate+W[vertex][i], arrForVisiting1);
				} // if
			} // for
		} // else
	} //dfs
} // end class
*/