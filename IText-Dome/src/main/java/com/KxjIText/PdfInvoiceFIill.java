package com.KxjIText;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author WQL-KXJ
 * @ProjectName IText-Dome
 * @PackageName com.KxjIText
 * @Date 2022/9/9 0:39
 * @Version 1.0
 */
public class PdfInvoiceFIill {

    //需要处理的PDF文件地址
   private final static String READ_PDF = "C:\\Users\\wql\\Desktop\\发票样本.pdf";

   //处理完成之后的PDF输出地址
   private final static String WRITE_PDF = "C:\\Users\\wql\\Desktop\\result.pdf";

   //字体文件地址
   private final static String FONT_PATH = "D:\\Fonts\\汉字拼音体.ttf";

    public static void main(String[] args) throws IOException {

        //1，创建PDF文档对象，传入输入和输出PDF对象
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(READ_PDF),new PdfWriter(WRITE_PDF));

        //2，通过表单域获取表单,（参数2：是否不存在时创建）
        PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);

        //3，创建字体对象
        PdfFont font = PdfFontFactory.createFont(FONT_PATH);

        //4，创建字体颜色对象
        DeviceRgb deviceRgb = new DeviceRgb(0,0,0);

        //5，文本的填充内容map
        Map<String,String> map = new HashMap<String, String>();
        map.put("text1","xxxx智能科技有限公司");
        map.put("text2","科技有限");
        map.put("text3","湖南株洲**工业大学");
        map.put("text4","南株");

        //6，将map内容填充到表单域
        for(Map.Entry<String,String> x:map.entrySet()){
            acroForm.getFormFields().get(x.getKey()).setValue(x.getValue()).setColor(deviceRgb).setFont(font);
        }

        //7，清除文本域格式
        acroForm.flattenFields();

        //8，关闭pdfDocment文件流
        pdfDocument.close();

    }

}
