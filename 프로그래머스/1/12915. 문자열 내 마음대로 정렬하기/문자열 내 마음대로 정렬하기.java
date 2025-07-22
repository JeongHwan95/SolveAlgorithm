import java.util.*;

class Solution {
     public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strings.length; i++){

            String c = String.valueOf(strings[i].charAt(n));

            if(map.containsKey(c)){
                map.get(c).add(strings[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(c, list);
            }
        }

        Set<String> set =  map.keySet();
        List<String> keys = new ArrayList<>();
        keys.addAll(set);
        Collections.sort(keys);


        int idx = 0;
        for(int i=0; i<keys.size(); i++){
            
            List<String> values = map.get(keys.get(i));
            
            if(values.size() != 1){
                Collections.sort(values);
                for(int j=0; j<values.size(); j++){
                    answer[idx++] = values.get(j);
                }
            }else{
                answer[idx++] = values.get(0);
            }
        }
        
        return answer;
    }
}