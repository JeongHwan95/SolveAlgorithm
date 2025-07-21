import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> answers = new ArrayList<>();
        for(int i=0; i<arr.length; i++){

            if(arr[i]%divisor==0){
                answers.add(arr[i]);
            }
        }
        Collections.sort(answers);
        answer = new int[answers.size()];
        for(int i=0; i<answers.size(); i++){
            answer[i] = answers.get(i);
        }
        
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        return answer;
    }
}