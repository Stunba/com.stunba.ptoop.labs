import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        System.out.println("Commands available:\nadd {int, int, ...}\ndraw\nexit\n");
        Scanner sc = new Scanner(System.in);
        ShapeDrawer drawer = new ConsoleShapeDrawer();
        ShapeCreator shapeCreator = CompositeShapeCreator.mainCreator();
        while(true) {
            String command = sc.nextLine();
            if (command.startsWith("add")) {
                String[] numbers = command.substring(4).trim().split(",");
                ArrayList<Integer> coordinates = new ArrayList<>();
                for (String num : numbers) {
                    coordinates.add(Integer.parseInt(num.trim()));
                }
                Shape shape = shapeCreator.create(coordinates);
                if (shape != null) {
                    System.out.println("Added new shape");
                    shape.printInfo();
                    shapes.add(shape);
                } else {
                    System.out.println("Cannot create shape for this input");
                }
            } else if (command.startsWith("draw")) {
                drawer.drawShapes(shapes);
            } else if (command.startsWith("exit")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
