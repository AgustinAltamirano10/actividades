
public class Teacher extends Person{
    
    private String teacherName;

    public Teacher(String name, String lastName, String teacherName) {
        super(name, lastName);
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    
}
