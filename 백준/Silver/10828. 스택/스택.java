import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr = new int[10001];
    public static int idx = 0;

    public static void push(int value){
        arr[idx++] = value;
    }

    public static int pop(){

        int answer;
        if(idx==0){
            answer = -1;
        }else{
            answer = arr[--idx];
        }

        return answer;
    }

    public static int size(){

        return idx;
    }

    public static int empty(){

        int answer;
        if(idx==0){
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }

    public static int top(){

        int answer;
        if(idx==0){
            answer = -1;
        }else{
            answer = arr[idx-1];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": System.out.println(pop()); break;
                case "size": System.out.println(size()); break;
                case "empty": System.out.println(empty()); break;
                case "top": System.out.println(top()); break;
            }
        }
    }
}
