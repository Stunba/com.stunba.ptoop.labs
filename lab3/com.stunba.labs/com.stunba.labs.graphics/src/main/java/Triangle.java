import java.io.Serializable;
import java.util.ArrayList;

public class Triangle extends Shape implements Serializable {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle at points =>");
        ArrayList<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.forEach(Point::printInfo);
    }
}
