import java.util.ArrayList;

public class TriangleCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 6) {
            return null;
        }
        // there's could be a check for correct triangle
        return new Triangle(new Point(args.get(0), args.get(1)), new Point(args.get(2), args.get(3)), new Point(args.get(4), args.get(5)));
    }
}
