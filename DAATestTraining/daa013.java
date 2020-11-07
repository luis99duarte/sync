import java.util.*;

class Segment implements Comparable<Segment>{
    int L;
    int R;

    Segment(int L, int R) {
        this.L = L;
        this.R = R;
    }

    public int compareTo(Segment s) {
        if(this.L < s.L) {
            return -1;
        }

        if(this.L > s.L) {
            return +1;
        }

        if(this.R > s.R) {
            return -1;
        }

        if(this.R < s.R) {
            return +1;
        }

        return 0;
    }
}

public class daa013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();

        Segment array[] = new Segment[N];

        for(int i = 0; i < N; i++) {
            int L = in.nextInt();
            int R = in.nextInt();

            Segment s = new Segment(L, R);

            array[i] = s;
        }

        Arrays.sort(array);

        System.out.println(minimum(array, M));
    }

    public static int minimum(Segment array[], int M) {
        int end = 0;
        int count = 0;

        while(end < M) {
            end = getEnd(array, end);
            count++;
        }
        return count;
    }

    public static int getEnd(Segment array[], int end) {
        int reach = end;


        for(int i = 0; i < array.length; i++) {
            if(array[i].L <= end && array[i].R > reach) {
                reach = array[i].R;
            }
        }

        return reach;
    }
}