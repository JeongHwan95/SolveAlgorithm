import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length-1][0];
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int countT = 0;
        int stamina = health;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<attacks.length; i++){

            map.put(attacks[i][0], attacks[i][1]);
        }

        for(int i=1; i<=time; i++){

            if(map.containsKey(i)){

                countT=0;
                stamina -= map.get(i);
            
                if(stamina <= 0){
                    stamina = -1;
                    break;
                }
            }else{

                countT++;
                if(countT >= t){
                    
                    countT = 0;
                    stamina = stamina + x + y;
                    if(stamina > health){
                        stamina = health;
                    }
                }else{

                    stamina += x;
                    if(stamina > health){
                        stamina = health;
                    }
                }
            }
        }

        answer = stamina;
        return answer;
    }
}