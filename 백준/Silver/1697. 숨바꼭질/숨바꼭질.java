import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//1697번
// 풀었을 때 기쁨은 얼마 안된다.
// 시간의 대다수는 내가 풀어가는 과정임으로,
// 풀어가는 과정에서 기쁨과 재미를 찾아야 한다.
public class Main{
	
	static int N, K;
	static int[] street;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		street = new int[100001];
		int answer = bfs(N, K);
		System.out.println(answer);
		
	}
	
	public static int bfs(int n, int k) {
		int time = 0;
		if(n == k)
			return time;
		else {
			
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(n);
			
			while(!queue.isEmpty()) {
				
				int curX = queue.poll();
				
				if(curX==k)
					return street[curX];
				
				int x1 = curX+1;
				int x2 = curX-1;
				int x3 = curX*2;
				
			
				if(x1<100001 && street[x1]==0) {
					queue.add(x1);
					street[x1]=street[curX]+1;
				}
				if(x2>=0 && street[x2]==0 ) {
					queue.add(x2);
					street[x2]=street[curX]+1;
				}
				
				if(x3<100001 && street[x3]==0) {
					queue.add(x3);
					street[x3]=street[curX]+1;
				}
			}
		}
		return -1;
	}
} // end class
