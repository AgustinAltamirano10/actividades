import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Clase que modela una subasta
 */
public class Auction
{
    private Map<Integer, Lot> lots;
    private boolean cierreSubasta = false;

    /**
     * @post Una subasta es creada.
     */
    public Auction()
    {
        lots = new HashMap<>();
    }

    /**
     * @post Un nuevo lote es agregado a la subasta.
     */
    public void enterLot(String description)
    {
<<<<<<< HEAD
        lots.put(lots.size() + 1, new Lot(lots.size()+1, description)); // lots.put(new Lot(lots.size()+1, description)); 
=======
        lots.put(lots.size() + 1, new Lot(lots.size() + 1, description)); // lots.put(new Lot(lots.size()+1, description)); 
>>>>>>> a51e5c6 (update)
    }

    /**
     * @post Todos los lotes son mostrados.
     */
    public void showLots()
    {
        for (Lot lot : lots.values()){ // for (Lot lot : lots)
            System.out.println(lot);
        }
    }
    
    /**
     * @pre {@code 0 < lotNNumber <= lots.size()}.
     * @post Una oferta por el lote es realizada. 
     * @param auction
     */
    public static boolean makeABid(Auction auction, int lotNumber, Person bidder, long value)
    {
        if (!auction.cierreSubasta) {
            Lot selectedLot = auction.getLot(lotNumber);
            Bid bid = new Bid(bidder, value);
            return selectedLot.bidFor(bid);
        }
        return false;
    }

    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post El lote con el número deseado es devuelto.
     */
    public Lot getLot(int lotNumber)
    {
        return lots.get(lotNumber);
    }
    
    /**
     * @post La subasta está cerrada y los lotes vendidos son mostrados por pantalla.
     */
    public void close() {
        Iterator<Lot> iterador = lots.values().iterator(); // Iterator<Lot> iterador = lots.iterator();
        while (iterador.hasNext()) {
            Lot lot = iterador.next();
            if (lot.getHighestBid() != null) {
                System.out.println(lots.toString());
            }
        }
        cierreSubasta = true;
    }
    
    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post La oferta ganadora para el lote 'lotNumber' es retornada.
     */
    public Bid getHighestBid(int lotNumber) {
        Lot lot = lots.get(lotNumber); 
        return lot.getHighestBid();
    }
    
    /**
     * @post Una lista con todos los lotes sin vender es devuelta.
     */
    public ArrayList<Lot> getUnsold() {
        ArrayList<Lot> lotesSinVender = new ArrayList<>();
        Iterator<Lot> iterador = lots.values().iterator(); //Iterator<Lot> iterador = lots.iterator();
        while (iterador.hasNext()) {
            Lot lot = iterador.next();
            if (lot.getHighestBid() == null) {
                lotesSinVender.add(lot);
            }
        }
        return lotesSinVender;
    }
    
    /**
     * @pre {@code 0 < lotNumber <= lots.size()}.
     * @post El lote con el número 'lotNumber' ha sido eliminado, este lote es retornado.
     */
    public Lot removeLot(int lotNumber) {
        Lot loteEliminado = lots.get(lotNumber); 
        lots.remove(lotNumber); 
        return loteEliminado; 
    }
}
