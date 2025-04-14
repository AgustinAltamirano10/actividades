import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordCounter2 {
    
    private List<String> lista; // Variable de tipo arreglo donde se guardaran solos las claves
    private Map<String, String> mapa; // Mapa con las claves y valores
    private Map<String, Integer> mapaApariciones; // Mapa para contar las apariciones

    /**
     * constructor
     */
    public WordCounter2() {
        lista = new ArrayList<>();
        mapa = new Responder().getResponseMap();
        mapaApariciones = new HashMap<>();
        deMapAArreglo(); 
    }

    public void deMapAArreglo()
    {
        Iterator<String> it = mapa.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            if(!lista.contains(clave)) {
                lista.add(clave);
            }
        }
    }

    public Map cantidadRepetidas(String palabra) // palabra es ingresada por el usuario
    {
        if(!mapa.containsKey(palabra)) {
            if (mapaApariciones.containsKey(palabra)) {
                mapaApariciones.put(palabra, mapaApariciones.get(palabra) + 1);
            } else {
                mapaApariciones.put(palabra, 1);
            }
        }
        return mapaApariciones;
    }
    
    public void mostrar()
    {
        Iterator<String> it = mapaApariciones.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            int cantidad = mapaApariciones.get(clave);
            System.out.println("La palabra: " + clave + " se repitió: " + cantidad + " veces.");
        }
    }
}
