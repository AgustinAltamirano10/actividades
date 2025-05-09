package notas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class Clase {

    private HashMap<String, List<Integer>> alumno; // nombre , lista con notas

    public Clase()
    {
        alumno = new HashMap<>();
    }

    public void cargarNota(String name, Integer nota)
    {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota ingresada(" + nota + ") es incorrecta.");
        }
        List<Integer> notas = alumno.getOrDefault(name, new ArrayList<>());
        notas.add(nota);
        alumno.put(name, notas);

    }

    public HashMap<String, Double> promedio()
    {
        if (alumno.isEmpty()) {
            throw new NoSuchElementException("No hay alumnos");
        }
        
        HashMap<String, Double> promedio = new HashMap<>();
        for (String name : alumno.keySet()) {
            Double sumanotas = 0.0;
            for (int i = 0; i < alumno.get(name).size(); i++) {
                sumanotas = sumanotas + alumno.get(name).get(i);
            }
            sumanotas = sumanotas / alumno.get(name).size();
            promedio.put(name, sumanotas
            );
        }
        return promedio;
    }
    
} 