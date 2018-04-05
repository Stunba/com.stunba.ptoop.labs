import java.io.Serializable;

public class Square extends Shape implements Serializable {
    private Rectangle rect;

    public Square(Rectangle rect) {
        this.rect = rect;
    }

    public Square(Point origin, int side, int direction) {
        this.rect = new Rectangle(origin, side, side, direction);
    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void printInfo() {
        System.out.print("Square ");
        rect.printInfo();
    }
}
