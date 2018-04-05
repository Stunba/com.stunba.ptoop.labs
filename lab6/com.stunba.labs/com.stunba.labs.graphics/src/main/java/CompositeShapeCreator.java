import java.util.ArrayList;

public class CompositeShapeCreator extends ShapeCreator {
    private ArrayList<ShapeCreator> creators;

    public CompositeShapeCreator(ArrayList<ShapeCreator> creators) {
        this.creators = creators;
    }

    public CompositeShapeCreator() {
    }

    @Override
    public Shape create(ArrayList<Integer> args) {
        for (ShapeCreator creator: creators) {
            Shape shape = creator.create(args);
            if (shape != null) return shape;
        }
        return null;
    }
}
