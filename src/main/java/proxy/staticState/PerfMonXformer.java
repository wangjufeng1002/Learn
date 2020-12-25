package proxy.staticState;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class PerfMonXformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] transformed = null;
        System.out.println("Transforming " + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass c1 = null;

        try {
            c1 = pool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
            if (c1.isInterface() == false) {
                CtBehavior[] methods = c1.getDeclaredBehaviors();
                for (int i = 0; i < methods.length; i++) {
                    if (methods[i].isEmpty() == false) {
                        //修改method
                        doMethod(methods[i]);
                    }
                }
                transformed = c1.toBytecode();
            }
        } catch (Exception e) {
            System.out.println("Could not instrument " + className + ", exception: " + e.getMessage());
        } finally {
            if (c1 != null) {
                c1.detach();
            }
        }
        return transformed;
    }

    private void doMethod(CtBehavior method) throws CannotCompileException {
        method.insertBefore("long stime = System.nanoTime();");
        method.insertAfter("System.out.println(\"leave \"+method.getName()+ \" and time:\"+(System.nanoTime()-stime));");
    }
}
