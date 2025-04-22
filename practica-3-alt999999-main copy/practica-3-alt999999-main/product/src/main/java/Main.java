import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product pro = new Product(1, "leche"); 
        Product pro1 = new Product(2, "azucar"); 
        Product pro2 = new Product(3, "pan"); 
        Product pro3 = new Product(2, "harina"); 

        
        StockManager supermercado = new StockManager();

        // Agrego productos al stock
        supermercado.addProduct(pro);
        supermercado.addProduct(pro1);
        supermercado.addProduct(pro2);
        supermercado.addProduct(pro3); // No se puede agregar

        // Agrego cantidad de productos
        supermercado.delivery(1, 10);
        supermercado.delivery(2, 10);
        supermercado.delivery(4, 10);

        System.out.println("¿Cantidad de leche?: " + pro.getQuantity());
        System.out.println("¿Cantidad de azucar?: " + pro1.getQuantity());
        System.out.println("¿Cantidad de huevos?: " + pro2.getQuantity());

        // busco un producto
        Product esta = supermercado.findProduct(2);
        System.out.println("Esta el producto azucar?: " + esta);

        // veo cuanta cantidad de un producto hay
        int stockAzucar = supermercado.numberInStock(3);
        System.out.println("Stock de huevos: " + stockAzucar);

        // salen por pantalla los detalle de los productos
        System.out.println("############################################");
        supermercado.printProductDetails();
        System.out.println("############################################");
        // sale la lista con los productos con cantidad < 3
        List lista1 = new ArrayList<>();
        lista1 = supermercado.listaProductos(3);
        System.out.println("Lista con stock de menos de 3 productos: ");
        for(int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }

        System.out.println("------------------------------------ busqueda de producto ------------------------------------");
        Product p = supermercado.findProduct("azucar");
        System.out.println("salida: " + p);



    }
}
