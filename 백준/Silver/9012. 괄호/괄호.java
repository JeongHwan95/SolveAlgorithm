import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){

            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j=0; j<line.length(); j++){
                if(line.charAt(j)== '('){
                    stack.add('(');
                }else{

                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            
            if(flag && stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
        }
    }
}
