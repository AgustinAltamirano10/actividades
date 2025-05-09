package map;
import java.util.HashMap;
import java.util.Map;

public class Contador {

    private String frase;

    public Contador(String frase)
    {
        this.frase = frase;
    }

    public Map<Character, Integer> contar()
    {
        Map<Character, Integer> contador = new HashMap<>();
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            contador.put(c, contador.getOrDefault(c, 0) + 1);
        }
        return contador;
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


    // Main
    public static void main(String[] args) {
        Contador frase = new Contador("messi es messi");
        Map<Character, Integer> contador = frase.contar();

        for (Character car : contador.keySet()) {
            System.out.println("letra:" + car + ", veces:" + contador.get(car));
        }
        System.out.println("#################################");
        Contador frase1 = new Contador("messi es messi");
        Map<String, Integer> map = frase1.contadorFrecuencia("messi es messi");
        for (String car1 : map.keySet()) {
            System.out.println("palabra:" + car1 + ", veces:" + map.get(car1));
        }
    }
}
