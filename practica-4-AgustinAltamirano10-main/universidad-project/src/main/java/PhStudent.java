
public class PhStudent extends Student {
    
    private double progress;

    public PhStudent(String name, String lastName, int id2, double progress) {
        super(name, lastName, id2);
        this.progress = progress;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    
}
