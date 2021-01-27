package jvm.classload;

/**
 * @author wjf
 * @version 1.0
 * @date 2021/1/23 15:42
 * @desc
 */
public class MyClassLoad extends ClassLoader{
    protected MyClassLoad(ClassLoader parent) {
        super(parent);
    }

}
