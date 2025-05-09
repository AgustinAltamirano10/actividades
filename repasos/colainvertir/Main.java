package colainvertir;
public class Main {
    public static void main(String[] args) {
        QueueLinkedList<Integer> cola = new QueueLinkedList<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        System.out.println("tamaño: " + cola.size());
        System.out.println("cola antes de quitar: " + cola.toString());


        cola.dequeue();
        System.out.println("cola despues de quitar: " + cola.toString());

        if (cola.repOk()) {
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
        
        cola.invertirCola();
        System.out.println("cola invertida: " + cola.toString());
    }
}
