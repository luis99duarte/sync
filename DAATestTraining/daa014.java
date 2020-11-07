import java.util.*;


class shoes implements Comparable<shoes> {
    int id;
    int d;
    int t;
    float p;

    shoes(int id, int d, int t) {
        this.id = id;
        this.d = d;
        this.t = t;
        this.p = (float)t / (float)d;
    }

    @Override
    public int compareTo(shoes s) {
        if(this.p > s.p) {
            return -1;
        }

        if(this.p < s.p) {
            return +1;
        }

        if(this.id < s.id) {
            return -1;
        }

        if(this.id > s.id) {
            return +1;
        }
        return 0;
    }
}

public class daa014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        shoes D[] = new shoes[N];

        for(int i = 0; i < N; i++) {
            int duration = in.nextInt();
            int ticket = in.nextInt();

            shoes s = new shoes(i + 1, duration, ticket);
            D[i] = s;
        }

        Arrays.sort(D);

        for(int i = 0; i < N; i++) {
            if(N - 1 == i){
                System.out.println(D[i].id);
            }
            
            else {
            System.out.print(D[i].id + " " );
            }
        }
    }
    
}