public abstract class Shape {
    
    protected double x;
    protected double y;

    /**
     * Constructor
     */
    protected Shape(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // Metodos
    public abstract double getPerimeter();
    public abstract double getArea();

    //main
    public static void main(String[] args) {
        Circle circulo = new Circle(20, 20, 5);
        Rectangle rectangulo= new Rectangle(20, 20, 40, 40);
        Square cuadrado = new Square(20, 20, 5);

        System.out.println("Area del cirulo: " + circulo.getArea());
        System.out.println("Perimetro del cirulo: " + circulo.getPerimeter());
        System.out.println("####################################################");
        System.out.println("Area del rectangulo: " +rectangulo.getArea());
        System.out.println("Perimetro del rectangulo: " +rectangulo.getPerimeter());
        System.out.println("####################################################");
        System.out.println("Area del cuadrado: " +cuadrado.getArea());
        System.out.println("Perimetro del cuadrado: " +cuadrado.getPerimeter());
    }
}
