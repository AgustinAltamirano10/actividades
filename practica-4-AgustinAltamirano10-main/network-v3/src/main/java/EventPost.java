

public class EventPost extends Post {

    private String eventType;    
    private String eventDetails; 

    public EventPost(String author, String eventType, String eventDetails) {
        super(author);  
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    @Override
    public void display() {
        super.display();  // Llamamos al display de la clase base
        System.out.println("Event: " + eventType + " - " + eventDetails);
    }
}
