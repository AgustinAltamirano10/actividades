
import java.util.ArrayList;

public class Curso extends Student {
    ArrayList<String> listaEstudiantes;

    public Curso(String name, String lastName, int id2, ArrayList<String> listaEstudiantes) {
        super(name, lastName, id2);
        listaEstudiantes = new ArrayList<>();
    }

    public boolean find (Student s1)
    {
        for (String student : listaEstudiantes) {
            if (student.equals(s1)) {
                return true; 
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Curso curso = new Curso("raul", "lopez", 123, null);
        Student student = new Student("raul", "lopez", 123);
        System.out.println(curso.equals(student)); // True

        Student student2 = new Student("jorge", "diaz", 0);
        System.out.println(curso.equals(student2)); // False
    }
}


/**
 * Actividad 4
 * a) device
 * b) device ya que es del tipo del objeto
 */

/**
 * Actividad 5
 * a) si compila xq object es superclase de todas las demas
 * b) si compila xq sout va a invocar al metodo toString
 * c) si compila 
 */
