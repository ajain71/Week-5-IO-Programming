import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

class LoggingHandler implements InvocationHandler {
    Object obj;
    LoggingHandler(Object obj) {
        this.obj = obj;
    }
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.println("Calling method: " + m.getName());
        return m.invoke(obj, args);
    }
}

public class CustomLoggingProxy {
    public static void main(String[] args) {
        Greeting g = new GreetingImpl();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingHandler(g)
        );
        proxy.sayHello();
    }
}