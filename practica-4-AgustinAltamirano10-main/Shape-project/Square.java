public class Square extends Shape
{
    private double lado;

    public Square(double x, double y, double lado) {
        super(x, y);
        this.lado = lado;
    }

    public double getPerimeter()
    {
        return (2 * lado * lado);  
    }

    public double getArea()
    {
        return (4 * lado);
    }
}
