import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveCalculator {
    Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int computeSquare(int x) {
        if (cache.containsKey(x)) return cache.get(x);
        int result = x * x;
        cache.put(x, result);
        return result;
    }
}

class CustomCachingSystem {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator ec = new ExpensiveCalculator();
        Method m = ec.getClass().getMethod("computeSquare", int.class);
        if (m.isAnnotationPresent(CacheResult.class)) {
            System.out.println(ec.computeSquare(10));
            System.out.println(ec.computeSquare(10));
            System.out.println(ec.computeSquare(5));
            System.out.println(ec.computeSquare(5));
        }
    }
}
