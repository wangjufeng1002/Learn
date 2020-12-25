package proxy.staticState;

import java.lang.instrument.Instrumentation;

public class Test {
    public static void main(String[] args) {
        new Test().test();
    }
    public void test(){
        System.out.println("Hello World");
    }
}
