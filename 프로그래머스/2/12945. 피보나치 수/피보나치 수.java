class Solution {
	
	static int[] memo = new int[100001];
    public int solution(int n) {
        
        return fibo(n);
        
    }
    
    public static int fibo(int n){
        
        if(n<2)
            return n;
        else if(memo[n] != 0)
            return memo[n]%1234567;
        else{
            return memo[n] = (fibo(n-1) + fibo(n-2))%1234567;
        }
    }
}