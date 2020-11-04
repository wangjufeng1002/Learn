//package poi;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.*;
//import org.zefer.pd4ml.PD4Constants;
//import org.zefer.pd4ml.PD4ML;
//
//import java.awt.*;
//import java.io.*;
//import java.net.URL;
//
///**
// * @author wangjufeng1
// * @description
// * @date 2019/4/26
// */
//public class TestDemo4 {
//    public static void main(String[] args) throws IOException {
//        String s = "<p style=\"margin: 14px 0px; text-align: justify; line-height: 31px; text-indent: 43px; text-justify: inter-ideograph;\"><span style=\"font-family: 仿宋; font-size: 21px;\">广东省肇庆市中级人民法院将于<strong><span style=\"color: red;\">2019</span><span style=\"color: red;\">年<span>5</span>月<span>15</span>日<span>10</span>时至<span>2019</span>年<span>5</span>月<span>16</span>日<span>10</span>时止</span></strong>（延时的除外）在肇庆市中级人民法院京东网司法拍卖网络平台上（网址：<span>https://sifa.jd.com/2650</span>，户名：广东省肇庆市中级人民法院）对以（<span>2010</span>）肇刑初字第<span>42</span>号刑事判决没收的<strong><span style=\"color: red;\">H-7</span><span style=\"color: red;\">柳月良牡丹字画一幅</span></strong></span><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">进行公开拍卖活动，现就有关的网上拍卖事宜敬告各位竞买人：</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">一、本《竞买须知》根据《中华人民共和国民事诉讼法》等相关法律规定所制订，竞买人应认真仔细阅读，了解本须知的全部内容。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">二、本次拍卖活动遵循“公开、公平、公正、诚实守信”的原则，拍卖活动具备法律效力。参加本次拍卖活动的当事人和竞买人必须遵守本须知的各项条款，并对自己的行为承担法律责任。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">根据《最高人民法院关于人民法院网络司法拍卖若干问题的规定》第七条的规定，本院委托社会机构承担网络司法拍卖的辅助工作，由此产生的必要费用由被执行人承担，该费用将从拍卖成交款中抵扣。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">三、凡具备完全民事行为能力的公民、法人和其他组织均可参加竞买。竞买人参拍前应仔细阅读拍卖公告的内容，不符合条件参加竞买的，竞买人自行承担相应的法律责任。</span></p><p style=\"line-height: 37px; text-indent: 41px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">法人和其他组织参与竞买的，竞买人须提供加盖公章确认的委托拍卖授权手续，并于<span style=\"text-decoration: underline;\"><span style=\"font-family: 仿宋;\"><strong>拍卖开始前三个工作日</strong></span></span>交到肇庆市中级人民法院执行局）。如委托手续不全，竞买活动认定为委托代理人的个人行为。</span><strong><span style=\"background: white; color: red; font-family: 仿宋; font-size: 21px;\">京东拍卖（广东）司法拍卖服务咨询电话：<span>4008-363-020</span>。</span></strong></p><p style=\"margin: 14px 0px; line-height: 36px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">四、优先购买权人参加竞买的，应于<span style=\"text-decoration: underline;\"><span style=\"font-family: 仿宋;\"><strong>拍卖开始前三个工作日</strong></span></span>向委托法院提交有效证明，经法院确认后才能以优先购买权人身份参与竞买；逾期不提交的，视为放弃对本标的物享有的优先购买权。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">五、与本标的物有利害关系的当事人可参加竞拍，不参加竞拍的请关注本次拍卖活动的整个过程。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">六、本次拍卖活动设置延时出价功能，在拍卖活动结束前，每最后<span>5</span>分钟如果有竞买人出价，就自动延迟<span>5</span>分钟。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">七、本次拍卖是经法定公告期和展示期后才举行的。拍卖人对拍卖标的物所作的说明和提供的资料、图片等，仅供竞买人参考，不构成对标的物的任何担保。所以请竞买人在拍卖前必须仔细审查拍卖标的物，调查是否存在瑕疵，认真研究查看所竞买标的物的实际情况，并请亲临展示现场，实地看样，未看样的竞买人视为对本标的实物现状的确认。请慎重决定竞买行为，</span><strong><span style=\"text-decoration: underline;\"><span style=\"background: white; color: red; font-family: 仿宋; font-size: 21px;\">竞买人一旦参加竞买，无论是否实地看样，都视为对拍卖财产完全了解，并接受拍卖财产一切已知和未知的瑕疵，责任自负。</span></span></strong></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">八、本次拍卖活动计价货币为人民币，拍卖时的起拍价、成交价均不含买受人在拍卖财产交割、过户时所发生的全部费用和税费。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">九、拍卖竞价前京东系统将锁定竞买人应缴的保证金，拍卖未成交的，竞买人锁定的保证金自动解锁，锁定期间不计利息；拍卖成交的，拍卖结束后未能竞得者锁定的保证金自动释放，锁定期间不计利息，竞得者原锁定的保证金自动转入本院指定账户。<span style=\"font-family: 仿宋;\"><strong>拍卖余款须在拍卖公告中规定的时间内缴入本院指定账户。</strong></span>在确认上述款项到账后，本院将出具相应法律文书并送达相关职能部门，再通知买受人（本人携带身份证原件<span style=\"text-decoration: underline;\"><span style=\"font-family: 仿宋;\"><strong>及复印件</strong></span></span>）到本院办理有关手续。</span></p><p style=\"text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">十、<span style=\"text-decoration: underline;\"><span style=\"font-family: 仿宋;\"><strong>买受人逾期未支付拍卖余款，法院可以裁定重新拍卖。重新拍卖时，原买受人不得参加竞买。</strong></span></span></span><strong><span style=\"text-decoration: underline;\"><span style=\"color: black; font-family: 仿宋; font-size: 21px;\">拍卖成交后买受人悔拍的，交纳的保证金不予退还，依次用于支付拍卖产生的费用损失、弥补重新拍卖价款低于原拍卖价款的差价、冲抵本案被执行人的债务以及与拍卖财产相关的被执行人的债务。</span></span></strong></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><strong><span style=\"text-decoration: underline;\"><span style=\"background: white; color: red; font-family: 仿宋; font-size: 21px;\">对于在司法网拍中恶意抬价、扰乱司法拍卖秩序的买受人，本院可以根据情节轻重依法予以罚款、拘留，构成犯罪的，依法追究刑事责任。</span></span></strong></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">十一、买受人签收相关法律文书后应自行办理过户手续，逾期不办理的，买受人应支付由此产生的逾期滞纳金等费用，并承担本拍卖财产可能发生的损毁、灭失等后果。</span></p><p style=\"margin: 14px 0px; line-height: 37px; text-indent: 43px;\"><strong><span style=\"text-decoration: underline;\"><span style=\"background: white; color: red; font-family: 仿宋; font-size: 21px;\">本院不保证拍卖财产真伪或者品质，不承担瑕疵担保责任。</span></span><span>拍卖财产按交付时现状交付，交付时实物与评估报告不一致的风险及评估基准日至交付之时所产生的风险如隐藏瑕疵、缺陷、损毁等均由买受人承担，本院概不作多退少补。</span></strong></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">十二、根据法律规定，拍卖可依法中止或撤回。</span></p><p style=\"margin: 14px 0px; line-height: 31px; text-indent: 43px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">十三、<span style=\"font-family: 仿宋;\"><strong>为便于买受人及时收到人民法院拍卖相关的文书，竞买人在参与拍卖前须如实向司法拍卖（变卖）网络平台提供确切的送达地址，上述地址确认为邮寄地址。</strong></span>如需更改地址，买受人应在拍卖活动结束时与本院联系确认更改。因提供的送达地址不确切，或未及时告知变更地址，导致法院有关法律文书无法送达的，由竞买人自行承担由此可能产生的法律后果。</span></p><p style=\"text-indent: 41px;\"><span style=\"background: white; color: black; font-family: 仿宋; font-size: 21px;\">十四、</span><span style=\"font-family: 仿宋; font-size: 21px;\">凡发现拍卖中有违规行为，可如实举报。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">监督电话：<strong><span>0758-2786081</span></strong>。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">京东拍卖（全国）竞拍流程<span>/</span>保证金缴纳咨询电话：<span>4006-229-586</span>。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">京东拍卖（广东）标的物详情咨询<span>/</span>预约看样<span>/</span>贷款咨询电话：<span>4008-363-020</span>、<span>13501508049</span>。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">中国银行肇庆分行拍卖贷款咨询电话：</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">咨询时间：工作日<span>8:30-12:00</span>，<span>14:30-17:30</span>。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">郑经理：<span>0758-2813232</span>、<span>13824639060</span>；</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">罗小姐：<span>0758-2813251</span>、<span>2813701</span>。</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">联系地址：广东省肇庆市端州区信安大道<span>97</span>区</span></p><p style=\"text-indent: 43px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">本规则其他未尽事宜，请向本院咨询。</span></p><p style=\"text-align: right; line-height: 29px;\"><span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\">&nbsp;</span> <span style=\"font-family: 宋体;\"><span style=\"font-family: ;\">&nbsp;</span></span></p><p style=\"line-height: 29px; text-indent: 256px;\"><span style=\"font-family: Calibri; font-size: 16px;\">&nbsp;</span></p><p style=\"text-align: right; line-height: 31px; text-indent: 43px; margin-right: 42px;\"><span style=\"font-family: 仿宋; font-size: 21px;\">二〇一九年四月二十三日</span></p><p></p> " + "<table border=\"1\">\n" +
//                "  <tr>\n" +
//                "    <th>Month</th>\n" +
//                "    <th>Savings</th>\n" +
//                "  </tr>\n" +
//                "  <tr>\n" +
//                "    <td>January</td>\n" +
//                "    <td>$100</td>\n" +
//                "  </tr>\n" +
//                "</table>";
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        PD4ML pd4ml = new PD4ML();
//        pd4ml.setPageInsets(new Insets(5, 5, 5, 5));
//        pd4ml.setHtmlWidth(900);
//        pd4ml.setPageSize(PD4Constants.A4);
//       // A4竖向显示pd4ml.changePageOrientation(PD4Constants.A4)横向显示
//        pd4ml.useTTF("D:\\Test\\fonts\\fonts", true);
//        pd4ml.setDefaultTTFs("SimHei", "YouYuan", "SimSun");//fonts.jar的配置文件中的值，用于中文乱码
//        pd4ml.enableDebugInfo();
//        pd4ml.render(new StringReader(s), os);  //如果用上面的fos，就是写出到指定的文件
//       // File output = new File("D:\\Test\\pdf7.pdf");
//       /* java.io.FileOutputStream fos1 = new java.io.FileOutputStream(output);
//        fos1.write( os.toByteArray());
//        fos1.close();*/
//        addWater(os);
//    }
//    private static void  addWater(ByteArrayOutputStream os) {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Test\\pdf7.pdf");
//          /*  PipedOutputStream out = new PipedOutputStream();
//            PipedOutputStream finish = new CustAlbumInfoPipedInputStream(out);*/
//            PdfReader reader = new PdfReader(os.toByteArray());
//            PdfStamper stamper = new PdfStamper(reader, fileOutputStream);
//            //这里的字体设置比较关键，这个设置是支持中文的写法
//            BaseFont base = BaseFont.createFont("STSong-Light",
//                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
//            int total = reader.getNumberOfPages() + 1;
//            PdfContentByte under;
//            Rectangle pageRect = null;
//            String path = System.getProperty("auction.center.webapp") + "WEB-INF/common/img/pdf.jpg";
//           // LOGGER.error("path:{}", path);
//            for (int i = 1; i < total; i++) {
//                pageRect = stamper.getReader().getPageSizeWithRotation(i);
//                // 计算水印X,Y坐标
//                // float x = pageRect.getWidth()/10;
//                // float y = pageRect.getHeight()/10-10;
//                float x = pageRect.getWidth();
//                float y = pageRect.getHeight();
//                // 获得PDF最顶层
//                under = stamper.getUnderContent(i);
//                under.saveState();
//                // set Transparency
//                PdfGState gs = new PdfGState();
//                // 设置透明度为0.2
//                gs.setFillOpacity(0.2f);
//                under.setGState(gs);
//                under.restoreState();
//                under.beginText();
//                under.setFontAndSize(base, 60);
//                under.setColorFill(BaseColor.ORANGE);
//               // URL url = new URL(path);
//                // this.getClass().getClassLoader().getResource("/").getPath()+"";
//               // com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(url);
//               // float width = image.getWidth();
//               // float height = image.getHeight();
//               /* for (int xt = 0; xt < x; ) {
//                    // under.addImage();
//                    for (int yt = 0; yt < y; ) {
//                        image.setAbsolutePosition(xt, yt);
//                        under.addImage(image);
//                        yt += height;
//                    }
//                    xt += width;
//                }*/
//                // 水印文字成45度角倾斜
//                 under.showTextAligned(Element.ALIGN_LEFT, "王巨峰", 100, 10, 45);
//                 under.showTextAligned(Element.ALIGN_LEFT, "王巨峰", 100, 300, 45);
//                 under.showTextAligned(Element.ALIGN_RIGHT, "王巨峰", 100, 600, 135);
//                // 添加水印文字
//                 under.endText();
//                 under.setLineWidth(1f);
//                 under.stroke();
//            }
//            stamper.close();
//        } catch (Exception e) {e.printStackTrace();
//
//        }
//    }
//}
