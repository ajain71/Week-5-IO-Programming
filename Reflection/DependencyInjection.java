import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    void serve() {
        System.out.println("Service called");
    }
}

class Client {
    @Inject
    Service svc;
    void doSomething() {
        svc.serve();
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        Client c = new Client();
        Class<?> cls = c.getClass();
        Field[] flds = cls.getDeclaredFields();
        for (Field f : flds) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(c, f.getType().getDeclaredConstructor().newInstance());
            }
        }
        c.doSomething();
    }
}