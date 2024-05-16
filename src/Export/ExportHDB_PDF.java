package Export;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.CT_HOA_DON_BAN_BUS;
import BUS.HOA_DON_BAN_BUS;
import DTO.CT_HOA_DON_BAN_DTO;
import DTO.HOA_DON_BAN_DTO;

import com.*;



import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class ExportHDB_PDF {


    private HOA_DON_BAN_BUS hoa_DON_BAN_BUS = new HOA_DON_BAN_BUS();
    private CT_HOA_DON_BAN_BUS ct_HOA_DON_BAN_BUS = new CT_HOA_DON_BAN_BUS();

    public ExportHDB_PDF()
    {

    }

    public void exportHDB (String maHDB)
    {
        ArrayList<HOA_DON_BAN_DTO> arrHDB = new ArrayList<HOA_DON_BAN_DTO>();
        arrHDB = hoa_DON_BAN_BUS.findHDB(maHDB, "MA_HDB");

        ArrayList<CT_HOA_DON_BAN_DTO> arrCTHDB = new ArrayList<CT_HOA_DON_BAN_DTO>();
        arrCTHDB = ct_HOA_DON_BAN_BUS.getAllCTHDB(maHDB);

        Document document = new Document();
        try {
        PdfWriter.getInstance(document, new FileOutputStream(arrHDB.get(0).getMA_HDB() + "-" +arrHDB.get(0).getTEN_KH() + ".pdf"));
        document.open();
        Font font = FontFactory.getFont("D:\\Semester\\Semester2year2\\Java\\JAVAPROJECT_NEW2\\src\\Export\\arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        
        Paragraph txtHoaDonBanHang = new Paragraph("HÓA ĐƠN BÁN HÀNG",font);
        txtHoaDonBanHang.setAlignment(Element.ALIGN_CENTER); // căn giữa

        Paragraph txtMaHDB = new Paragraph("Mã hóa đơn : " + arrHDB.get(0).getMA_HDB().trim(),font);
        txtMaHDB.setAlignment(Element.ALIGN_CENTER); // căn giữa

        Paragraph para = new Paragraph();
        para.setSpacingBefore(25);
        para.setFont(font);
        para.add("               Tên khách hàng : " +  arrHDB.get(0).getTEN_KH().trim());
        para.add("                                        " );
        para.add("Ngày lập:" + arrHDB.get(0).getNGAY_LAP());

        Paragraph txtDiaChi = new Paragraph("Địa chỉ : " + arrHDB.get(0).getDIA_CHI().trim(),font);
        txtDiaChi.setIndentationLeft(50f);

        PdfPTable t = new PdfPTable(5);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);
        
        PdfPCell stt = new PdfPCell(new Phrase("STT"));
        t.addCell(stt);
        
        PdfPCell tenSP = new PdfPCell(new Phrase("Tên sản phẩm",font));
        t.addCell(tenSP);
        
        PdfPCell gia = new PdfPCell(new Phrase("Giá",font));
        t.addCell(gia);
        
        PdfPCell soLuong = new PdfPCell(new Phrase("Số lượng",font));
        t.addCell(soLuong);
        
        PdfPCell tongTien = new PdfPCell(new Phrase("Tổng tiền",font));
        t.addCell(tongTien);    

        DecimalFormat formatter = new DecimalFormat("#,###");
        long thanhToan = 0;
        for (int i = 0; i<arrCTHDB.size(); i++)
        {
            t.addCell(Integer.toString(i+1));
            t.addCell(arrCTHDB.get(i).getTEN_XE());
            t.addCell(formatter.format((long)  arrCTHDB.get(i).getGIA_NHAP() ));
            t.addCell(Integer.toString(arrCTHDB.get(i).getSO_LUONG()));
            t.addCell(formatter.format((long)arrCTHDB.get(i).getGIA()));
            thanhToan+= arrCTHDB.get(i).getGIA();

        }

        Paragraph txtThanhToan = new Paragraph("Thanh toán : " + formatter.format((long)thanhToan));
        txtThanhToan.setIndentationLeft(50f);



        Paragraph paraChuKy = new Paragraph();
        paraChuKy.setSpacingBefore(25);
        paraChuKy.setFont(font);
        paraChuKy.add("                    Người mua hàng");
        paraChuKy.add("                                                                   " );
        paraChuKy.add("Người bán hàng");
       
        paraChuKy.add("                                      (Ký,ghi rõ họ tên)");
        paraChuKy.add("                                                                  " );
        paraChuKy.add("(Ký,ghi rõ họ tên)");    


        document.add(txtHoaDonBanHang);
        document.add(txtMaHDB);
        document.add(para);
        document.add(txtDiaChi);
        document.add(t); 
        document.add(txtThanhToan); 
        document.add(paraChuKy); 


        document.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
        

    }
  








    public static void main(String[] args) {
       
        
        
        
        
        
        
        
        
        
        
        
        // Document document = new Document();

        // try {
        // PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        // document.open();
        // Font font = FontFactory.getFont("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\Export\\arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        
        // Paragraph txtHoaDonBanHang = new Paragraph("HÓA ĐƠN BÁN HÀNG",font);
        // txtHoaDonBanHang.setAlignment(Element.ALIGN_CENTER); // căn giữa

        // Paragraph txtMaHDB = new Paragraph("Mã hóa đơn : " + "HDB451365",font);
        // txtMaHDB.setAlignment(Element.ALIGN_CENTER); // căn giữa


        // Paragraph para = new Paragraph();
        // para.setSpacingBefore(25);
        // para.setFont(font);
        // para.add("               Tên khách hàng : " + "Lê Thị B");
        // para.add("                                        " );
        // para.add("Ngày lập:" + "22/06/2023 12:45");

        // Paragraph txtDiaChi = new Paragraph("Địa chỉ : " + "60/18,Phú Thọ Hòa, Tân Phú, Hồ Chí Minh",font);
        // txtDiaChi.setIndentationLeft(50f);
        
        
        // PdfPTable t = new PdfPTable(5);
        // t.setSpacingBefore(25);
        // t.setSpacingAfter(25);
        
        // PdfPCell stt = new PdfPCell(new Phrase("STT"));
        // t.addCell(stt);
        
        // PdfPCell tenSP = new PdfPCell(new Phrase("Tên sản phẩm",font));
        // t.addCell(tenSP);
        
        // PdfPCell gia = new PdfPCell(new Phrase("Giá",font));
        // t.addCell(gia);
        
        // PdfPCell soLuong = new PdfPCell(new Phrase("Số lượng",font));
        // t.addCell(soLuong);
        
        // PdfPCell tongTien = new PdfPCell(new Phrase("Tổng tiền",font));
        // t.addCell(tongTien);    
        
        // t.addCell("1");
        // t.addCell("Honda RX5");
        // t.addCell("20,000,000");
        // t.addCell("2");
        // t.addCell("40,000,000");

        // t.addCell("2");
        // t.addCell("Vision YT8");
        // t.addCell("10,000,000");
        // t.addCell("2");
        // t.addCell("20,000,000");


        // Paragraph txtThanhToan = new Paragraph("Thanh toán : " + "60,000,000");
        // txtThanhToan.setIndentationLeft(50f);

        // Paragraph paraChuKy = new Paragraph();
        // paraChuKy.setSpacingBefore(25);
        // paraChuKy.setFont(font);
        // paraChuKy.add("                    Người mua hàng");
        // paraChuKy.add("                                                                   " );
        // paraChuKy.add("Người bán hàng");
       
        // paraChuKy.add("                                      (Ký,ghi rõ họ tên)");
        // paraChuKy.add("                                                                  " );
        // paraChuKy.add("(Ký,ghi rõ họ tên)");    
        
        
        
        // document.add(txtHoaDonBanHang);
        // document.add(txtMaHDB);
        // document.add(para);
        // document.add(txtDiaChi);
        // document.add(t); 
        // document.add(txtThanhToan); 
        // document.add(paraChuKy); 
        
        // document.close();
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
    
    
    }
}
