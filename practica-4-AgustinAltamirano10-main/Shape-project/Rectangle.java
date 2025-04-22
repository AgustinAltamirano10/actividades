public class Rectangle extends Shape
{
    private double alto;
    private double ancho;

    public Rectangle(double x, double y, double alto, double ancho) {
        super(x, y);
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getPerimeter()
    {
        return (2 * (alto + ancho));  
    }

    public double getArea()
    {
        return (alto * ancho);
    }
}
