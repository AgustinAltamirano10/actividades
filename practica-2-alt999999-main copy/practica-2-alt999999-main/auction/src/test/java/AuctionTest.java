
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class AuctionTest.
 */
public class AuctionTest
{
    @Test
    public void testHighestBid()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("3 autos");
        Person person1 = new Person("Simeone");
        Person person2 = new Person("Fernandez");
        Person person3 = new Person("Fernansadasddez");
        Auction.makeABid(auction1, 1, person1, 10);
        Auction.makeABid(auction1, 1, person2, 5);
        auction1.close();Auction.makeABid(auction1, 1, person3, 500);
        assertTrue(auction1.getHighestBid(1).getBidder().equals(person1));
    }
    
    @Test
    public void testUnsoldElements()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("camisetas");
        auction1.enterLot("pantalones");
        auction1.enterLot("remeras");
        Person person1 = new Person("jorge");
        Auction.makeABid(auction1, 2, person1, 10);
        ArrayList<Lot> unsold = auction1.getUnsold();
        System.out.println(unsold);
        assertTrue(unsold.contains(auction1.getLot(1)));
        assertFalse(unsold.contains(auction1.getLot(2)));
        assertTrue(unsold.contains(auction1.getLot(3)));
    }

    @Test
    public void test1()
    {
        Auction auction = new Auction();
        auction.enterLot("camisetas");
        Lot lote2 = auction.getLot(1);
        assertEquals("camisetas", lote2.getDescription());
    }
}