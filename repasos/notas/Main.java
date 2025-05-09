package notas;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Clase alumno = new Clase();
        alumno.cargarNota("jorge", 10);
        alumno.cargarNota("jorge", 2);
        alumno.cargarNota("jorge", 2);
        alumno.cargarNota("jorge", 10);
        alumno.cargarNota("jorges", 5);
        HashMap<String, Double> promedios = alumno.promedio();
        for (String name : promedios.keySet()) {
            System.out.println("nombre: " + name + ", promedio:" +  promedios.get(name));
        }


        Clase alumno2 = new Clase();
        try {
            alumno2.cargarNota("juan", 10);
            alumno2.cargarNota("juan", -2);
            alumno2.cargarNota("juan", 6);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}