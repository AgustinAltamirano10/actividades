import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * AdjacencyListGraph implementa un grafo genérico no dirigido.
 * Formalmente, un grafo G = <V, E> consiste en un conjunto de vértices V
 * y una relación E en VxV que describe las aristas del grafo.
 *
 * Esta implementación usa listas de adyacencia: un arreglo indexado por vértices,
 * donde cada posición contiene la lista de vecinos de ese vértice.
 */
public class AdjacencyListGraph<T extends Comparable<? super T>> implements Graph<T> {

    // Cantidad de vértices actuales en el grafo
    private int V;

    // Cantidad de aristas en el grafo
    private int E;

    // Mapa de vértice (etiqueta) a índice entero
    private TreeMap<T, Integer> map;

    // Arreglo de índice entero a vértice (etiqueta)
    private T[] keys;

    // Arreglo de listas de adyacencia: cada índice tiene la lista de vecinos
    private List<Integer>[] adj;

    /**
     * @pre V >= 0
     * @post Inicializa un grafo vacío que puede almacenar hasta V vértices.
     */
    public AdjacencyListGraph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("El número de vértices debe ser no negativo");

        this.V = 0; // Inicialmente no hay vértices cargados
        this.E = 0; // Inicialmente no hay aristas
        adj = new LinkedList[V]; // Inicializa el arreglo de listas
        map = new TreeMap<>();   // Inicializa el mapa etiqueta -> índice
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

        int vid = V++;              // Asigna un índice nuevo y lo incrementa
        map.put(v, vid);            // Guarda en el mapa etiqueta -> índice
        adj[vid] = new LinkedList<>(); // Inicializa la lista de vecinos vacía
        keys[vid] = v;              // Guarda la etiqueta en el arreglo índice -> etiqueta
    }

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Agrega la arista no dirigida entre los vértices v y w.
     */
    public void addEdge(T v, T w) {
        if (!containsVertex(v))
            throw new IllegalArgumentException("El vértice " + v + " no está entre 0 y " + (V - 1));
        if (!containsVertex(w))
            throw new IllegalArgumentException("El vértice " + w + " no está entre 0 y " + (V - 1));

        E++; // Incrementa la cantidad de aristas

        int vid = indexOf(v); // Índice de v
        int wid = indexOf(w); // Índice de w

        adj[vid].add(wid); // Agrega w a la lista de vecinos de v
        adj[wid].add(vid); // Agrega v a la lista de vecinos de w (grafo no dirigido)
    }

    /**
     * @post Devuelve una representación en String del grafo.
     */
    public String toString() {
        String s = "";

        for (int v = 0; v < V; v++) {
            s += nameOf(v) + ": ";
            for (int w : adj[v]) {
                s += nameOf(w) + " ";
            }
            s += '\n';
        }
        return s;
    }
}
