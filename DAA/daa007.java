/* Exercício realizado juntamente com o Telmo Ribeiro 201805124 */

import java.util.*;

public class daa007 {
    public static int smsAuxA(int[] v, int a, int b) {
        int best = 0;
        int currentBest = 0;

        for (int i = a; i >= b; i--) {
            currentBest += v[i];

            if (currentBest > best) {
                best = currentBest;
            }
        }

        return best;
    }

    public static int smsAuxB(int[] v, int a, int b) {
        int best = 0;
        int currentBest = 0;

        for (int i = a; i <= b; i++) {
            currentBest += v[i];

            if (currentBest > best) {
                best = currentBest;
            }
        }

        return best;
    }

    public static int sms(int[] v, int a, int b) {
        if (a == b) { return v[a]; }

        int m = (a + b) / 2;

        int best1 = sms(v, a, m);
        int best2 = sms(v, m + 1, b);
        int best3 = smsAuxA(v, m, a) + smsAuxB(v, m + 1, b);

        return Math.max(best3, Math.max(best2, best1));
    }

    public static void main(String[] args) {
        FastScanner input = new FastScanner(System.in);

        int N = input.nextInt();

        int[] v = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = input.nextInt();
        }

        FastPrint.out.println(sms(v, 0, N - 1));

        FastPrint.out.close();
    }
}
