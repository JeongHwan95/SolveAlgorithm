import java.util.Arrays;


class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[i] = c;
        }
        
        Arrays.sort(arr);
        
         int small = 0;
        int big = arr.length-1;
        char temp;
        while(small < big){
            
            temp = arr[small];
            arr[small] = arr[big];
            arr[big] = temp;
            
            small++;
            big--;
        }
        
        for(char alpha : arr){
            answer = "" + answer + alpha;
        }
        
        return answer;
    }
}