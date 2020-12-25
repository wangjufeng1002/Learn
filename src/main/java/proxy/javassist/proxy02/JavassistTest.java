package proxy.javassist.proxy02;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/28
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
      /*  System.out.println("*******************方式一*******************");
        JavassistProxyFactory<A> jpf = new JavassistProxyFactory<A>();
        A a = new A();
        jpf.setTarget(a);
        A proxy = jpf.getProxy();
        proxy.del();*/

        System.out.println("*******************方式二*******************");
        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
        A a2 = (A) jpf02.getProxy(A.class);
        a2.del();
        a2.save();
        System.out.println("canonicalName:"+A.class.getCanonicalName());
        System.out.println("name:"+A.class.getName());
        System.out.println("simpleName:"+A.class.getSimpleName());

     /*   Class proxyClass = Class.forName("learn.javassist.proxy02.TestInterface", true, ClassLoader.getSystemClassLoader());
        Method[] methods = proxyClass.getMethods();
        StringBuilder sb = new StringBuilder();
        for(Method method : methods){
            Class<?>[] mType =method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            System.out.println(getName(returnType));
            // System.out.println(method.getName()+":"+Modifier.toString(method.getModifiers()));
            for (Class<?> mp : mType) {
               String str =  " " + mp.getCanonicalName() + " arg" + 1 + " ,";
//                sb.append(" " + ReflectUtils.getBoxedClass(mp).getCanonicalName() + " arg" + c + " ,");
                System.out.println(str);
            }
        }*/
    }
    public  static  String getName(Class<?> c)
    {
        if( c.isArray() )
        {
            StringBuilder sb = new StringBuilder();
            do
            {
                sb.append("[]");
                c = c.getComponentType();
            }
            while( c.isArray() );

            return c.getName() + sb.toString();
        }
        return c.getName();
    }


}
