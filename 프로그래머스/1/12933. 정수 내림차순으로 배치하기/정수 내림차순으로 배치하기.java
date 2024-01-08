import java.util.*;

class Solution {
    public long solution(long n) {
		
		
		String s = String.valueOf(n);
		String[] arr = s.split("");
		Arrays.sort(arr, Collections.reverseOrder());
		
		String k = "";
		for(int i=0; i<arr.length; i++) {
			k += "" + arr[i];
		}
		
		return Long.parseLong(k);
		
	}
}