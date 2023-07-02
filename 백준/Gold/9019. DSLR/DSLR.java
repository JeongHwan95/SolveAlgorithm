import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int finishedValue;
	static StringBuffer sb;
	static boolean[] visited;
	static String answers;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		sb = new StringBuffer();
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int startedValue = Integer.parseInt(st.nextToken());
			finishedValue = Integer.parseInt(st.nextToken());
			answers = "";
			
			bfs(startedValue);
			sb.append(answers);
			sb.append("\n");
			
		} // for
		
		// 답을 출력
		System.out.println(sb.toString());
		
	} // end main
	
	public static void bfs(int start) {
		
		visited = new boolean[10001];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start, ""));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			
			Node currNode = queue.poll();
			String answer = currNode.answer;
			
			int dNode = currNode.D();
			int sNode = currNode.S();
			int lNode = currNode.L();
			int rNode = currNode.R();
			
			if(!visited[dNode]) {
				
				if(dNode==finishedValue) {
					answers = answer + "D";
					return;
				} 
				
				visited[dNode] = true;
				queue.add(new Node(dNode, answer + "D"));
			} // if
			
			if(!visited[sNode]) {
				
				if(sNode==finishedValue) {
					answers = answer + "S";
					return;
				}
				
				visited[sNode] = true;
				queue.add(new Node(sNode, answer + "S"));
			} // if
			
			if(!visited[lNode]) {
				
				if(lNode==finishedValue) {
					answers = answer + "L";
					return;
				}
				
				visited[lNode] = true;
				queue.add(new Node(lNode, answer + "L"));
			} // if
			
			if(!visited[rNode]) {
				
				if(rNode==finishedValue) {
					answers = answer + "R";
					return;
				}
			
				visited[rNode] = true;
				queue.add(new Node(rNode, answer + "R"));
			} // if
		} // while
	} // bfs
	

} // end class
class Node{
	int currLocation;
	String answer;
	
	Node(int currLocation, String answer){
		
		this.currLocation = currLocation;
		this.answer = answer;
	} // end Constructor
	
	int D(){
		
		return (currLocation*2)%10000;
	} // D
	
	int S() {
		
		return currLocation == 0 ? 9999 : currLocation-1;
	} // S
	
	int L() {
		
		return currLocation/1000 + (currLocation-((currLocation/1000)*1000))*10;
	} // L
	
	int R() {
		
		return currLocation%10*1000 + currLocation/10;
	} // R
} // end Node class
