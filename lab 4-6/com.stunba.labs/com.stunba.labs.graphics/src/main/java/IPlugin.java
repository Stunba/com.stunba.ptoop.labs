public interface IPlugin {
    public String[] getPluginClasses();
    public ShapeCreator getCreator();
    public Codable getCoder();
}
