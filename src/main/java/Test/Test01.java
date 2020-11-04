package Test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/25
 */
public class Test01 {
    public static void main(String[] args) {
       /* String a = "aaaaaaaaaaaaaa|bbbbbbbbbb";
        System.out.println(a.split("\\|").length);;*/
        String b =  " 20";
        System.out.println(b.replaceAll("\\s",""));
    }


    @Test
    public void test(){

        Map<String,String> aliasMap = new HashMap<>();
       /* aliasMap.put("A","C");
        aliasMap.put("C","B");*/
        aliasMap.put("A","B");
        MapTest mapTest = new MapTest(aliasMap);
        System.out.println(mapTest.hasAlias("A","C"));
        ;

    }
    @Test
    public void createCode(){
        String str =
        "    @Excel(name = \"第%s周\",default=\"null\") \n" +
                "    private BigDecimal amount%s;";
        for(int i = 1;i<=53;i++){
            System.out.println(String.format(str,i,i));
        }
    }


}
