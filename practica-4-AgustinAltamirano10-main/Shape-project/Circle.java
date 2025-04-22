public class Circle extends Shape {

    private double radio;
    private static final double PI = 3.14;

    public Circle(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public double getPerimeter()
    {
        return (2 * PI *radio);  
    }

    public double getArea()
    {
        return (radio * radio * PI);
    }

}
