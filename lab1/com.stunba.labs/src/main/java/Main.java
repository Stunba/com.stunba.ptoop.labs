import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        ArrayList<Graphics> shapes = new ArrayList<>();
        shapes.add(new Point(0 , 0));
        shapes.add(new Triangle(new Point(1 , 0), new Point(2 , 1), new Point(3, 3)));
        shapes.forEach(Graphics::draw);
    }
}
