package Export;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

import BUS.CT_HOA_DON_NHAP_BUS;
import BUS.HOA_DON_NHAP_BUS;
import DTO.CT_HOA_DON_NHAP_DTO;
import DTO.HOA_DON_NHAP_DTO;
public class ExportHDN_PDF {

    private HOA_DON_NHAP_BUS hoa_DON_NHAP_BUS = new HOA_DON_NHAP_BUS();
    private CT_HOA_DON_NHAP_BUS ct_HOA_DON_NHAP_BUS = new CT_HOA_DON_NHAP_BUS();

    public ExportHDN_PDF ()
    {
        
    }

    public void exportHDN (String maHDN)
    {
        ArrayList<HOA_DON_NHAP_DTO> arrHDN = new ArrayList<HOA_DON_NHAP_DTO>();
        arrHDN = hoa_DON_NHAP_BUS.findHDN(maHDN, "MA_HDN");

        ArrayList<CT_HOA_DON_NHAP_DTO> arrCTHDN = new ArrayList<CT_HOA_DON_NHAP_DTO>();
        arrCTHDN = ct_HOA_DON_NHAP_BUS.getAllCTHDNTen_HANG(maHDN);

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(arrHDN.get(0).getMA_HDN() +  "-" +arrHDN.get(0).getTEN_NV() + ".pdf"));
            document.open();
            // D:\\Semester\\Semester2year2\\Java\\JAVAPROJECT_NEW2\\src\\Export\\arial-unicode-ms.ttf
            Font font = FontFactory.getFont("D:\\Semester\\Semester2year2\\Java\\JAVAPROJECT_NEW2\\src\\Export\\arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Paragraph txtHoaDonNhapHang = new Paragraph("HÓA ĐƠN NHẬP HÀNG",font);
            txtHoaDonNhapHang.setAlignment(Element.ALIGN_CENTER); // căn giữa
    
            Paragraph txtMaHDN = new Paragraph("Mã hóa đơn : " + arrHDN.get(0).getMA_HDN().trim(),font);
            txtMaHDN.setAlignment(Element.ALIGN_CENTER); // căn giữa

            Paragraph para = new Paragraph();
            para.setSpacingBefore(25);
            para.setFont(font);
            para.add("               Mã nhân viên : " + arrHDN.get(0).getMA_NV().trim());
            para.add("                                    " );
            para.add("Ngày nhập:" + arrHDN.get(0).getNGAY_LAP());
            
            Paragraph txtTenNV = new Paragraph("Tên nhân viên : " + arrHDN.get(0).getTEN_NV().trim(),font);
            txtTenNV.setIndentationLeft(50f);
        
            Paragraph txtSDT = new Paragraph("Số điện thoại : 0" +  Integer.toString(arrHDN.get(0).getSDT())  ,font);
            txtSDT.setIndentationLeft(50f);
            float[] columnWidths = { 1,1, 1,1,1,1 };
            PdfPTable t = new PdfPTable(columnWidths);
           
           
            // t.TotalWidth = 216f; // đặt chiều rộng bảng là 216 điểm
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);
            
            PdfPCell stt = new PdfPCell(new Phrase("STT"));
            t.addCell(stt);
            
            PdfPCell tenSP = new PdfPCell(new Phrase("Tên sản phẩm",font));
            t.addCell(tenSP);
            
            PdfPCell gia = new PdfPCell(new Phrase("Giá",font));
            t.addCell(gia);
            
            PdfPCell hang = new PdfPCell(new Phrase("Hãng nhập",font));
            t.addCell(hang);

            PdfPCell soLuong = new PdfPCell(new Phrase("Số lượng",font));
            t.addCell(soLuong);
            
            PdfPCell tongTien = new PdfPCell(new Phrase("Tổng tiền",font));
            t.addCell(tongTien);    

            DecimalFormat formatter = new DecimalFormat("#,###");

            for (int i = 0; i<arrCTHDN.size(); i++)
            {
                t.addCell(Integer.toString(i+1));
                t.addCell(arrCTHDN.get(i).getTEN_XE());
                t.addCell(formatter.format((long)  arrCTHDN.get(i).getGIA_NHAP() ));
                t.addCell(arrCTHDN.get(i).getHANG_XE());
                t.addCell(Integer.toString(arrCTHDN.get(i).getSO_LUONG()));
                t.addCell(formatter.format((long)arrCTHDN.get(i).getGIA()));
    
            } 
            Paragraph txtThanhToan = new Paragraph("Tiền nhập : " + formatter.format((long)arrHDN.get(0).getTONG_TIEN()), font);
            txtThanhToan.setIndentationLeft(50f);

            Paragraph paraChuKy = new Paragraph();
            paraChuKy.setSpacingBefore(25);
            paraChuKy.setFont(font);
            paraChuKy.add("                    Người nhập hàng");
            paraChuKy.add("                                                                   " );
            paraChuKy.add("Hãng nhập hàng");
           
            paraChuKy.add("                                      (Ký,ghi rõ họ tên)");
            paraChuKy.add("                                                                  " );
            paraChuKy.add("(Ký,ghi rõ họ tên)");   


            document.add(txtHoaDonNhapHang);
            document.add(txtMaHDN);
            document.add(para);
            document.add(txtTenNV);
            document.add(txtSDT);
            document.add(t); 
            document.add(txtThanhToan); 
            document.add(paraChuKy); 

            document.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        ExportHDN_PDF exportHDN_PDF = new ExportHDN_PDF();
        exportHDN_PDF.exportHDN("HDN09066");
    }




}
