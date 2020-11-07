import java.util.*;

public class daa001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int S[] = new int[N];  
        int count = 0;

        for(int i = 0; i < N; i++) {
            S[i] = in.nextInt();

            if(S[i] == 42){
                count++;
            }
        }

        System.out.println(count);
    }
}
