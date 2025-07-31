class Solution {
    public static boolean find(int candidate){
        
        boolean flag = true;
        
        for(int i=2; i<candidate/2; i++){
            if(candidate%i==0){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    public int solution(int[] nums) {
        int answer = 0;


        for(int i=0; i<nums.length-2; i++){

            for(int j=i+1; j<nums.length-1; j++){

                for(int k=j+1; k<nums.length; k++){

                    int candidate = nums[i] + nums[j] + nums[k];
                    
                    if(find(candidate)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}