import java.util.*;

public class daa027 {
    static int N;       // casos a considerar
    static int V;       // número de nós
    static int E;       // número de arestas

    static boolean visited[];
    static boolean adj[][];

    static int color[];
    static boolean check;

    public static void dfs(int node, int c) {
        if(!visited[node]) {
            visited[node] = true;
            color[node] = c;

            int newColor;

            if(color[node] == 0) {
                newColor = 1;
            }

            else {
                newColor = 0;
            }

            for(int i = 0; i < V; i++) {
                if(adj[node][i]) {
                    dfs(i, newColor);
                }
            }
        }

        else if(c != color[node]) {
            check = false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        for(int i = 1; i <= N; i++) {

            V = in.nextInt();
            E = in.nextInt();

            visited = new boolean[V + 1];
            adj = new boolean[V + 1][V + 1];
            color = new int[V + 1];

            for(int j = 0; j < E; j++) {       // número de ligações (input)
                int a = in.nextInt();
                int b = in.nextInt();

                adj[a][b] = adj[b][a] = true;    
            }

            check = true;
            dfs(1, 0);

            if(!check) {
                System.out.println("nao");
            }

            else {
                System.out.println("sim");
            }
        }
    }
}