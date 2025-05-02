import java.lang.reflect.Method;

class Task {
    void runTask() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Task t = new Task();
        Method m = Task.class.getDeclaredMethod("runTask");
        long start = System.nanoTime();
        m.invoke(t);
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start) + " ns");
    }
}