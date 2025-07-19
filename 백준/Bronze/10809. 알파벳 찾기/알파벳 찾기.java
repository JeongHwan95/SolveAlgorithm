
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<word.length(); i++){
            
            if(arr[(int)word.charAt(i)-'a'] == -1) {
                arr[(int) word.charAt(i) - 'a'] = i;
            }
        }

        for(int i=0; i<arr.length; i++){

            System.out.print(arr[i] + " ");
        }
    }
}
