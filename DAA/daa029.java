import java.util.*;

public class daa029 {
    static LinkedList<Integer> order = new LinkedList<Integer>();
    static boolean adj[][] = new boolean[26][26];
    static boolean visited[] = new boolean[26];

    public static void dfs(int node){
        visited[node] = true;

        for(int i = 0; i < 26; i++) {
            if(adj[node][i] && !visited[i]) {
                dfs(i);
            }
        }

        order.addFirst(node);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        boolean used[] = new boolean[26];

        String first = in.next();

        for(int i = 1; i < N; i++) {
            String second = in.next();

            for(int j = 0; j < first.length() && j < second.length(); j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    int A = first.charAt(j) - 'A';
                    int B = second.charAt(j) - 'A';

                    adj[A][B] = true;

                    used[A] = true;
                    used[B] = true;

                    break;
                }
            }

            first = second;
        }

        for(int i = 0; i < 26; i++) {
            if(!visited[i] && used[i]) {
                dfs(i);
            }
        }

        int orderLength = order.size();

        for(int i = 0; i < orderLength; i++) {
            System.out.print((char)('A' + order.remove()));
        }
        System.out.println();
    }
}