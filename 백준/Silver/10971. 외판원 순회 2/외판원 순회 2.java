import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
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
			visited[i] = true;
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
