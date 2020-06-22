package upload.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

//���ε��� �̹����� Ư�� ��ο� ����
public class SpringFileWrite {
   private FileOutputStream fos;
   
   public String writeFile(MultipartFile file,String path)
   {
      
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
      String today=sdf.format(date);
      //���ϸ�
      String fileName=today+"_"+file.getOriginalFilename();
      try {
         byte []fileData=file.getBytes();
         fos=new FileOutputStream(path+"\\"+fileName);
         fos.write(fileData);
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            fos.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return fileName;
   }
   
   public String writeProfile(MultipartFile file, String path, String email) {
	   String fileName = email + "_" + file.getOriginalFilename();
	   
	   try {
		   byte []fileData = file.getBytes();
		   fos = new FileOutputStream(path + "\\" + fileName);
		   fos.write(fileData);
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } finally {
		   try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   return fileName;
   }
}