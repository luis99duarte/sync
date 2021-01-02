import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    int weight; // Peso da aresta
    
    Edge(int t, int w) {
		to = t;
		weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public int distance;         // Distancia ao no origem da pesquisa
    public int parent;
    
    Node() {
		adj = new LinkedList<>();
    } 
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public int cost;
    public int node;

    NodeQ(int c, int n) {
		cost = c;
		node = n;
    }

    @Override
    public int compareTo(NodeQ nq) { 
        if (cost < nq.cost) return -1; 
        if (cost > nq.cost) return +1;
		if (node < nq.node) return -1; 
		if (node > nq.node) return +1;
        return 0; 
    } 
}

// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos
    int[] arrayMin;
    int index;
    int total;
    
    Graph(int n) {
        this.n = n;
        this.total = 0;
        this.index = 1;
        arrayMin = new int[n+1];
		nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
		for (int i=1; i<=n; i++) {
            arrayMin[i] = 0;
            nodes[i] = new Node();
        }
    }
    
    void addLink(int a, int b, int c) {
        nodes[a].adj.add(new Edge(b, c));
        nodes[b].adj.add(new Edge(a, c));
    }

    // Algoritmo de Dijkstra
    void prim(int r) {
	
		//Inicializar nos como nao visitados e com distancia infinita
		for (int i=1; i<=n; i++) {
			nodes[i].distance = Integer.MAX_VALUE;
			nodes[i].visited  = false;
		}
		
		// Inicializar "fila" com no origem
		nodes[r].distance = 0;
		TreeSet<NodeQ> q = new TreeSet<>();
		q.add(new NodeQ(0, r)); // Criar um par (dist=0, no=s)

		// Ciclo principal do Dijkstra
		while (!q.isEmpty()) {
		
			// Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
			NodeQ nq = q.pollFirst();
			int  u = nq.node;//pega o valor do no que foi retirado do tree map
			nodes[u].visited = true;
            //System.out.println(u + " [dist=" + nodes[u].distance + "]");
            total += nodes[u].distance;
            arrayMin[index] = nodes[u].distance;
            index++;

			// Relaxar arestas do no retirado
			for (Edge e : nodes[u].adj) {
				int v = e.to;
				int cost = e.weight;
				if (!nodes[v].visited && cost < nodes[v].distance) {
					q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
                    nodes[v].distance = cost;
                    nodes[u].parent = u;
					q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
				}
			}
        }
    }
};

public class daa38 {
    public static void main(String[] args) {
        FastScanner input = new FastScanner(System.in);
        int a = input.nextInt();// casas ligadas a rede
        int b = input.nextInt();// casas a adicionar a rede
        int c = input.nextInt();// possiveis ligacoes
        Graph g = new Graph(a+b);
        
        int index = 1;
        for(int i = 0; i < a - 1; i++) {
            g.addLink(index , index+1, 0);
            index++;
                
        }

        for(int i = 0; i < c; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int p = input.nextInt();
            g.addLink(x, y, p);
        }

        g.prim(1);
        Arrays.sort(g.arrayMin);
        FastPrint.out.println(g.total);
        for(int i=1; i<g.index; i++) {
            if(i + 1 == g.index)  {
                FastPrint.out.println(g.arrayMin[i]);
            }
            else {
                if(g.arrayMin[i] != 0) {
                    FastPrint.out.print(g.arrayMin[i] + " ");
                }   
            }
        }

        FastPrint.out.close();
    }
}
