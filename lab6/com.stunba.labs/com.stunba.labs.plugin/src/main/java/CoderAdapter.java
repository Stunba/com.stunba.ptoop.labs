public class CoderAdapter implements Codable {
    private DataTransformer inner;
    public CoderAdapter(DataTransformer inner) {
        this.inner = inner;
    }

    @Override
    public byte[] encode(byte[] data) throws Exception {
        return inner.transform(data);
    }

    @Override
    public byte[] decode(byte[] data) throws Exception {
        return inner.transform(data);
    }
}
