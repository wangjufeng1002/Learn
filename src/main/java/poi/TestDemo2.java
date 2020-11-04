/*
package poi;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.net.URL;

*/
/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/26
 *//*

public class TestDemo2 {
    public static void htmlCodeComeString(String linkcss,String htmlCode,
                                          String outputFile,String title) throws Exception{
       */
/* OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(getConversionHtmlCode(link css,htmlCode,title));
        ITextFontResolver fontResolver = renderer.getFontResolver();
        URL fontPath = ItextUtil.class.getResource("simsun.ttc");
        fontResolver.addFont(fontPath.toString(),
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解决图片的相对路径问题
        renderer.getSharedContext().setBaseURL("file:/F:/teste/html/");
        renderer.layout(); renderer.createPDF(os);
        System.out.println("======转换成功!");
        os.close();
        os.flush();*//*

    }

    public static void main(String[] args) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\Test\\pdf6.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream("D:\\Test\\pdf_sample.html"));
        //step 5
        document.close();

        System.out.println( "PDF Created!" );
    }
    public void test() throws IOException, DocumentException{

    }
}
*/
