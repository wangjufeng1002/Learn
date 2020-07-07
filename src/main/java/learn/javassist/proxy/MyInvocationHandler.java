package learn.javassist.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //添加计算执行时间的逻辑
        long startTime = System.currentTimeMillis();
        System.out.println("StartTime = " + startTime);
        //调用实例的执行方法逻辑
        method.invoke(target,args);
        long endTime = System.currentTimeMillis();
        System.out.println("EndTime = " + endTime);
        System.out.println("Total Time = "+ (endTime - startTime));
        return null;
    }
}
