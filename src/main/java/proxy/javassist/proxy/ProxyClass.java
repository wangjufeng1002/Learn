package proxy.javassist.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public  class ProxyClass implements  IManager {
    private InvocationHandler h;

    public ProxyClass(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void add() {
        try {
            //获取需要执行的method对象
            Method mecthod = IManager.class.getDeclaredMethod("add");
            //调用InvocationHandler 的 invoke方法
            h.invoke(this,mecthod,null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove() {
        try {
            Method mecthod = IManager.class.getDeclaredMethod("remove");
            h.invoke(this,mecthod,null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
