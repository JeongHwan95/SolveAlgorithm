import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        
        int max = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        return set.size() >= max ? max : set.size();
    }
}