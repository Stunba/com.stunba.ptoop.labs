public interface Codable {
    public byte[] encode(byte [] data) throws Exception;
    public byte[] decode(byte [] data) throws Exception;
}
