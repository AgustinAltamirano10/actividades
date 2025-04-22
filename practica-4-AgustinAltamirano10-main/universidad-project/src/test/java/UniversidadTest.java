import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
/**
 * The test class PhotoPostTest.
 */
public class UniversidadTest
{
  /**
   * Actividad 3.1
   * V // Es ilegal porque Student es una subclase de person
   * V // Es legal porque PhDStudent es una subclase de Student
   * F // No es legal porque Student no es una subclase de PhDStudent
   * V // (Es falsa )No es legal porque Person no es una subclase de Teacher
   * V // Es legal porque PhDStudent es una subclase de Student
   */

  /**
   * Actividad 3.2
   *  F //
   *  F //
   *  V //
   *  F // 
   *  V //
   *  F //
   *  Resumen: es legal asignar una instancia de una subclase a una variable de tipo de su superclase,  Si una clase es subclase de otra, puedes asignar un objeto de la subclase a una variable de la superclase, pero no al revés.
   *           es ilegal asignar una instancia de una superclase a una variable de tipo de su subclase, Si dos clases no tienen una relación de herencia directa
   */ 
    @Test
    public void test1() {
    Person p1 = new Student();
    Person p2 = new PhStudent();
    Student s1 = new PhStudent();

    // Verificaciones válidas
    assertTrue(p1 instanceof Student);
    assertTrue(p2 instanceof PhStudent);
    assertTrue(s1 instanceof PhStudent);

    // Verificaciones negativas
    assertFalse(p1 instanceof PhStudent);
    assertFalse(p2 instanceof Student && !(p2 instanceof PhStudent)); // p2 sí es Student, pero también PhDStudent
}


    @Test 
    public void test2()
    {
        Person p1 = new Person();
        Person p2 = new Person();
        PhDStudent phd1 = new PhDStudent();
        Teacher t1 = new Teacher();
        Student s1 = new Student();

        // Asercionnes legales
        p1 = s1;  
        assertTrue(p1 instanceof Person);  

        s1 = phd1;  
        assertTrue(s1 instanceof Student);  
        assertTrue(s1 instanceof PhDStudent);  
        
        // Asignaciones ilegales
        try {
            s1 = p1;  // Esto debería fallar
            fail("Expected exception for s1 = p1");
        } catch (ClassCastException e) {
            // Esto está bien, porque esperamos que falle.
        }

        try {
            s1 = p2;  // Esto también debería fallar
            fail("Expected exception for s1 = p2");
        } catch (ClassCastException e) {
            // Está bien, esperamos que falle.
        }

        try {
            t1 = s1;  // Esto debería fallar porque no puedes asignar un Student a un Teacher
            fail("Expected exception for t1 = s1");
        } catch (ClassCastException e) {
            // También está bien, esperamos que falle.
        }

        try {
            phd1 = s1;  // Esto debería fallar porque no todo Student es un PhDStudent
            fail("Expected exception for phd1 = s1");
        } catch (ClassCastException e) {
            // También está bien, esperamos que falle.
        }
    }
}
