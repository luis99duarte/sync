import java.util.Scanner;

public class daa005 {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);

        int n = in.nextInt();

        int ei[] = new int[n + 1];

        ei[0] = 0;

        for(int i = 1; i <= n; i++) {
            ei[i] = in.nextInt() + ei[i - 1];

            //System.out.println(ei[i]);  
        }

        int f = in.nextInt();

        for(int i = 0; i < f; i++) {
            int f1 = in.nextInt();
            int f2 = in.nextInt();
            
            FastPrint.out.println(ei[f2] - ei[f1 - 1]);
        }

        FastPrint.out.close();

        return;
    }
}