import java.util.Arrays;


class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(mats);

        // 배열 뒤집기 (내림차순)
        int left = 0, right = mats.length - 1;
        while (left < right) {
            int temp = mats[left];
            mats[left] = mats[right];
            mats[right] = temp;
            left++;
            right--;
        }

        for(int k : mats){

            for(int i=0; i<park.length; i++){

                if(i+k-1 >= park.length) break;
                for(int j=0; j<park[i].length; j++){

                    if(j+k-1 >= park[i].length) break;
                    boolean flag=false;
                    for(int l = 0; l<k; l++){

                        for(int m=0; m<k; m++) {

                            if (!park[i + l][j + m].equals("-1")) {
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            break;
                        }
                    }
                    if(!flag) {
                        System.out.println("i : " + i + " j : " + j);
                        return k;
                    }
                }
            }
        }

        return -1;
    }
}