import java.util.ArrayList;

public class SquareCreator extends ShapeCreator {
    @Override
    public Shape create(ArrayList<Integer> args) {
        if (args.size() != 4) {
            return null;
        }
        return new Square(new Point(args.get(0), args.get(1)), args.get(2), args.get(3));
    }
}
