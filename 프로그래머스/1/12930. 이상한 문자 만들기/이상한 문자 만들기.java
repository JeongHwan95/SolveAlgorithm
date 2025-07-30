import java.util.StringTokenizer;


class Solution {
     public String solution(String s) {
        String answer = "";


        int index = 0;
        for(int i=0; i<s.length(); i++){

            char alpha = s.charAt(i);
            if(alpha == ' '){
                answer += alpha;
                index = 0;
            }else{
                if(index%2==0){
                    String value = String.valueOf(alpha).toUpperCase();
                    answer += value;
                    index++;
                }else{
                    String value = String.valueOf(alpha).toLowerCase();
                    answer += value;
                    index++;
                }
            }
        }

        return answer;
    }
}