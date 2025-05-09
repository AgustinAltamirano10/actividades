package map;

import java.util.HashMap;
import java.util.Map;

public class Frecuente {
    
    private String frase;

    public Frecuente(String frase)
    {
        this.frase = frase;
    }

    public Map<String, Integer> contadorFrecuencia(String frase)
    {
        Map<String, Integer> map = new HashMap<>();
        String[] dividir = frase.split(" ");
        for (String p : dividir) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        return map;
    }

    public void masRepetida(String frase)
    {
        Map<String, Integer> map = contadorFrecuencia(frase);
        int max = 0;
        for (int cantidad : map.values()) {
            if (cantidad > max) {
                max = cantidad;
            }
        }
    }
    
    // Main
    public static void main(String[] args) {
        System.out.println("#################################");
        Contador frase1 = new Contador("messi es messi");
        Map<String, Integer> map = frase1.contadorFrecuencia("messi es messi");
        for (String car1 : map.keySet()) {
            System.out.println("palabra:" + car1 + ", veces:" + map.get(car1));
        }

    }
}
