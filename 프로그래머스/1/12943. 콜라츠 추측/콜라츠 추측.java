class Solution {
     public int solution(int num) {
        int answer = 0;
        int count = 0;
        Long value = (long) num;
        while(value != 1){

            System.out.println("count : " + count + " num : " + num);

            if(count == 500){
                answer = -1;
                break;
            }

            if(value%2==0){
                value = value/2;
                count++;

            }else{
                value = value*3+1;
                count++;

            }
        }

        if(value == 1){
            answer = count;
        }

        return answer;
    }
}