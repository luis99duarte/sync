import java.util.*;

public class daa011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d[] = new int[n];

        int high = 0;

        for(int i = 0; i < n; i++) {
            d[i] = in.nextInt();

            high += d[i];
        }

        int p = in.nextInt();
        int k[] = new int[p];

        for(int i = 0; i < p; i++) {
            
            k[i] = in.nextInt();            
        }

        for(int i = 0; i < p; i++) {
            System.out.println(binarysearch(d, 1, high, k[i]));
        }
    }

    public static int binarysearch(int d[], int low, int high, int k) {
        while(low < high) {
            int middle = low + (high - low) / 2;

            if(possible(d, k, middle)) {
                high = middle;
            }

            else {
                low = middle + 1;
            }
        }    

        if(possible(d, k, high)) {
             return low;
        }

        return -1;
    }

    public static boolean possible(int d[], int k, int max) {
        int partition = 1;
        int sum = 0;

        for(int i = 0; i < d.length; i++) {
            if(d[i] > max) {
                return false;
            }

            if(d[i] + sum > max) {
                partition++;
                sum = 0;
            }

            sum += d[i];
        }

        if(partition > k) {
            return false;
        }

        return true;
    }
}