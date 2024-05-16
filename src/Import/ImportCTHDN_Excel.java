package Import;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.XE_MAY_BUS;
import BUS.XeDaXoa_BUS;
import CHECK.Check1;
import DTO.XE_MAY_DTO;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
public class ImportCTHDN_Excel {
    


    XE_MAY_BUS xe_MAY_BUS = new XE_MAY_BUS();
    Check1 check1 = new Check1();
    ArrayList<XE_MAY_DTO> arrXeMay = new ArrayList<XE_MAY_DTO>();
    public ImportCTHDN_Excel ()
    {

    }

    public int DemDuLieu ()
    {
     try {
        FileInputStream fis = new FileInputStream(new File("Kho xe 4h15m57s 12_05_2023.xlsx"));         // Đọc file Excel từ đường dẫn pathToFile
         XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Lấy sheet đầu tiên
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Biến đếm số dòng có dữ liệu
        int rowCount = 0;

        // Duyệt từng hàng của sheet
        for (Row row : sheet) {
            // Kiểm tra từng ô (cell) trong hàng này
            for (Cell cell : row) {
                // Nếu ô có giá trị khác rỗng thì tăng biến đếm lên 1
                if (cell.getCellType() != CellType.BLANK  && cell.getCellType().equals(" ") == false) {
                    rowCount++;
                    System.out.println(rowCount);
                    break; // Thoát ra khỏi vòng lặp kiểm tra các ô của hàng hiện tại
                }
            }
        }

      
      

        // Đóng workbook sau khi sử dụng xong
        workbook.close();
        return rowCount;
                } catch (Exception e) {
                  return 0;
                }
                
    }


    public ArrayList<XE_MAY_DTO> ImportCTHDN (String fileExcel)
    {
        try {
            // Tạo FileInputStream để đọc tệp Excel
            FileInputStream fis = new FileInputStream(new File(fileExcel+".xlsx"));
    
            // Tạo workbook từ tệp InputStream
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
            // Lấy sheet đầu tiên từ workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            
    
         

            // Duyệt qua các hàng của sheet
            for (int i = 1; i <=DemDuLieu(); i++) {
                Row row = sheet.getRow(i); // Vì index của nó bắt đầu từ 0 nên ở đây là 1
                
                
                XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
                Cell cell1 = row.getCell(1); // Vì index của nó bắt đầu từ 0 nên ở đây là 2
                
                Cell cell2 = row.getCell(2); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell3 = row.getCell(3); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell4 = row.getCell(4); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell5 = row.getCell(5); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell6 = row.getCell(6); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell7 = row.getCell(7); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell8 = row.getCell(8); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell9 = row.getCell(9); // Vì index của nó bắt đầu từ 0 nên ở đây là 2
                
                Cell cell10 = row.getCell(10); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell11 = row.getCell(11); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell12 = row.getCell(12); // Vì index của nó bắt đầu từ 0 nên ở đây là 2



                Cell cell13 = row.getCell(13); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell14 = row.getCell(14); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                Cell cell15 = row.getCell(15); // Vì index của nó bắt đầu từ 0 nên ở đây là 2

                

                // Double dataNum = cell2.getNumericCellValue();
                
                // String dataString = cell2.getStringCellValue();
                // System.out.println(dataString);
                if (cell1.getStringCellValue().equals("Xe mới"))
                {
                String maXe = "";
                while (true) {
                    maXe = check1.Ma_generateRandomCode("MX");
                    if (xe_MAY_BUS.checkMaXe(maXe) == false ){
                      break;
                      }
                  }
                  xe_MAY_DTO.setMA_XE(maXe);
                }else
                {
                    xe_MAY_DTO.setMA_XE(cell1.getStringCellValue());
                }

                xe_MAY_DTO.setTEN_XE(cell2.getStringCellValue());
                
                double giaNhap = cell3.getNumericCellValue();
                xe_MAY_DTO.setGIA_NHAP( (long) giaNhap);

                double giaBan = cell4.getNumericCellValue();
                xe_MAY_DTO.setGIA((long) giaBan);

                xe_MAY_DTO.setTEN_LOAI_XE(cell5.getStringCellValue());
                xe_MAY_DTO.setTEN_MAU(cell6.getStringCellValue());
                xe_MAY_DTO.setTEN_HANG(cell7.getStringCellValue());
                xe_MAY_DTO.setSO_KHUNG(cell8.getStringCellValue());
                xe_MAY_DTO.setDUNG_TICH(cell9.getStringCellValue());
                xe_MAY_DTO.setTHOI_GIAN_BH(cell10.getStringCellValue());
                
                double tonKho = cell11.getNumericCellValue();
                xe_MAY_DTO.setTON_KHO((int)tonKho);
                double tongTien = cell12.getNumericCellValue();
                xe_MAY_DTO.setTONG_TIEN((long)tongTien);

                xe_MAY_DTO.setMA_HANG(cell13.getStringCellValue());
                xe_MAY_DTO.setMA_LOAI(cell14.getStringCellValue());
                xe_MAY_DTO.setMA_MAU(cell15.getStringCellValue());
                

                arrXeMay.add( xe_MAY_DTO);
                
            }
            System.out.println(DemDuLieu());
            workbook.close();
            fis.close();

            return arrXeMay;
      } catch (Exception e) {
      e.printStackTrace();
      
      return null;
     }
    
    }
      
    
    // public static void main(String[] args) {
    //     ImportCTHDN_Excel importCTHDN_Excel = new ImportCTHDN_Excel();
    //     ArrayList<XE_MAY_DTO> arr = importCTHDN_Excel.ImportCTHDN();
    //     // importCTHDN_Excel.DemDuLieu();
    //     for (int i = 0; i < arr.size(); i++)
    //     {
    //         System.out.println(arr.get(i).getMA_XE());
    //     }

    // }
    
    
    



}
