import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Long count=0L;
        for(int i=0; i<=N; i++){

            for(int j=0; j<60; j++){

                for(int k=0; k<60; k++){

                    if(i/10 == K || i%10 == K ||
                    j/10 == K || j%10 == K
                    || k/10 ==K || k%10==K){

                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
