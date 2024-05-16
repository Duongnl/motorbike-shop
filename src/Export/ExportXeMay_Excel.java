package Export;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.XE_MAY_BUS;
import DTO.XE_MAY_DTO;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
public class ExportXeMay_Excel 
{

    XE_MAY_BUS xe_MAY_BUS = new XE_MAY_BUS();

    public ExportXeMay_Excel ()
    {

    }

    public void ExportXeMay()
    {
         // Tạo workbook mới
       XSSFWorkbook workbook = new XSSFWorkbook();

       // Tạo sheet mới
       XSSFSheet sheet = workbook.createSheet("Kho xe máy");

       ArrayList<XE_MAY_DTO> arrXeMay = new ArrayList<XE_MAY_DTO>();
       arrXeMay = xe_MAY_BUS.getAllXeMay();

       XSSFRow row0 = sheet.createRow(0);
       
       XSSFCell cell0 = row0.createCell(0);
       cell0.setCellValue("STT");

       XSSFCell cell1 = row0.createCell(1);
       cell1.setCellValue("Mã xe");

       XSSFCell cell2 = row0.createCell(2);
       cell2.setCellValue("Tên xe");

       XSSFCell cell3 = row0.createCell(3);
       cell3.setCellValue("Giá nhập");

       XSSFCell cell4 = row0.createCell(4);
       cell4.setCellValue("Giá bán");


       XSSFCell cell5 = row0.createCell(5);
       cell5.setCellValue("Loại xe");

       XSSFCell cell6 = row0.createCell(6);
       cell6.setCellValue("Màu xe");

       XSSFCell cell7 = row0.createCell(7);
       cell7.setCellValue("Hãng xe");

       XSSFCell cell8 = row0.createCell(8);
       cell8.setCellValue("Số khung");

       XSSFCell cell9 = row0.createCell(9);
       cell9.setCellValue("Dung tích");

       XSSFCell cell10 = row0.createCell(10);
       cell10.setCellValue("Tồn kho");

       XSSFCell cell11 = row0.createCell(11);
       cell11.setCellValue("Thời gian BH");



       for (int i =0; i<arrXeMay.size(); i++)
       {
         // Viết dữ liệu vào row 1 and row 2
       XSSFRow row = sheet.createRow(i+1);
       
       XSSFCell cell0D = row.createCell(0);
       cell0D.setCellValue(i+1);

       XSSFCell cell1D = row.createCell(1);
       cell1D.setCellValue(arrXeMay.get(i).getMA_XE());

       XSSFCell cell2D = row.createCell(2);
       cell2D.setCellValue(arrXeMay.get(i).getTEN_XE());

       XSSFCell cell3D = row.createCell(3);
       cell3D.setCellValue(arrXeMay.get(i).getGIA_NHAP());

       XSSFCell cell4D = row.createCell(4);
       cell4D.setCellValue(arrXeMay.get(i).getGIA());


       XSSFCell cell5D = row.createCell(5);
       cell5D.setCellValue(arrXeMay.get(i).getTEN_LOAI_XE());

       XSSFCell cell6D = row.createCell(6);
       cell6D.setCellValue(arrXeMay.get(i).getTEN_MAU());

       XSSFCell cell7D = row.createCell(7);
       cell7D.setCellValue(arrXeMay.get(i).getTEN_HANG());

       XSSFCell cell8D = row.createCell(8);
       cell8D.setCellValue(arrXeMay.get(i).getSO_KHUNG());

       XSSFCell cell9D = row.createCell(9);
       cell9D.setCellValue(arrXeMay.get(i).getDUNG_TICH());

       XSSFCell cell10D = row.createCell(10);
       cell10D.setCellValue(arrXeMay.get(i).getTON_KHO());

       XSSFCell cell11D = row.createCell(11);
       cell11D.setCellValue(arrXeMay.get(i).getTHOI_GIAN_BH());
       
         
      }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h'h'm'm's's' dd_MM_yyyy");
    String formattedDateTime = LocalDateTime.now().format(formatter);
    System.out.println(formattedDateTime);

       try {
        // Ghi vào file
       FileOutputStream outFile = new FileOutputStream("Kho xe "+ formattedDateTime +".xlsx");
       workbook.write(outFile);
       outFile.close();
       } catch (Exception e) {
         e.printStackTrace();
       }
       
       System.out.println("Xuất file Excel thành công!");


    }



    public static void main(String[] args) {
        ExportXeMay_Excel excel = new ExportXeMay_Excel();
        excel.ExportXeMay();
    }
    
}
