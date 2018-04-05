import java.util.ArrayList;

public class AnotherPluginAdapter implements IPlugin {
    private AnotherPlugin plugin;

    public AnotherPluginAdapter() {
        this.plugin = new AnotherPlugin();
    }

    @Override
    public String[] getPluginClasses() {
        return new String[0];
    }

    @Override
    public ShapeCreator getCreator() {
        ArrayList<ShapeCreator> creators = new ArrayList<>();
        creators.addAll(plugin.creators());
        return new CompositeShapeCreator(creators);
    }

    @Override
    public Codable getCoder() {
        return new CoderAdapter(plugin.getCoder());
    }
}
