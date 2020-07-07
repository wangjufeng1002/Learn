package lock.demo01;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/17
 */
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething(){
        System.out.println(toString() + ": call doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}
