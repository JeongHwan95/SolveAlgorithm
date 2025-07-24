import java.util.Arrays;


class Solution {
     public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        boolean flag = true;
        while(flag){
            
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]){
                flag = false;
            }else{
                bill[1] = bill[1]/2;
                Arrays.sort(bill);
                answer++;
            }
        }
        
        return answer;
    }
}