import java.util.ArrayList;

public class CircleCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 3) {
            return null;
        }
        return new Circle(new Point(args.get(0), args.get(1)), args.get(2));
    }
}
