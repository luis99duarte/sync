import java.util.*;

public class daa010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int n = in.nextInt();

            int s[] = new int[n];

            for(int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }

            int q = in.nextInt();
            int p[] = new int[q];
        
            for(int i = 0; i < q; i++) {
                p[i] = in.nextInt();
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

    public static int[] binarysearch(int[] v, int low, int high, int key) {
        while(low <= high) {
            int middle = low + (high - low) / 2;
            
            if(key == v[middle]) {
                return middle;
            }

            if(key < v[middle]) {
                high = middle - 1;
            }

            else {
                low = middle + 1;
            }
        }

        // POR COMPLETAR
        
    }
}