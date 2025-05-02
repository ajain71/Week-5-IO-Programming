import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassInformation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String clsName = br.readLine();
        Class<?> cls = Class.forName(clsName);
        Method[] mth = cls.getDeclaredMethods();
        for (Method x : mth) System.out.println(x);
        Field[] fld = cls.getDeclaredFields();
        for (Field x : fld) System.out.println(x);
        Constructor<?>[] con = cls.getDeclaredConstructors();
        for (Constructor<?> x : con) System.out.println(x);
    }
}