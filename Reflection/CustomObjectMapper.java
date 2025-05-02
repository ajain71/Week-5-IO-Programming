import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> cls, Map<String, Object> props) throws Exception {
        T obj = cls.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> e : props.entrySet()) {
            Field f = cls.getDeclaredField(e.getKey());
            f.setAccessible(true);
            f.set(obj, e.getValue());
        }
        return obj;
    }
}