import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String op = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();
        MathOperations m = new MathOperations();
        Method meth = MathOperations.class.getMethod(op, int.class, int.class);
        Object res = meth.invoke(m, a, b);
        System.out.println(res);
    }
}