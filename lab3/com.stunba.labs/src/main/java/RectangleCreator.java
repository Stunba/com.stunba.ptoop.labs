import java.util.ArrayList;

public class RectangleCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 5) {
            return null;
        }
        return new Rectangle(new Point(args.get(0), args.get(1)), args.get(2), args.get(3), args.get(4));
    }
}
