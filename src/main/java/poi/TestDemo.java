package poi;

import java.awt.Insets;
import java.io.*;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;


import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/26
 */
public class TestDemo {
    protected int topValue = 10;
    protected int leftValue = 20;
    protected int rightValue = 10;
    protected int bottomValue = 10;
    protected int userSpaceWidth = 1300;


    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            TestDemo jt = new TestDemo();
            String html = readFile("D:\\Test\\pdf_sample.html", "UTF-8");
           // jt.doConversion2(html, "D:\\Test\\pd4ml.pdf");

            StringReader strReader = new StringReader(html.toString());
            generatePDF(strReader);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void doConversion2(String htmlDocument, String outputPath)
            throws InvalidParameterException, MalformedURLException,
            IOException {


        PD4ML pd4ml = new PD4ML();

        pd4ml.setHtmlWidth(userSpaceWidth); // set frame width of
// "virtual web browser"

// choose target paper format
        pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));

// define PDF page margins
        pd4ml.setPageInsetsMM(new Insets(topValue, leftValue, bottomValue,
                rightValue));
// source HTML document also may have margins, could be suppressed this
// way
// (PD4ML *Pro* feature):
        pd4ml.addStyle("BODY {margin: 0; font-family:MSJH}", true);


// If built-in basic PDF fonts are not sufficient or
// if you need to output non-Latin texts, TTF embedding feature should
// help
// (PD4ML *Pro*)
// pd4ml.useTTF("C:\\workspace\\HtmlToPDF", true);
        pd4ml.useTTF("java:fonts", true);
        pd4ml.setDefaultTTFs("MSJH", "Arial", "Courier New");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
// actual document conversion from HTML string to byte array
        pd4ml.render(new StringReader(htmlDocument), baos);
// if the HTML has relative references to images etc,
// use render() method with baseDirectory parameter instead
        baos.close();
        System.out.println("resulting PDF size: " + baos.size() + " bytes");
// in Web scenarios it is a good idea to send the size with
// "Content-length" HTTP header
        File output = new File(outputPath);
        java.io.FileOutputStream fos = new java.io.FileOutputStream(output);
        fos.write(baos.toByteArray());
        fos.close();
        System.out.println(outputPath + "\ndone.");
    }


    private final static String readFile(String path, String encoding)
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
    public static byte[] generatePDF( StringReader strReader) {
        try {
            //FileOutputStream fos = new FileOutputStream(outputPDFFile);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PD4ML pd4ml = new PD4ML();
            pd4ml.setPageInsets(new Insets(5, 5, 5, 5));
            pd4ml.setHtmlWidth(900);
            pd4ml.setPageSize(PD4Constants.A4);  // A4竖向显示  pd4ml.changePageOrientation(PD4Constants.A4)横向显示
            //pd4ml.useTTF("java:fonts", true);
            pd4ml.useTTF("D:\\Test\\fonts", true);
            pd4ml.setDefaultTTFs("SimHei", "YouYuan", "SimSun");  //fonts.jar的配置文件中的值，用于中文乱码
            pd4ml.enableDebugInfo();
            pd4ml.render(strReader, os);  //如果用上面的fos，就是写出到指定的文件
            File output = new File("D:\\Test\\pdf8.pdf");
            java.io.FileOutputStream fos1 = new java.io.FileOutputStream(output);
            fos1.write( os.toByteArray());
            fos1.close();
            return os.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }
}
