import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		
		// Declaration
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A;
		int N;
		int K;
		int count;
		
		// Receive from input
		{
			String line = br.readLine();
			String[] arrForLine = line.split(" ");
			N = Integer.parseInt(arrForLine[0]);
			K = Integer.parseInt(arrForLine[1]);
			
			A = new int[N];
			line = br.readLine();
			arrForLine = line.split(" ");
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(arrForLine[i]);
			} // for
		}
		
		
		// Do Selection Sort and check the number of exchange
		{
			count = 0;
			for(int i=N-1; i>0; i--) {
				
				// the condition for break
				if(count==K) {
					break;
				}
				
				// Do the selection sort
				boolean flag = false;
				int maxIndex = i;
				for(int j=i-1; j>=0; j--) {
					
					if(A[maxIndex]<A[j]) {
						
						flag = true;
						maxIndex = j;
					} // if
				} // for
				
				// If exchange exists, Add count one.
				// And change the values in A[]
				if(flag) {
					count++;
					
					//swap
					int temp = A[i];
					A[i] = A[maxIndex];
					A[maxIndex] = temp;
				} // if
			} // for
		}

		// Print an answer considered by condition
		{
			if(count<K) {
				System.out.println("-1");
			} 
			else {
				for(int element : A) {
					
					System.out.print(element + " ");
				} // for
			}
		}
	} // main
} // end class
