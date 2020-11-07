import java.util.*;

public class daa011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int D[] = new int[N];

        int high = 0;

        for(int i = 0; i < N; i++) {
            D[i] = in.nextInt();
            high += D[i];
        }

        int P = in.nextInt();

        int K[] = new int[P];

        for(int i = 0; i < P; i++) {
            K[i] = in.nextInt();
        }

        for(int i = 0; i < P; i++) {
            System.out.println(bsearch(D, 1, high, K[i]));
        }
    }

    public static int bsearch(int n[], int low, int high, int k) {
        while(low < high) {
            int middle = low + (high - low) / 2;

            if(checker(n, middle, k)) {
                high = middle;
            }

            else{
                low = middle + 1;
            }
        }

        if(!checker(n, low, k)) {
            return -1;
        }

        return low;
    }

    public static boolean checker(int n[], int max, int k) {
        int sum = 0;
        int count = 1;

        for(int i = 0; i < n.length; i++) {
            if(n[i] > max) {
                return false;
            }

            if(n[i] + sum > max) {
                count++;
                sum = 0;
            }

            sum += n[i];
        }

        if(count > k) {
            return false;
        }

        return true;
    }
}