import java.util.*;

public class daa017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        boolean[][] damaged = new boolean[N][N];    // por default todos os membros do array tem valor False

        int D = in.nextInt();

        for(int i = 0; i < D; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            damaged[(N - 1) - (x - 1)][y - 1] = true;
        }

        long[][] nWays = new long[N][N];

        for(int i = 0; i < N; i++) {
                nWays[N - 1][i] = 1;
        }

        for(int i = N - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                if(i < N - 1 && !damaged[i + 1][j]) {
                    nWays[i][j] += nWays[i + 1][j];
                }

                if(i < N - 1 && !damaged[i + 1][j + 1]) {
                    nWays[i][j] += nWays[i + 1][j + 1];
                }
            }            
        }

        if(damaged[0][0]) {
            nWays[0][0] = 0;
        }

        System.out.println(nWays[0][0]);
    }
}