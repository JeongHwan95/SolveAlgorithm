import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int answerTime = hour*60 + minute - 45;

        if(answerTime>=0){
            System.out.println(answerTime/60 + " " + answerTime%60);
        }else{
            System.out.println("23 " + (60+answerTime));
        }
    }
}