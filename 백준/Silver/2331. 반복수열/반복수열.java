import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2331번
public class Main {
	
	static int[] checking = new int[300000];
	static int A;
	static int P;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int index = 0;
		checking[A] = ++index;
		count++;
		
		int b = A;
		do {
			
			int sum = 0;
			while(b%10!=0 || b>9) {
				sum += Math.pow(b%10, P);
				
				b /= 10;
			}
			
			b = sum;
			
			// 답을 찾았을 때
			if(checking[b]!=0) {
				index = checking[b];
				break;
			}
			// 그 외의 경우
			else{
				checking[b] = ++index;
				count++;
//				System.out.print(b+" ");
			}
		} while(true);
		
		
		System.out.println(--index);
	} // main
	
} // end class