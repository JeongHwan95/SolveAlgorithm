
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> candidate = new ArrayList<>();
        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<N-2; i++){

            for(int j=i+1; j<N-1; j++){

                for(int k=j+1; k<N; k++){

                    int value = arr[i]+arr[j]+arr[k];
                    if(value <= M){
                        candidate.add(value);
                    }
                }
            }
        }

        Collections.sort(candidate);

        System.out.println(candidate.get(candidate.size()-1));
    }
}
