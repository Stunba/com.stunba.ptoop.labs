public class Square extends Shape {
    private Rectangle rect;

    public Square(Point origin, int side, int direction) {
        this.rect = new Rectangle(origin, side, side, direction);
    }

    @Override
    public void printInfo() {
        System.out.print("Square ");
        rect.printInfo();
    }
}
