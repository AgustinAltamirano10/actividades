
    /**
 * @pre 0 <= s < G.V().
 * @post Calcula los vértices en el grafo G que están
 * conectados al vértice origen s.
 */
public DepthFirstSearch(AdjacencyListIntGraph G, int s) {
    boolean[] marked = new boolean[G.V()];
    dfs(G, s);
}

/**
 * @post Recorre recursivamente el grafo G en orden de
 * búsqueda en profundidad empezando desde v.
 */
private void dfs(AdjacencyListIntGraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
        if (!marked[w]) {
            dfs(G, w);
        }
    }
}
