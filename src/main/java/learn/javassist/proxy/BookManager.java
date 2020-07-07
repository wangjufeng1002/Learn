package learn.javassist.proxy;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public class BookManager implements IManager {
    @Override
    public void add() {
        System.out.println("Start add books");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish add book");
    }

    @Override
    public void remove() {
        System.out.println("Start remove books");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish remove book");
    }
}
