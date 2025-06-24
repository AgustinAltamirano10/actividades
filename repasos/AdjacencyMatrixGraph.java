import java.util.TreeMap;

/**
 * AdjacencyMatrixGraph implementa un grafo genérico no dirigido usando
 * una matriz de adyacencia. 
 * Formalmente, un grafo G = <V, E> consiste en un conjunto de vértices V
 * y una relación E en VxV que describe las aristas del grafo.
 * 
 * En esta implementación, se usa una matriz booleana para indicar si hay o no arista.
 */
public class AdjacencyMatrixGraph<T extends Comparable<? super T>> implements Graph<T> {

    // Cantidad de vértices actuales en el grafo
    private int V;

    // Cantidad de aristas en el grafo
    private int E;

    // Mapa de etiqueta de vértice -> índice entero
    private TreeMap<T, Integer> map;

    // Arreglo de índice entero -> etiqueta de vértice
    private T[] keys;

    // Matriz de adyacencia: adj[i][j] == true si hay arista entre i y j
    private boolean[][] adj;

    /**
     * @pre V >= 0
     * @post Inicializa un grafo vacío que puede almacenar hasta V vértices.
     */
    public AdjacencyMatrixGraph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("El número de vértices debe ser no negativo");

        this.V = 0; // Inicialmente no hay vértices cargados
        this.E = 0; // Inicialmente no hay aristas
        adj = new boolean[V][V];   // Inicializa la matriz de adyacencia
        map = new TreeMap<>();     // Inicializa el mapa etiqueta -> índice
        keys = (T[]) new Comparable[V]; // Inicializa el arreglo índice -> etiqueta
    }

    /**
     * @pre 0 <= v < V
     * @post Devuelve la etiqueta del vértice asociado con el índice v.
     */
    T nameOf(int v) {
        return keys[v];
    }

    /**
     * @pre contiene el vértice v
     * @post Devuelve el índice entero asociado con la etiqueta v.
     */
    int indexOf(T v) {
        return map.get(v);
    }

    /**
     * @post Devuelve true si y solo si existe un vértice con etiqueta v.
     */
    public boolean containsVertex(T v) {
        return map.containsKey(v);
    }

    /**
     * @pre !containsVertex(v)
     * @post Agrega un nuevo vértice con etiqueta v al grafo.
     */
    public void addVertex(T v) {
        if (containsVertex(v))
            throw new IllegalArgumentException("El vértice ya está en el grafo");

        int vid = V++;      // Asigna índice nuevo
        map.put(v, vid);    // Guarda en el mapa etiqueta -> índice
        keys[vid] = v;      // Guarda la etiqueta en el arreglo índice -> etiqueta
    }

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Agrega la arista no dirigida entre los vértices v y w.
     */
    public void addEdge(T v, T w) {
        if (!containsVertex(v))
            throw new IllegalArgumentException("El vértice " + v + " no existe");
        if (!containsVertex(w))
            throw new IllegalArgumentException("El vértice " + w + " no existe");

        int vid = indexOf(v);
        int wid = indexOf(w);

        // Si no existía la arista, la crea y suma E
        if (!adj[vid][wid]) {
            adj[vid][wid] = true;
            adj[wid][vid] = true; // Grafo no dirigido: simétrico
            E++;
        }
    }

    /**
     * @post Devuelve true si existe la arista entre v y w.
     */
    public boolean hasEdge(T v, T w) {
        if (!containsVertex(v) || !containsVertex(w))
            throw new IllegalArgumentException("Uno de los vértices no existe");

        return adj[indexOf(v)][indexOf(w)];
    }

    /**
     * @post Devuelve una representación en String del grafo.
     */
    public String toString() {
        String s = "";

        for (int i = 0; i < V; i++) {
            s += nameOf(i) + ": ";
            for (int j = 0; j < V; j++) {
                if (adj[i][j]) {
                    s += nameOf(j) + " ";
                }
            }
            s += "\n";
        }
        return s;
    }
}
