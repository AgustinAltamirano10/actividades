import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 */
public class StockManager
{

    private Map<Integer, Product> stock; // integer es la posicion del producto
    private Product p;
    /**
     * @post A StockManager is created.
     */
    public StockManager()
    {
        stock = new HashMap<>();
    }

    /**
     * @post item are added to stock.
     */
    public void addProduct(Product item)
    {
        if (stock.containsKey(item.getID())) {
            System.out.println("No se puede agregar la ID ya existe");
        } else {
            int id = item.getID();
            if (stock.containsKey(id)) {
                Product existente = stock.get(id);
                existente.increaseQuantity(1);
            } else {
                item.increaseQuantity(1); 
                stock.put(id, item);
            }
        }
    }
    
    /**
     * @post busca un procuto con su ID y luego aumenta la cantidad
     */
    public void delivery(int id, int amount)
    {
        p = stock.get(id);
        if(stock.containsKey(id)) {
            p.increaseQuantity(amount);
        }
    }
    
    /**
     * @post busca un producto
     */
    public Product findProduct(int id)
    {
        if (stock.containsKey(id)) {
            return (stock.get(id));
        }
        return null;
    }
    
    /**
     * @post devuelve la cantidad de productos en stock
     */
    public int numberInStock(int id)
    {
        
        if (stock.containsKey(id)) {
            p = stock.get(id);
            return (p.getQuantity());
        } else {
            return 0;
        }
    }

    /**
     * @post muestra los detalles de la coleccion de productos
     */
    public void printProductDetails()
    {
        Iterator<Product> it = stock.values().iterator();
        while (it.hasNext()) {
            p = it.next();
            System.out.println(p.toString());
        }
    }

    /*
     * @post retorna una lista con los productos con stock menores a la cantidad pasada como parametro
     */
    public List listaProductos(int cantidad)
    {
        List lista = new ArrayList<>();
        Iterator<Product> iterador = stock.values().iterator();
        while (iterador.hasNext()) {
            Product p = iterador.next();
            if (p.getQuantity() < cantidad) {
                lista.add(p);
            }
        }
        return lista;
    }

    public Product findProduct(String name)
    {
        Iterator<Product> iterador = stock.values().iterator();
        while (iterador.hasNext()) {
            Product p = iterador.next();
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
