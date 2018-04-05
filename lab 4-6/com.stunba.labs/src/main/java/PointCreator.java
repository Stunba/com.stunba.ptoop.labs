import java.util.ArrayList;

public class PointCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 2) {
            return null;
        }
        return new Point(args.get(0), args.get(1));
    }
}
