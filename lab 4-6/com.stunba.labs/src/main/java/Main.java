import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String [] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        try {
            // try to load plugin
            File dir = new File("/Users/abastun/Projects/ptoop/lab 4-6/com.stunba.labs/com.stunba.labs.plugin/out/production/classes");
            URL loadPath = dir.toURI().toURL();
            URL[] classUrl = new URL[]{loadPath};

            ClassLoader cl = new URLClassLoader(classUrl);

            Class loadedClass = cl.loadClass("Plugin");

            // loaded plugin
            IPlugin plugin = (IPlugin) loadedClass.getConstructor().newInstance();

            // creating shape from plugin
            ShapeCreator creator = plugin.getCreator();
            ArrayList<Integer> params = new ArrayList(Arrays.asList(1, 2, 3, 4));
            Shape shape = creator.create(params);
            ShapeDrawer drawer = new ConsoleShapeDrawer();
            drawer.draw(shape);

            // try to save object to file with encryption
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream arrOut = new ObjectOutputStream(baos);
            arrOut.writeObject(shape);
            arrOut.close();

            // getting coder from plugin
            Codable coder = plugin.getCoder();

            byte [] data = coder.encode(baos.toByteArray());

            // save object in file encoding data with provider coder
            String filename = "./out.data";
            FileOutputStream fileOut =
                    new FileOutputStream(filename);

            fileOut.write(data);

            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);

            // trying to load saved data from file using provider decoder
            byte[] loaded = Files.readAllBytes(Paths.get(filename));
            Thread.currentThread().setContextClassLoader(cl);
            ObjectInputStream in = new MyInputObjectStream(new ByteArrayInputStream(coder.decode(loaded)));

            Shape loadedShape = (Shape) in.readObject();
            in.close();

            System.out.println("Loaded object from file: " + filename);
            shape.printInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
