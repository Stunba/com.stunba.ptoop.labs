import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String [] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        try {
            File dir = new File("/Users/abastun/Projects/ptoop/lab 4-6/com.stunba.labs/com.stunba.labs.plugin/out/production/classes");
            URL loadPath = dir.toURI().toURL();
            URL[] classUrl = new URL[]{loadPath};

            ClassLoader cl = new URLClassLoader(classUrl);

            Class loadedClass = cl.loadClass("Plugin");
            IPlugin plugin = (IPlugin) loadedClass.getConstructor().newInstance();
            ShapeCreator creator = plugin.getCreator();
            ArrayList<Integer> params = new ArrayList(Arrays.asList(1, 2, 3, 4));
            Shape shape = creator.create(params);
            ShapeDrawer drawer = new ConsoleShapeDrawer();
            drawer.draw(shape);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
