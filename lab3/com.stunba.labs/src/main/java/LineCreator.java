import java.util.ArrayList;

public class LineCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 4) {
            return null;
        }
        return new Line(new Point(args.get(0), args.get(1)), new Point(args.get(2), args.get(3)));
    }
}
