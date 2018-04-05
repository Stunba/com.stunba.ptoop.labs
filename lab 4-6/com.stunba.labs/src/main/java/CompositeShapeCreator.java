import java.util.ArrayList;

public class CompositeShapeCreator extends ShapeCreator {
    private ArrayList<ShapeCreator> creators;

    public CompositeShapeCreator(ArrayList<ShapeCreator> creators) {
        this.creators = creators;
    }

    public CompositeShapeCreator() {
    }

    static CompositeShapeCreator mainCreator() {
        ArrayList<ShapeCreator> creators = new ArrayList<>();
        creators.add(new PointCreator());
        creators.add(new TriangleCreator());
        creators.add(new CircleCreator());
        creators.add(new LineCreator());
        creators.add(new RectangleCreator());
        creators.add(new PolylineCreator());
        return new CompositeShapeCreator(creators);
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
