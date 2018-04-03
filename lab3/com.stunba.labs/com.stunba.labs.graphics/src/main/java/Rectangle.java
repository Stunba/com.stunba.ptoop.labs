import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {
    private Point origin;
    private int width;
    private int height;
    private int direction;

    public Rectangle(Point origin, int width, int height, int direction) {
        this.origin = origin;
        this.width = width;
        this.height = height;
        this.direction = direction;
    }

    public Point getOrigin() {
        return origin;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void printInfo() {
        System.out.println("React: origin =>");
        origin.printInfo();
        System.out.println("width: " + width + " , height: " + height);
    }
}
