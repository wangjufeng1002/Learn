package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "E:\\项目文件\\spu净利\\9月基础数\\行业第一SPU基础数据-9月\\支付宝--9月";
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.getName().contains(".zip")) {
                Integer shopId = null;
                if (f.getName().contains("AA家居旗舰店")) {
                    shopId = 41;
                }
                if (f.getName().contains("佳帮手居家日用专营店")) {
                    shopId = 2;
                }
                if (f.getName().contains("佳帮手旗舰店")) {
                    shopId = 1;
                }
                if (f.getName().contains("洁仕宝旗舰店")) {
                    shopId = 3;
                }
                if (f.getName().contains("墨川旗舰店")) {
                    shopId = 50;
                }
                if (f.getName().contains("首品家居专营店")) {
                    shopId = 17;
                }
                File[] files1 = f.listFiles();
                for (File childFiled : files1) {
                    if(childFiled.getName().contains("账务明细")){
                        if(childFiled.getName().contains("账务明细(汇总)")){

                        }else {
                            System.out.println(childFiled.getName()+ "shop_id = "+shopId);
                        }

                        //FileInputStream fileInputStream = new FileInputStream(childFiled);
                    }
                }
            }
        }
    }
}
