import java.util.Queue;

import GrafosNoDirigidos.AdjacencyListIntGraph;

public class BFS {
    /**
 * @pre 0 <= s < G.V().
 * @post Recorre el grafo en orden de amplitud (Breadth-First Search) comenzando desde s.
 */
public void bfs(AdjacencyListIntGraph G, int s) {
    // Crea un vector para marcar los vértices visitados
    marked = new boolean[G.V()];

    // Crea un vector para registrar el vértice anterior en el camino más corto hacia cada vértice
    edgeTo = new int[G.V()];

    // Cola para recorrer los vértices en orden de llegada (FIFO)
    Queue<Integer> q = new Queue<Integer>();

    // Marca el vértice inicial como visitado
    marked[s] = true;

    // Encola el vértice inicial
    q.enqueue(s);

    // Mientras la cola no esté vacía:
    while (!q.isEmpty()) {
        // Desencola un vértice de la cola
        int v = q.dequeue();

        // Recorre todos los vecinos de v
        for (int w : G.adj(v)) {

            // Si el vecino w aún no fue visitado:
            if (!marked[w]) {
                // Lo marca como visitado
                marked[w] = true;

                // Guarda que w se alcanzó desde v
                edgeTo[w] = v;

                // Encola w para procesarlo después
                q.enqueue(w);
            }
        }
    }
}

}
