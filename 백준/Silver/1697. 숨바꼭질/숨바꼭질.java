import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	
	static int N;
	static int K;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] arr = line.split(" ");
		
		N = Integer.parseInt(arr[0]);
		K = Integer.parseInt(arr[1]);
		
		if(N == K) {
			System.out.println(0);
		} // if
		else {
			int answer = bfs();
			System.out.println(answer);
		} // else
		
	} // end main
	
	
	// bfs
	public static int bfs() {
		
		Queue<Integer> queue = new LinkedList<>();	
		int[] visited = new int[100001];
		queue.add(N);
		
		// while
		while(!queue.isEmpty()) {
			
			int location = queue.poll();
			
			if(location == K) {
				return visited[location];
			} // if
			
			if(location+1<=100000 && visited[location+1] == 0 && location+1 != N) {
				queue.add(location+1);
				visited[location+1] = visited[location]+1;
			}
			
			if(location*2<=100000 && visited[location*2]==0 && location*2 != N) {
				queue.add(location*2);
				visited[location*2] = visited[location]+1;
			}
			
			if(location-1>=0 && visited[location-1]==0 && location-1 != N) {
				queue.add(location-1);
				visited[location-1] = visited[location]+1;
			}
			
		} // while
		
		return -1; 
		
	} // bfs( int location, int sec ) 
	
} // end class





// 문제가 풀리긴 하는데 메모리 초과
/*
public class BackJoon1697 {
	
	static int N;
	static int K;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] getArr = line.split(" ");
		
		N = Integer.parseInt(getArr[0]);
		K = Integer.parseInt(getArr[1]);
		boolean[] check = new boolean[100001];
		
		
	
		int answer = dfs(N, 0, check);
			
		System.out.println(answer);
	
	} // main
	
	public static int dfs(int location, int second, boolean[] check) {
//		System.out.println("location, second, check[" + location + "] : " + location + ", " + second + ", " + check[location]);
		
		// if meet the condition, return count. 
		if(location+1 == K || location*2 == K || location-1 == K) {
//			System.out.println("location, K in if : " + location + ", " + second);
			return ++second;
		} // if
		
		if(location == K) {
			return second;
		}
		
		
//		System.out.println("After if, location : " + location);
		
		// (1) Prevent from leaping to where already have been by 'check[location] = true'
		// (2) Add one to count
		// (3) List for adding all cases. One of them will be chosen as answer
		check[location] = true;
		second++;
		List<Integer> candidate = new ArrayList<Integer>();
		
		
		// Restrict the range before start leaping 'location+1' or 'location*2'		
		if(location < K) {
			
			// This block is for leaping location+1			
			{
				if(check[location+1]) {
//					System.out.println("check[" + (location+1) + "] : " + check[location+1] );
					candidate.add(2147483647);
				} // if
				else {
					boolean[] check1 = new boolean[100001];
					for(int i=0; i<check.length; i++) {
						check1[i] = check[i];
					} // for
	
					candidate.add(dfs(location+1, second, check1));
				} // else
			} // end block
			
			
			// This block is for leaping location*2			
			{	
				if(check[location*2]) {
//					System.out.println("check[" + (location*2) + "] : " + check[location*2] );
					candidate.add(2147483647);
				} // if
				else {
					boolean[] check2 = new boolean[100001];
					for(int i=0; i<check.length; i++) {
						check2[i] = check[i];
					} // for
					
					candidate.add(dfs(location*2, second, check2));
				} // else
			} // end block
		}
		
		// Restrict the range before start leaping 'location-1'
		if(location > 0) {
			
			// This block is for leaping location-1			
			{
				if(check[location-1]) {
//					System.out.println("check[" + (location+1) + "] : " + check[location+1] );
					candidate.add(2147483647);
				} // if
				else {
					boolean[] check3 = new boolean[100001];
					for(int i=0; i<check.length; i++) {
						check3[i] = check[i];
					} // for
					
					candidate.add(dfs(location-1, second, check3));
				} // else
			} // end block
		}
		
		
		// Sort elements to select the minimum count
		// and return it
		Collections.sort(candidate);
		return candidate.get(0);
		
	} // dfs
} // end class
*/