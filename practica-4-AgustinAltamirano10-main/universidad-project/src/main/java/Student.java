
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

    public boolean equals(Object obj)
    {
        if(obj == null){
            return false;
        }
        
        if (!(obj instanceof Student)) {
            return false;
        }
        
        Student other = (Student) obj;
        return id == other.id;
    }
}
