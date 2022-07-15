import java.io.UnsupportedEncodingException;

public interface IEncoder {
    String encode(String message) throws UnsupportedEncodingException;
}
