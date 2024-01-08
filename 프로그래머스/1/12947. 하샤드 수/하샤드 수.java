class Solution {
    public boolean solution(int x) {

		
		int sum = 0;
		int k = x;
		while(k>0) {
			sum = sum + k%10;
			
			k = k/10;
		}
		
		if(x%sum == 0) {
			return true;
		}else
			return false;
	}
}