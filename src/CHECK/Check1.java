package CHECK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Check1
{
  private String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    public Boolean CheckTen (String ten, int n)
    {
      if ( ten.trim().length() < n && ten.trim().length() > 1) 
      {
        return true;
      }
      return false;
    }
 

    public Boolean checkSoLuong (String soLuong)
    {
       if (soLuong.trim().matches("[0-9]{1,10}"))
       {
        return true;
       }
       return false;
    }

    public Boolean checkSDT (String sdt)
    {
       if (sdt.trim().matches("[0-9]{1,10}") && sdt.length() == 10)
       {
        return true;
       }
       return false;
    }



    public Boolean checkMa(String maXe, String ten)
   {
      if (maXe.trim().toUpperCase().matches( ten +  "[0-9]{1,6}") && maXe.trim().length() == 7)
      {
        return true;
      }
      return false;
   }

   public Boolean checkMaKH(String maXe, String ten)
   {
      if (maXe.trim().toUpperCase().matches( ten +  "[0-9]{1,7}") && maXe.trim().length() == 8)
      {
        return true;
      }
      return false;
   }

   public Boolean checkThoiGian (String dateString)
   {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); // Tắt tính năng tự động điều chỉnh (lenient) của SimpleDateFormat

    try {
        Date date = sdf.parse(dateString);
        String formattedDateString = sdf.format(date);

        if (formattedDateString.equals(dateString)) {
            
            return true;
        } else {
      
            return false;
        }
    } catch (ParseException ex) {
       
        return false;
    }
   }


    public Boolean checkDungTich (String dungTich)
    {
      if (dungTich.toUpperCase().trim().matches("[0-9]{1,10}" + "CC") && dungTich.length()>=4 && dungTich.length() <=30)
      {
        return true;
      }
      return false;

    }
   
    public Boolean checkGiaNhap (String giaNhap)
    {
      if (giaNhap.trim().matches("[0-9]{1,20}") && giaNhap.length() >=4)
      {
        return true;
      }
      return false;

    }

    public Boolean checksoKhung (String soKhung)
    {
      if (soKhung.matches("^[a-zA-Z0-9]*$") && soKhung.length() >=5 && soKhung.length() <=30)
      {
        return true;
      }
     return false;
    }

    
    public String generateRandomCode(String ma) {
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();
        
        // Add "MM" to the code
        codeBuilder.append(ma);
        
        // Append 5 random characters from the character set
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();
    }


    public String Ma_generateRandomCode(String prefix ) {
      
      Random random = new Random();
      int randomNumber = random.nextInt(100000);
      String code = prefix + String.format("%05d", randomNumber);
      return code;
  }


    
}
