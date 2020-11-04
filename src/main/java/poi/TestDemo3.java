//package poi;
//
//import java.io.File;
//import java.io.OutputStream;
//
///**
// * @author wangjufeng1
// * @description
// * @date 2019/4/26
// */
//public class TestDemo3 {
//
//    /**
//     * 将HTML转成PD格式的文件。html文件的格式比较严格
//     * @param htmlFile
//     * @param pdfFile
//     * @throws Exception
//     */
//    // <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
//    public static void html2pdf(String htmlFile, String pdfFile) throws Exception {
//    /*    // step 1
//        String url = new File(htmlFile).toURI().toURL().toString();
//        System.out.println(url);
//        // step 2
//        OutputStream os = new FileOutputStream(pdfFile);
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocument(url);
//
//        // step 3 解决中文支持
//        ITextFontResolver fontResolver = renderer.getFontResolver();
//        if("linux".equals(getCurrentOperatingSystem())){
//            fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//        }else{
//            fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        }
//
//        renderer.layout();
//        renderer.createPDF(os);
//        os.close();
//
//        System.out.println("create pdf done!!");*/
//
//    }
//
//}
