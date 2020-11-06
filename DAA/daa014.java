// Knapsack é necessário fazer divisão que define prioridade

import java.util.*;

class order implements Comparable<order> {
    int id;
    int d;
    int m;
    float p;

    order (int id, int d, int m) {
        this.id = id;
        this.d = d;
        this.m = m;
        this.p = (float)m / (float)d;
    }

    @Override
    public int compareTo(order o) {
        if(this.p > o.p) {
            return -1;
        }

        if(this.p < o.p) {
            return +1;
        }

        if(this.id < o.id) {
            return -1;
        }

        if(this.id > o.id) {
            return +1;
        }

        return 0;
    }
}

public class daa014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        order a[] = new order[N];

        for(int i = 0; i < N; i++) {
            int d = in.nextInt();
            int m = in.nextInt();

            order p = new order(i + 1, d, m);
            a[i] = p;
        }

        Arrays.sort(a);

        /*Teste
        for(int i = 0; i < N; i++) {
            System.out.println(a[i].id + " " + a[i].d + " " + a[i].m);
        }*/

        for(int i = 0; i< N; i++) {
            if(i == N - 1) {
                System.out.println(a[i].id);
            }
            else {
                System.out.print(a[i].id + " ");
            }
        }
        
    }
}