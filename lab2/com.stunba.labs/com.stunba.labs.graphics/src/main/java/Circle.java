public class Circle extends Shape {
    private Point origin;
    private int radius;

    public Circle(Point origin, int radius) {
        this.origin = origin;
        this.radius = radius;
    }

    public Circle(int radius) {
        this.origin = new Point(0, 0);
        this.radius = radius;
    }

    public Point getOrigin() {
        return origin;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle at (" + origin.x + ", " + origin.y + ") with radius: " + radius);
    }
}
