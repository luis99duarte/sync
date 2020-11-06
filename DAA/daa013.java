// Descobrir o menor numero de segmentos possivel que completem o intervalo 
// Ordenar primeiro pela 

import java.util.*;

class Segment implements Comparable<Segment> {
    int r;
    int l;

    Segment(int r, int l) {
        this.r = r;
        this.l = l;
    }

    @Override
    public int compareTo(Segment s) {
        if(this.l < s.l) {
            return -1;
        }

        if(this.l > s.l) {
            return +1;
        }

        if(this.r > s.r) {
            return -1;
        }

        if(this.r < s.r) {
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

        Segment[] a = new Segment[N];

        for(int i = 0; i < N; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            Segment s = new Segment(r, l);

            a[i] = s;
        }

        Arrays.sort(a);


        System.out.println(count(a, M));
    }

    public static int count(Segment[] S, int M) {
        int end = 0;
        int count = 0;
        int index = 0;

        while(end < M) {
            index = endIndex(S, end);

            end = S[index].r;  
            count++;
        }

        return count;
    }

    public static int endIndex(Segment[] S, int end) {
        int reach = 0;
        int index = 0;

        for(int i = 0; i < S.length; i++) {
            if(S[i].l <= end && S[i].r > reach) {
                reach = S[i].r;
                index = i;
            }
        }
        
        return index;
    }
}