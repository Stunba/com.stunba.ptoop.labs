import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class MyInputObjectStream extends ObjectInputStream {

    public MyInputObjectStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        String name = desc.getName();
        try {
            return Class.forName(name, false, Thread.currentThread()
                    .getContextClassLoader());
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
    }
}
