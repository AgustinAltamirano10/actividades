public class Main {
    public static void main(String[] args) {
        // Crear una subasta
        Auction auction = new Auction(); // Constructor de Auction

        // Agregar lotes (enterLot)
        auction.enterLot("Pintura renacentista");
        auction.enterLot("Escultura griega");
        auction.enterLot("Libro antiguo");
        auction.enterLot("Espada medieval");

        // Mostrar todos los lotes (showLots)
        System.out.println("Lotes actuales:");
        auction.showLots();

        // Crear personas (Person)
        Person maria = new Person("María");
        Person pablo = new Person("Pablo");
        Person laura = new Person("Laura");

        // Hacer ofertas usando makeABid (estático)
        System.out.println("\nOfertas:");
        System.out.println("María ofrece 1000 por el lote 1: " + Auction.makeABid(auction, 1, maria, 1000));
        System.out.println("Pablo ofrece 1200 por el lote 1: " + Auction.makeABid(auction, 1, pablo, 1200)); // esta debe ganar
        System.out.println("Laura ofrece 800 por el lote 2: " + Auction.makeABid(auction, 2, laura, 800));
        System.out.println("Pablo ofrece 500 por el lote 3: " + Auction.makeABid(auction, 3, pablo, 500));

        // Obtener un lote (getLot) y su descripción
        Lot lote2 = auction.getLot(2);
        System.out.println("\nDescripción del lote 2: " + lote2.getDescription());

        // Obtener el número del lote y oferta más alta (getNumber, getHighestBid)
        System.out.println("Número del lote: " + lote2.getNumber());
        System.out.println("Oferta más alta por el lote 2: " + lote2.getHighestBid());

        // Usar toString de Lot directamente
        System.out.println("\ntoString() del lote 1:");
        System.out.println(auction.getLot(1).toString());

        // Usar toString y getName de Person
        System.out.println("\nNombre de la persona que ofertó: " + maria.getName());
        System.out.println("toString de Person: " + maria);

        // Usar getValue y getBidder de una oferta
        Bid mejorOfertaLote1 = auction.getHighestBid(1);
        if (mejorOfertaLote1 != null) {
            System.out.println("\nOferta ganadora del lote 1: $" + mejorOfertaLote1.getValue());
            System.out.println("Hecha por: " + mejorOfertaLote1.getBidder());
        }

        // Eliminar un lote (removeLot)
        System.out.println("\nEliminando el lote 4...");
        Lot eliminado = auction.removeLot(4);
        System.out.println("Lote eliminado: " + eliminado);

        // Cerrar la subasta (close)
        System.out.println("\nCerrando subasta...");
        auction.close();

        // Mostrar lotes sin vender (getUnsold)
        System.out.println("\nLotes sin vender:");
        for (Lot lot : auction.getUnsold()) {
            System.out.println(lot);
        }
    }
}
