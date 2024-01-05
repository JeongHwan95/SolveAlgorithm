import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
		 
		 List<Long> list = new ArrayList<>();
		 
		 for(int i=0; i<n; i++) {
			 
			 list.add((long)x*(i+1));
		 }
		 
		 long[] answer = new long[list.size()];
		 for(int i=0; i<list.size(); i++) {
			 
			 answer[i] = list.get(i);
		 }
		 
		 return answer;
	 }
}