package proxy.javassist.base;

import javassist.*;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

      /*  ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("learn.javassist.base.BaseEntityA");
        CtClass executor = pool.get("java.math.BigDecimal");
        CtField field = new CtField(executor, "amount_1", ctClass);
        field.setModifiers(Modifier.PUBLIC);
        ctClass.addField(field);


        Class<?> clazz = ctClass.toClass();

        BaseEntityA o = (BaseEntityA)clazz.newInstance();
        System.out.println(o);*/
        String after_sales_problem = StringUtils.upperCase("shop_profit_statement");
        System.out.println(after_sales_problem);
    }
}
