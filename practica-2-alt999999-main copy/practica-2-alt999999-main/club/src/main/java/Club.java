import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * Store details of club memberships.
 */
public class Club
{
    private List<Membership> lista;
    
    /**
     * @post Create a Club.
     */
    public Club()
    {
        lista = new LinkedList<Membership>();
    }

    /**
     * @post Add a new member to the club's list of members.
     */
    public void join(Membership member)
    {
        lista.add(member);
    }

    /**
     * @post Returns the number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return lista.size();
    }
    
    /**
     * @pre 1 <= month <= 12
     * @post Return the number of members who joined in the given month. 
     */
    public int joinedInMonth(int month)
    {
        int contador = 0;
        Iterator<Membership> iterador = lista.iterator();
        while (iterador.hasNext()) {
            Membership m = iterador.next();
            if (m.getMonth() == month) {
                contador++;
            }
        }
        return contador;
    }


}
