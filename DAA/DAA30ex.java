// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
    public int distance;            // Distancia ao no origem da pesquisa

    Node() {
		adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos

    Graph(int n) {
		this.n = n;
		nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0
		for (int i=1; i<=n; i++) {
			nodes[i] = new Node();
		}
    }

    public void addLink(int a, int b) {
		nodes[a].adj.add(b);
		nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura 
    //dssa versao retorna a distancia max ate cada no
    public int bfs(int v) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i=1; i<=n; i++) {
			nodes[i].visited = false;
		}
        int max = -1;//add
		q.add(v);
		nodes[v].visited = true;
		nodes[v].distance = 0;

		while (q.size() > 0) {
	    	int u = q.removeFirst();
	    	//System.out.println(u + " [dist=" + nodes[u].distance + "]");
	    	for (int w : nodes[u].adj) {
				if (!nodes[w].visited) {
		    		q.add(w);
		    		nodes[w].visited  = true;
                    nodes[w].distance = nodes[u].distance + 1;
                    //add
                    if(nodes[w].distance > max) {
                        max = nodes[w].distance; 
                    }
				} 
			}	    
        }
        return max;
    }
}
/*
public class BFS {
    public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		Graph g = new Graph(in.nextInt());
		int   e = in.nextInt();
		for (int i=0; i<e; i++) { 
	    	g.addLink(in.nextInt(), in.nextInt());
		}
		
		// Pesquisa em largura a partir do no 1
		g.bfs(1);
		in.close();		
    }
}
*/
public class DAA30ex {
    static int n;//nos
    static int e;//arestas
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Graph g = new Graph(n+1);
        int[] maxDist = new int[n+1];//distancia max ate cada no (1-9)
        e = input.nextInt(); 
        
        for(int i = 0; i < e; i++) {
            g.addLink(input.nextInt(), input.nextInt());
        }

        int diameter = Integer.MIN_VALUE;//max
        int radius = Integer.MAX_VALUE;//min
        
        for(int i = 1; i <= n; i++) {
            int result = g.bfs(i);
            maxDist[i] = result;
            if(result > diameter) {
                diameter = result;
            }
            if(result < radius) {
                radius = result;
            }
        }

        System.out.println(diameter);
        System.out.println(radius);

        int check = 0;
        /* verificaçao se ha mais q um no de dist iguais */
        for(int i = 1; i <= n; i++) {
            if(maxDist[i] == radius) {
                if(check == 0) {
                    check = 1;
                    System.out.print(i);
                }
                else {
                    System.out.print(" " + i);
                }
            }
        }
        System.out.println();
        
        check = 0;//reset p max
        for(int i = 1; i <= n; i++) {
            if(maxDist[i] == diameter) { // neste max ja tem o max atual
                if(check == 0) {
                    check = 1;
                    System.out.print(i);
                }
                else {
                    System.out.print(" " + i);
                }
            }
        }
        System.out.println();        
        input.close();
    }
}
