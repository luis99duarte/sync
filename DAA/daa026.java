import java.util.*;

public class daa026 {
    static boolean visited[][];
    static int Rows;
    static int Columns;
    static char array[][];
    static int size;

    public static void dfs(int R, int C) {
        if(C < 0 || R < 0 || C > Columns || R > Rows) {
            return;
        }

        if(visited[R][C] || array[R][C] != '#') {
            return;
        }

        visited[R][C] = true;
        size++;
        dfs(R + 1, C);
        dfs(R - 1, C);
        dfs(R, C + 1);
        dfs(R, C - 1);
        dfs(R + 1, C + 1);
        dfs(R - 1, C + 1);
        dfs(R - 1, C - 1);
        dfs(R + 1, C - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String petri;

        

        for(int i = 0; i < N; i++) {
            Rows = in.nextInt();
            Columns = in.nextInt();

            visited = new boolean[Rows + 1][Columns + 1];
            
            array = new char[Rows + 1][Columns + 1];

            for(int l = 1; l <= Rows; l++) {
                petri = in.next();      // input dos caracteres todos

                for(int c = 1; c <= Columns; c++) {
                    array[l][c] = petri.charAt(c - 1);
                }
            }

            int max = 0;

            for(int l = 1; l <= Rows; l++) {
                for(int c = 1; c <= Columns; c++) {
                    size = 0;
                    dfs(l, c);

                    if(size > max) {
                        max = size;
                    }
                }
            }

            System.out.println(max);
        }
    }
}