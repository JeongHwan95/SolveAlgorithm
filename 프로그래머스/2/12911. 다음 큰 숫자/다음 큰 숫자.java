class Solution {
    public int solution(int n) {
		
		int answer =0;
		
		String s = Integer.toBinaryString(n);
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '1') {
				cnt++;
			}
		}
		
		for(int i=n+1; i<=1000000; i++) {
			
			int innerCnt = 0;
			String k = Integer.toBinaryString(i);
			for(int j=0; j<k.length(); j++) {
				if(k.charAt(j) == '1') {
					innerCnt++;
				}
			}
			
			if(cnt == innerCnt) {
				answer = i;
                break;
			}
		}
		
		return answer;
	 }
}