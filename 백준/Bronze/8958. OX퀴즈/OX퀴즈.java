
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for(int i=0; i<TC; i++){

            String line = br.readLine();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for(int j=0; j<line.length(); j++){
                char c = line.charAt(j);
                if(c == 'O' && stack.isEmpty()){
                    stack.push(1);
                    sum += 1;
                }else if(c == 'O'){
                    Integer num = stack.pop();
                    stack.push(num+1);
                    sum = sum + num + 1;
                }else{
                    stack.clear();
                }
            }
            System.out.println(sum);
        }

    }
}
