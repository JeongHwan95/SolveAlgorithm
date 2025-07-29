import java.util.Arrays;


class Solution {
      public int solution(int[] d, int budget){

        Arrays.sort(d);
        int sum=0;
        int idx = 0;
        for(int i=0; i<d.length; i++){

            sum += d[i];
            if(sum>budget){
                idx = i;
                break;
            }
        }

        if(idx==0 && sum <= budget){
            return d.length;
        }

        return idx;
    }
}