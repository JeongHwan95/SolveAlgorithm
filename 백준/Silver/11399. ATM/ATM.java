import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws IOException{
		
		// Declaration
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int[] arr;
		int answer;
		
		// Receive
		{
			String line = br.readLine();
			N = Integer.parseInt(line);
			
			arr = new int[N];
			line = br.readLine();
			String[] arrForLine = line.split(" ");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(arrForLine[i]);
			} //for
		} // block
		
		// Do Selection Sort
		{
			for(int i=N-1; i>0; i--) {
				
				boolean flag = false;
				int maxIndex = i;
				for(int j=i-1; j>=0; j--) {
					
					if(arr[maxIndex] < arr[j]) {
						
						maxIndex = j;
						flag = true;
					} // if
				} // for
				
				if(flag) {
					
					int temp = arr[i];
					arr[i] = arr[maxIndex];
					arr[maxIndex] = temp;
				} // if
			} // for
		} // block
		
//		// Existence for printing arr 
//		for(int element : arr){
//			System.out.print(element + " ");
//		} // for
//		System.out.println();
		
		// Get an answer
		{
			answer = 0;
			for(int i=0; i<N; i++) {
				
				int value = arr[i]*(N-i);
				answer += value;
			} // for
		}
		
		// Print the answer
		{
			System.out.println(answer);
		}
	} // end main
	
} // end class
