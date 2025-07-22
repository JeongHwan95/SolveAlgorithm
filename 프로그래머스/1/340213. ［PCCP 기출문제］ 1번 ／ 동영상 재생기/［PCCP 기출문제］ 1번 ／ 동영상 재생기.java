import java.util.StringTokenizer;


class Solution {
    
       public static int convertTime(StringTokenizer st, String value){
        st = new StringTokenizer(value, ":");
        return Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        // 1. commands를 다 해보고 => pos가 이동할 때, 시작점인지 아니면 video_len의 끝부분인지도 파악해야 함.
        // 2. op_start와 op_end 사이인지 파악하기

        // 문제 시간을 어떻게 바꾸냐 인데
        int videoLenTime, posTime, opStartTime, opEndTime;
        StringTokenizer st = new StringTokenizer("Hello");

        videoLenTime = convertTime(st, video_len);
        posTime = convertTime(st, pos);
        opStartTime = convertTime(st, op_start);
        opEndTime = convertTime(st, op_end);

        int currentTime = posTime;

        if(currentTime>=opStartTime && currentTime<= opEndTime){
            currentTime = opEndTime;
        }

        for(int i=0; i<commands.length; i++){

            if(commands[i].equals("next")){

                if(currentTime+10 >= videoLenTime){
                    currentTime = videoLenTime;
                    if(currentTime>=opStartTime && currentTime<= opEndTime){
                        currentTime = opEndTime;
                    }
                }else{
                    currentTime += 10;
                    if(currentTime>=opStartTime && currentTime<= opEndTime){
                        currentTime = opEndTime;
                    }
                }
            }else{

                if(currentTime-10 <= 0){
                    currentTime = 0;
                    if(currentTime>=opStartTime && currentTime<= opEndTime){
                        currentTime = opEndTime;
                    }
                }else{
                    currentTime -= 10;
                    if(currentTime>=opStartTime && currentTime<= opEndTime){
                        currentTime = opEndTime;
                    }
                }
            }
        }

        
        int currentMinutes = currentTime/60;
        int currentSeconds = currentTime%60;

        if(currentMinutes<10 && currentSeconds <10) {
            answer = "0" + currentMinutes + ":" + "0" + currentSeconds;
        }else if(currentMinutes<10 ){
            answer = "0" + currentMinutes + ":" + currentSeconds;
        }else if(currentSeconds<10 ){
            answer = currentMinutes + ":" + "0" + currentSeconds;
        }else{
            answer = currentMinutes + ":" + currentSeconds;
        }
        return answer;
    }
}