import java.io.Serializable;

public class Line extends Polyline implements Serializable {
    public Line(Point point) {
        addPoint(point);
        addPoint(point);
    }

    public Line(Point a, Point b) {
        addPoint(a);
        addPoint(b);
    }
}
