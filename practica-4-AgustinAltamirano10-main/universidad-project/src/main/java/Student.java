
public class Student extends Person{
    private int id;

    public Student(String name, String lastName, int id2) {
        super(name, lastName);
        id = id2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
