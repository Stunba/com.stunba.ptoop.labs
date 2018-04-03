import java.util.ArrayList;

public abstract class ShapeDrawer {
    public abstract void draw(Shape shape);

    public void drawShapes(ArrayList<Shape> shapes) {
        shapes.forEach(this::draw);
    }
}
