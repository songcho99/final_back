package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

//업로드한 이미지를 특정 경로에 저장
public class SpringFileWrite {
   private FileOutputStream fos;
   
   public String writeFile(MultipartFile file,String path)
   {
      
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
      String today=sdf.format(date);
      //파일명
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
}