import java.util.ArrayList;
import java.util.Arrays;

public class AnotherPlugin {

    public ArrayList<ShapeCreator> creators() {
        return new ArrayList<ShapeCreator>(Arrays.asList(new SquareCreator()));
    }

    public DataTransformer getCoder() {
        return new DataTransformer();
    }

}
