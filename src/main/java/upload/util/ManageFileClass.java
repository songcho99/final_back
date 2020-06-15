package upload.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ManageFileClass {
	
	
	public void fileUpload(MultipartFile uploadfile, String path,int num)
	{	
		String fileName= new Date()+"_"+
	
				num+"_"+uploadfile.getOriginalFilename();
		
		File file = new File(path+"\\"+fileName);
		FileOutputStream fos = null;
		
		try {
			byte[] filedata = uploadfile.getBytes();
			
			fos=new FileOutputStream(path+"\\"+fileName);
			fos.write(filedata);	
		
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
	}
}
	