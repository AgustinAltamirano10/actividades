
/**
 * Main class for Lab-classes project
 */
public class LabClassMain {

  public static void main(String[] args) {
    // Declaro objetos del tipo Student
    Student alumno1 = new Student("Jorge", "1");
    Student alumno2 = new Student("Juan", "2");
    Student alumno3 = new Student("kiko", "3");
    Student alumno4 = new Student("Pablo", "4");

    // Creacion de las comisiones
    LabClass comision1 = new LabClass(30);
    LabClass comision2 = new LabClass(27);

    // Agregar estudiante a las comisiones
    comision1.enrollStudent(alumno1);
    comision1.enrollStudent(alumno2);
    comision2.enrollStudent(alumno3);
    comision2.enrollStudent(alumno4);

    comision1.setInstructor("Guillermo");
    comision1.setRoom("Aula 101");
    comision1.setTime("Jueves y Viernes de 10:00 a 12:00");

    comision2.setInstructor("Raul");
    comision2.setRoom("Aula 102");
    comision2.setTime("Martes y Viernes de 08:00 a 10:00");

    // Salidas con printlist
    comision1.printList();
    System.out.println("############################################");
    comision2.printList();
  }
}
