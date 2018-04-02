import java.util.ArrayList;

public class Polyline extends Graphics {
    private ArrayList<Point> points = new ArrayList<>();

    public Polyline(){}

    public Polyline(Point point ){
        points.add(point);
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public Point getPoint(int i) {
        return points.get(i);
    }

    public int getPointsCount() {
        return points.size();
    }

    public void removeLastPoint() {
        if (points.size() > 0){
            points.remove(points.size() - 1);
        }
    }

    @Override
    public void draw() {
        System.out.println("Line with points =>");
        points.forEach(Point::draw);
    }
}
