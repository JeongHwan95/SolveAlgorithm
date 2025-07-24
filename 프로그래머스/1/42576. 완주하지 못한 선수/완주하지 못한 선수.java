import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
     public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++){

            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }

        for(int i=0; i<completion.length; i++){

            Integer num = map.get(completion[i]);
            if(num == 1){
                map.remove(completion[i]);
            }else{
                map.put(completion[i], num-1);
            }
        }

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        answer = iterator.next();


        return answer;
    }
}