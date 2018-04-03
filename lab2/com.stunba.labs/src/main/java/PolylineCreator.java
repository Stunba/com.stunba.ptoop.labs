import java.util.ArrayList;

public class PolylineCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() == 0 && args.size() % 2 == 0) {
            return null;
        }
        Polyline shape = new Polyline();
        for (int i = 0; i < args.size(); i+=2) {
            shape.addPoint(new Point(args.get(i), args.get(i+1)));
        }
        return shape;
    }
}
