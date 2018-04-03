import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String [] args) {
        ArrayList<Shape> shapes = new ArrayList<>();


        System.out.println("Commands available:\nadd {int, int, ...}\ndraw\nexit\nsave {filename}\nload {filename}\n");
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
            } else if (command.startsWith("save")) {
              String filename = command.substring(5).trim();

                try {
                    FileOutputStream fileOut =
                            new FileOutputStream(filename);

                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(shapes);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in " + filename);
                } catch (IOException i) {
                    i.printStackTrace();
                }

            } else if (command.startsWith("load")) {

                String filename = command.substring(5).trim();

                try {
                    FileInputStream fileIn = new FileInputStream(filename);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    shapes = (ArrayList<Shape>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Serializable class not found");
                    c.printStackTrace();
                    return;
                }
                System.out.println("Deserialized objects:");
                drawer.drawShapes(shapes);

            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
