package TryCatch;
public class TryCatch {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Test válido
        try {
            int resultado = calc.dividir(10, 2);
            System.out.println("Resultado: " + resultado); // Debería mostrar 5
        } catch (ArithmeticException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        // Test con error (división por cero)
        try {
            int resultado = calc.dividir(10, 0);
            System.out.println("Resultado: " + resultado); // No debería llegar acá
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
