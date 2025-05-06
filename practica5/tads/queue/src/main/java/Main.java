public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Palindromo<Character> lista = new Palindromo<>();

        System.out.print("Ingresá una cadena: ");
        String cadena = sc.nextLine();

        for (int i = 0; i < cadena.length(); i++) {
            lista.enqueue(cadena.charAt(i));
        }

        if (lista.palindromo()) {
            System.out.println("Es palíndromo.");
        } else {
            System.out.println("No es palíndromo.");
        }

        sc.close();
    }
}