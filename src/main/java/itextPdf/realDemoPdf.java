package itextPdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//所需jar包  itext-5.5.10.jar ,,中文输出 itext-asian.jar  详见158行
public class realDemoPdf {


    public static void main(String[] args) throws  Exception{
        //用于生成pdf的路径
        String newPath="D:\\pdfDemo.pdf";
        //表头   详见88行
        String[] str={"本年度收入","小 计","利息收入","其他收入"};
        String[] str2={"本年度支出","小 计","维修费用","其他费用"};

        //内容    详见96行
        List<String> rzList=new ArrayList<>();
        rzList.add(0,"aaa1");
        rzList.add(1,"bbb1");
        rzList.add(2,"ccc1");
        //内容    详见96行
        List<String> rzList2=new ArrayList<>();
        rzList2.add(0,"aaa2");
        rzList2.add(1,"bbb2");
        rzList2.add(2,"ccc2");

        createPDF(newPath,str,str2,rzList,rzList2);
        System.out.println("ok");
    }





    public static void createPDF(String newPath, String []str, String []str2,List<String> rzlist,List<String> rzlist2) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(newPath));
        document.open();
        PdfPTable table = null;
        PdfPCell cell;

        table = new PdfPTable(4);//建立表格 ，4代表有4列的表格
        table.setTotalWidth(new float[]{70f,90f,90f,90f});//每列设置宽度

        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setLockedWidth(true);

        cell = new PdfPCell(new Phrase("唯一流水号0123456789",ChineseFont(4)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setFixedHeight(20f);
        table.addCell(cell);

        String imagetemp="D:\\1.jpg";
        Image jpeg = Image.getInstance(imagetemp);
        jpeg.scaleAbsolute(130, 80);
        cell = new PdfPCell(jpeg);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setColspan(4);
        cell.setFixedHeight(100f);
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("xx路xx弄xx号xxxxxx室",ChineseFont(4)));
//        cell.setPaddingTop(30f);
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setFixedHeight(20f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("代码：123456789012345678",ChineseFont(4)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setFixedHeight(20f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("账号：123456789012345678",ChineseFont(4)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setFixedHeight(20f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("制作单位：********",ChineseFont(4)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setFixedHeight(20f);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase("******************例子",ChineseFont(1)));
        cell.setPaddingTop(10f);
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(30f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("时间：2018 年 01 月 01 日至 2018 年 12 月 31 日",ChineseFont(4)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(20f);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase("年初： 1234567890123456.78 ",ChineseFont(2)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setColspan(2);
        cell.setFixedHeight(30f);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("单位：人民币（元）",ChineseFont(2)));
        cell.setBorderWidthRight(0);	//单元格右侧border设为0
        cell.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell.setBorderWidthBottom(0);	//单元格底部border设为0
        cell.setBorderWidthTop(0);		//单元格顶部border设为0
        cell.setPaddingBottom(5);
        cell.setColspan(2);
        cell.setFixedHeight(30f);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);
        // 第一行表头
        for (int j = 0; j < 4; j++) {
            cell = new PdfPCell(new Phrase(str[j],ChineseFont(2)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            cell.setColspan(1);
            if(j==0){
                cell.setRowspan(2);
            }
            table.addCell(cell);
        }
        //内容，业务类型，业务明细，备注
        for(int k = 0; k < 3; k++){
            cell = new PdfPCell(new Phrase(rzlist.get(k),ChineseFont(2)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            cell.setColspan(1);
            table.addCell(cell);
        }
        for (int j = 0; j < 4; j++) {
            cell = new PdfPCell(new Phrase(str2[j],ChineseFont(2)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            cell.setColspan(1);
            if(j==0){
                cell.setRowspan(2);
            }
            table.addCell(cell);
        }
        for(int k = 0; k < 3; k++){
            cell = new PdfPCell(new Phrase(rzlist2.get(k),ChineseFont(2)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(20f);
            cell.setColspan(1);
            table.addCell(cell);
        }



        document.add(table);
        document.newPage();//手动换新页



        PdfPTable table2 = null;
        PdfPCell cell2;

        table2 = new PdfPTable(4);//建立表格 ，4代表有4列的表格
        table2.setTotalWidth(new float[]{70f,90f,90f,90f});//每列设置宽度

        table2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.setLockedWidth(true);
        cell2 = new PdfPCell(new Phrase("唯一流水号0123456789",ChineseFont(4)));
        cell2.setBorderWidthRight(0);	//单元格右侧border设为0
        cell2.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell2.setBorderWidthBottom(0);	//单元格底部border设为0
        cell2.setBorderWidthTop(0);		//单元格顶部border设为0
        cell2.setColspan(4);
        cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell2.setFixedHeight(20f);
        table2.addCell(cell2);


        cell2 = new PdfPCell(new Phrase("xx路xx弄xx号xxxxxx室",ChineseFont(4)));
//        cell.setPaddingTop(30f);
        cell2.setBorderWidthRight(0);	//单元格右侧border设为0
        cell2.setBorderWidthLeft(0);		//单元格右侧border设为0
        cell2.setBorderWidthBottom(0);	//单元格底部border设为0
        cell2.setBorderWidthTop(0);		//单元格顶部border设为0
        cell2.setColspan(4);
        cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell2.setFixedHeight(20f);
        table2.addCell(cell2);
        document.add(table2);
        document.close();

    }

    /**
     * 中文字体支持
     */
    public static Font ChineseFont(int fontType) {
        BaseFont baseFont=null;
        try {                                                       //中文输出，需要itext-asian.jar 支持
            baseFont=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", true);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font chineseFont=new Font(baseFont,10f,Font.NORMAL,BaseColor.BLUE);
        if(fontType==1){
            chineseFont.setSize(15f);
        }else if(fontType==2){
            chineseFont.setSize(11f);
//            chineseFont.setStyle("font-weight:bold;");//给字体加样式---加粗

        } else if(fontType==121){
            chineseFont.setSize(10f);
        } else if(fontType==3) {
            chineseFont.setSize(9f);
        }else if(fontType==4){
            chineseFont.setSize(10f);
//             chineseFont.setStyle("font-weight:bold;");
        }
        return chineseFont;
    }
}