
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        StringTokenizer st;
        for(int i=0; i<TC; i++){

            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            int height;
            int weight;
            if(N%H==0 && N != 0){
                height = H;
                weight = N/H;
            }else {
                height = N%H;
                weight = N/H + 1;
            }

            // height + weight

            sb.append(height);

            if(weight >= 10){
                sb.append(weight);
            }else{
                sb.append("0" + weight);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
