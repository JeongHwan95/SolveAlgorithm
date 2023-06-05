import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int power;
//	static int[] check = new int[3333333];
    // I think using HashMap is more adequate that arr in this quiz
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int element = Integer.parseInt(st.nextToken());
		power = Integer.parseInt(st.nextToken());
		
//		check[element] = 1;
		map.put(element, 1);
		System.out.println(dfs(element, 1));
		
	} // main
	
	public static int getNext(int element) {
		
		int next = 0;
		while(element>0) {
			
			next += Math.pow( element%10, power);
			
			element /= 10;
		} // while
		
//		System.out.print(next + " ");
		return next;
		
	} // next
	
	// Get nextNode using getNext() function 
	// If the value already exist in check[nextNode], return check[nextNode] -1
	// If not, call oneself
	public static int dfs(int element, int cnt) {
		
		
		int next = getNext(element);
		
		
		if(map.containsKey(next)) {
				return map.get(next) - 1;
			}
		else {
			map.put(next, ++cnt);
			
			return dfs(next, cnt);
		} // if - else	
	} // dfs(int, int)
	
} // end class
