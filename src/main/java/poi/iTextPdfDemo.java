package poi;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jsoup.Jsoup;

import java.io.*;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/26
 */
public class iTextPdfDemo {

    public void export() throws IOException, DocumentException {
        //创建document
        Document document = new Document(PageSize.A4);
        //设置要导出的文件名
        OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\wangjufeng1\\Desktop\\test.pdf"));
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        //获取字体文件目录
        String fontDir = this.getClass().getClassLoader().getResource("font").getFile();
        //注册字体文件
        XMLWorkerFontProvider xmlWorkerFontProvider = new XMLWorkerFontProvider(fontDir);
        //设置中文字体，本文举例使用的是仿宋
        BaseFont baseFont = BaseFont.createFont("font/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font12 = new Font(baseFont, 12);

        //页眉，是可以双层或更多,取决于放置的坐标
        PdfContentByte cb = writer.getDirectContent();
        //页眉左上
        Phrase leftp1 = new Phrase("页眉左上", font12);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, leftp1, document.left(), document.top() + 13, 0);
        //页眉左下
        Phrase leftp2 = new Phrase("页眉左下:", font12);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, leftp2, document.left(), document.top(), 0);
        //页眉右上
        Phrase rightp1 = new Phrase("页眉右上:", font12);
        float rightp1WidthPoint = baseFont.getWidthPoint(rightp1.getContent(), 12);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, rightp1, document.right() - rightp1WidthPoint, document.top() + 13, 0);
        //页眉右下
        Phrase rightp2 = new Phrase("页眉右下:", font12);
        float rightp2WidthPoint = baseFont.getWidthPoint(rightp2.getContent(), 12);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, rightp2, document.right() - rightp2WidthPoint, document.top(), 0);

        //下划线
        PdfContentByte canvas = writer.getDirectContent();
        CMYKColor magentaColor = new CMYKColor(1.f, 1.f, 1.f, 1.f);
        canvas.setColorStroke(magentaColor);
        canvas.moveTo(document.left(), document.top() - 4);
        canvas.lineTo(document.right(), document.top() - 4);
        canvas.closePathStroke();

        //标题
        Font h1 = new Font(baseFont, 20, Font.BOLD);//创建全文标题字体，参数分别是字体类别,字号,效果
        Paragraph paragraphTitle = new Paragraph("标题测试", h1);//设置文本内容和要使用的字体
        paragraphTitle.setAlignment(Element.ALIGN_CENTER);//设置居中
        document.add(paragraphTitle);

        //正文标题1
        Font h3 = new Font(baseFont, 14, Font.BOLD);//创建标题字体
        Paragraph paragraphH1 = new Paragraph("正文标题1", h3);
        document.add(paragraphH1);
        //正文1
        Paragraph paragraphText1 = new Paragraph("你能做到最好，你能做到最好，你能做到最好，你能做到最好，你能做到最好，你能做到最好，你能做到最好。", font12);
        document.add(paragraphText1);

        //正文2，html标签内容
        String content = "<div class=\"overflow-hidden\"><div class=\"editContent\"><p><br>eah, you could be the greatest<br>你会成为最伟大的人<br>You can be the best<br>你能做到最好<br>You can be the King Kong banging on your chest<br>你能像金刚一样自信满满的敲打胸脯<br>You could beat the world<br>你可以征服全世界<br>You could beat the war<br>能够赢得一切战争<br>You could talk to God, go banging on his door<br>甚至能够与神对话 去敲打他的门<br>You can throw your hands up<br>你能自信的举起双手<br>You can be the clock<br>你可以与时间抗争<br>You can move a mountain<br>你有移山之力<br>You can break rocks<br>你能击碎岩石<br>You can be a master<br>你可以成为命运主宰<br>Don't wait for luck<br>无需等待运气垂青<br>Dedicate yourself and you can find yourself<br>放手一搏后你会恍然发现<br>Standing in the hall of fame<br>你已身处名人堂之中</p></div></div>";
        String html = readFile("D:\\Test\\pdf_sample.html", "UTF-8");
        //html转换成普通文字,方法如下:
        org.jsoup.nodes.Document contentDoc = Jsoup.parseBodyFragment(html);
        org.jsoup.nodes.Document.OutputSettings outputSettings = new org.jsoup.nodes.Document.OutputSettings();
        outputSettings.syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
        contentDoc.outputSettings(outputSettings);
        String parsedHtml = contentDoc.outerHtml();
        //这儿的font-family不支持汉字，{font-family:仿宋} 是不可以的。
        InputStream cssIs = new ByteArrayInputStream("* {font-family: fangsong;}".getBytes("UTF-8"));
        //第四个参数是html中的css文件的输入流
        //第五个参数是字体提供者，使用系统默认支持的字体时，可以不传。
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(parsedHtml.getBytes()), cssIs,   xmlWorkerFontProvider);

        //页脚
        PdfContentByte cj = writer.getDirectContent();
        Phrase leftp3 = new Phrase("页脚左侧", font12);
        ColumnText.showTextAligned(cj, Element.ALIGN_LEFT, leftp3, document.left(), document.bottom(), 0);
        Phrase rightp3 = new Phrase("页脚右侧", font12);
        final float rightp3WidthPoint = baseFont.getWidthPoint(rightp3.getContent(), 12);
        ColumnText.showTextAligned(cj, Element.ALIGN_LEFT, rightp3, document.right() - rightp3WidthPoint, document.bottom(), 0);

        //关闭
        document.close();
    }
    private final  String readFile(String path, String encoding)
            throws IOException {
        File f = new File(path);
        FileInputStream is = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(is);


        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        byte buffer[] = new byte[2048];


        int read;
        do {
            read = is.read(buffer, 0, buffer.length);
            if (read > 0) {
                fos.write(buffer, 0, read);
            }
        } while (read > -1);


        fos.close();
        bis.close();
        is.close();
        return fos.toString(encoding);
    }
}
