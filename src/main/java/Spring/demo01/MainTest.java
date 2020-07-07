package Spring.demo01;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/3/16
 */
public class MainTest {
    /**
     * 一: XmlBeanFactory 引用资源
     * Resource resource = new ClassPathResource("appcontext.xml");
     * BeanFactory factory = new XmlBeanFactory(resource);
     *
     * 二: ClassPathXmlApplicationContext  编译路径
     * ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:appcontext.xml");
     * // src目录下的
     * ApplicationContext factory=new ClassPathXmlApplicationContext("appcontext.xml");
     * ApplicationContext factory=new ClassPathXmlApplicationContext(new String[] {"bean1.xml","bean2.xml"});
     * // src/conf 目录下的
     * ApplicationContext factory=new ClassPathXmlApplicationContext("conf/appcontext.xml");
     * ApplicationContext factory=new ClassPathXmlApplicationContext("file:G:/Test/src/appcontext.xml");
     *
     * 三: 用文件系统的路径
     * ApplicationContext factory=new FileSystemXmlApplicationContext("src/appcontext.xml");
     * //使用了  classpath:  前缀,作为标志,  这样,FileSystemXmlApplicationContext 也能够读入classpath下的相对路径
     * ApplicationContext factory=new FileSystemXmlApplicationContext("classpath:appcontext.xml");
     * ApplicationContext factory=new FileSystemXmlApplicationContext("file:G:/Test/src/appcontext.xml");
     * ApplicationContext factory=new FileSystemXmlApplicationContext("G:/Test/src/appcontext.xml");
     * @param args
     */
    public static void main(String[] args) {
        //XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("./spring.xml"));
      //  ApplicationContext factory=new FileSystemXmlApp+licationContext("D:\\IDEA_WORK_SPACE\\Learn\\src\\main\\java\\Spring\\demo01\\spring.xml");

    }
}
