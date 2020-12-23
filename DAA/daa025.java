import java.util.*;

public class daa025 {
    public static int n;              // Numero de nos do grafo
    public static boolean adj[][];    // Matriz de adjacencias
    public static boolean visited[];  // Que nos ja foram visitados?

    public static void dfs(int v) {
        visited[v] = true;
    
	    for (int i = 1; i <= n; i++) {
	        if (adj[v][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        adj = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        int L = in.nextInt();

        int count = 0;

        for(int i = 0; i < L; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            adj[a][b] = adj[b][a] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}

