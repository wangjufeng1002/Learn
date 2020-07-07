package poi;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactoryImp;

import java.awt.*;
import java.io.IOException;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/26
 */
public class MyFontFactory extends FontFactoryImp {


    @Override
    public Font getFont(String s, String s1, boolean b, float v, int i, Color color) {
       /* BaseFont  base = BaseFont.createFont("STSong-Light","UniGB-UCS2-H") ;
        try {
              base = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return new Font(base, v, style, color);*/
       return null;
    }
}
