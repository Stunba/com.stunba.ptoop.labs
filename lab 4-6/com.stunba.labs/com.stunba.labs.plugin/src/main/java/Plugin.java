public class Plugin implements IPlugin {

    @Override
    public String[] getPluginClasses() {
        return new String[0];
    }

    @Override
    public ShapeCreator getCreator() {
        return new SquareCreator();
    }
}
