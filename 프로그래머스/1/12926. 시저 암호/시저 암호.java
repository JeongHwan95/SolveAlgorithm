class Solution {
     public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){

            char alpha = s.charAt(i);

            if(alpha >= (int)'a' && alpha <= (int)'z'){
                alpha += n;
                if(alpha > (int)'z'){
                    alpha = (char)((int)alpha%'z' + 'a' -1);
                }
            }else if(alpha >= (int)'A' && alpha <= (int)'Z'){
                alpha += n;
                if(alpha > (int)'Z'){
                    alpha = (char)((int)alpha%'Z' + 'A' -1);
                }
            }
            answer += alpha;
        }

        return answer;
    }
}