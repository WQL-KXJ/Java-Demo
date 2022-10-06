package com.KxjIText;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileNotFoundException;

/*
 * @Author WQL-KXJ
 * @ProjectName IText-Dome
 * @PackageName com.KxjIText
 * @Date 2022/9/8 22:09
 * @Version 1.0
 */
public class CreatePdf {
    public static void main(String[] args) throws FileNotFoundException {

        //pdf输出地址
        String pdfpath = "smile.pdf";

        //pdf输出对象
        PdfWriter pdfWriter = new PdfWriter(pdfpath);

        //PFD文档对象
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        //添加一个空页面
        pdfDocument.addNewPage();

        //创建一个文档
        Document document = new Document(pdfDocument);

        document.close();

    }

}
