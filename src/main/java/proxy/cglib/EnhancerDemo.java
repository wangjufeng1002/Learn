package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        EnhancerDemo enhancerDemo = (EnhancerDemo)enhancer.create();
        enhancerDemo.test();
        System.out.println(enhancerDemo);
    }
    public void test(){
        System.out.println("EnhancerDemo test()");
    }
}
