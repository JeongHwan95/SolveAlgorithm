class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=1; i<food.length; i++) {
        	
        	int j = food[i]/2;
        	for(int k=0; k<j; k++) {
        		sb.append(i);
        	}
        }
        
        String right = sb.toString();
        String left = sb.reverse().toString();
        answer = right + "0" + left;
        
        return answer;
    }
}