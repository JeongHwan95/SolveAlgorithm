import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void  main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Receive the values
		String in = br.readLine();
		String[] a = in.split(" ");
		int multiple = Integer.parseInt(a[1]) ;
		
		// Make list for adding value
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.parseInt(a[0]));
		
		// Get a element through while syntax one by one 
		// and check Whether find a repetitive element or not
		int answer = 0;
		while(true) {
			
			int now = list.get(list.size()-1);
			
			
			int value = 0;
			while( now > 0) {
				
				int next = 1;
				for(int i=0; i<multiple; i++) {
					next*=(now%10);
				} // for
				
				value += next;
				now /= 10;
			} // while
			
			// If a repetitive element exist, flag get a 'true' value through circulating list
			boolean flag = false;
			for(int j = 0; j<list.size(); j++ ) {
				
				if(list.get(j) == value) {
					answer = j;
					flag = true;
					break;
				} // if
			} // for
			
			if(flag == true) {
				break;
			}
			
			list.add(value);
			
		} // while 
		
		
		System.out.println(answer);
		
//		for(int i : list) {
//			System.out.print(i + " ");
//		} // for
		
	} // main
	
} // end class
