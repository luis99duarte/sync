import java.util.*;

public class daa010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int n = in.nextInt();

            int s[] = new int[n];

            for(int i = 0; i < n; i++) {
                s[i] = in.nexInt();
            }

            int q = in.nextInt();
            int p[] = new int[q];
        
            for(int i = 0; i < q; i++) {
                q[i] = in.nextInt();
            }

            int v[] = new int[n* (n - 1) / 2];

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    v[j] = s[i] + s[j];
                }
            }

            Arrays.sort(v);


        }
    }
}