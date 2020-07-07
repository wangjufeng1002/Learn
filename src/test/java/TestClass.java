import learn.javassist.proxy02.A;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/30
 */
public class TestClass {
    public static void main(String[] args) {
       /* Object[] objects = new Object[10];
        objects[0] = new String("1");
        objects[1] = new Integer(1);
        Class[] classes = new Class[10];
        classes[0] = objects[0].getClass();
        classes[1] = objects[1].getClass();
        for(Class cla :classes){
            System.out.println(cla.getName());
        }*/
       String[] strings = new String[1];
        List<A> aList = new ArrayList<A>();
        Class<?>[] classes = aList.getClass().getClasses();
        System.out.println(classes.length);
        //System.out.println(aList.getClass().getCanonicalName());
    /*   if(aList instanceof  A){
           System.out.println(true);
       }*/
    }

    @Test
    public  void test() throws IOException, AWTException, InterruptedException {
        Desktop.getDesktop().open(new File("D:\\项目\\法拍\\test\\test_notice\\发布说明文档.docx"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();


        Thread.sleep(5000);
        Robot robot = new Robot();
        //全选
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        //全选释放
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        //复制
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        //复制释放
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //切换窗口
        robot.mouseMove(screenWidth,0);
        //鼠标右键
        //System.out.println("右击");
        //robot.mousePress(InputEvent.BUTTON3_MASK);
        //robot.mouseRelease(InputEvent.BUTTON3_MASK);

        //点击鼠标
        //鼠标左键
        System.out.println("单击");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);




    }
    @Test
    public void testCloseWord(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        System.out.println("屏幕宽度：" + screenWidth + "，屏幕高度：" + screenHeight);
    }
    @Test
    public void testAu3() throws IOException {
        Runtime.getRuntime().exec("C:\\Users\\wangjufeng1\\Desktop\\autolt-test.exe 小红汽车.jpg 灰汽车.jpg");
    }
}
