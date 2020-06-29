package classdata.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import classdata.data.ClassDataDto;
import classdata.data.ClassDataService;
import classdatafiles.data.ClassDataFilesDaoInter;
import classdatafiles.data.ClassDataFilesDto;
import files.data.NoticefilesDaoInter;
import member.data.MemberDto;
import upload.util.ManageFileClass;

@Controller
@CrossOrigin
public class ClassDataController {
	
	@Autowired
	private ClassDataServiceInter service;
	@Autowired
	private ClassDataFilesDaoInter service2;
	
	@PostMapping("/classdata/insertclassdata")
	public void insertClassData(@ModelAttribute ClassDataDto dto
			,MultipartHttpServletRequest request)
	{
		System.out.println(dto);
		
		
		  dto.setClassdata_processclass_num(0);
		  
		  System.out.println("react>>classdataInsert");
		  service.insertClassData(dto);
		  int maxnum= service.selectMaxNum();
		  System.out.println("1차 성공!!");
		  
 
		  if(dto.getClassdata_files()!=null)
		  {
			  service2.insertClassDataFiles(request, dto.getClassdata_files(), maxnum);
		  }else {
			  System.out.println("if문에러");
		  }
		 
		
	}

}
