package lock.demo01;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/17
 */
public class Widget {
    public synchronized void doSomething(){
        System.out.println("Widget.doSomething 被调用");
    }
}
