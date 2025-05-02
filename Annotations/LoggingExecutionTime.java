import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class TimeLogger {
    @LogExecutionTime
    void quickTask() {
        for (int i = 0; i < 1000; i++) {}
    }

    @LogExecutionTime
    void slowTask() {
        for (int i = 0; i < 1000000; i++) {}
    }
}

class LoggingExecutionTime {
    public static void main(String[] args) throws Exception {
        TimeLogger obj = new TimeLogger();
        Method[] methods = TimeLogger.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(obj);
                long end = System.nanoTime();
                System.out.println(m.getName() + " took " + (end - start) + " ns");
            }
        }
    }
}
