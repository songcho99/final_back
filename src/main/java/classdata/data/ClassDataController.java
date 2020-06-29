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

import classdata.data.ClassDataDto;
import classdata.data.ClassDataService;
import classdatafiles.data.ClassDataFilesDto;
import classdatafiles.data.ClassDataFilesService;
import classdatafiles.data.ClassDataFilesServiceInter;
import member.data.MemberDto;
import upload.util.ManageFileClass;

@Controller
@CrossOrigin
public class ClassDataController {
	
	@Autowired
	private ClassDataServiceInter service;
	@Autowired
	private ClassDataFilesServiceInter service2;
	
	@PostMapping("/classdata/insertclassdata")
	public void insertClassData(@ModelAttribute ClassDataDto classdatadto
			,HttpServletRequest request)
	{
		System.out.println(classdatadto);
		
		ClassDataDto dto = new ClassDataDto();
		
		
		 dto.setClassdata_writer(classdatadto.getClassdata_writer());
		 dto.setClassdata_subject(classdatadto.getClassdata_subject());
		 dto.setClassdata_content(classdatadto.getClassdata_content());
		  dto.setClassdata_processclass_num(0);
		  
		  System.out.println("react>>classdataInsert");
		  service.insertClassData(dto);
		  int maxnum= service.selectMaxNum();
		  System.out.println("1차 성공!!");
		  
 
		  if(classdatadto.getClassdata_files()!=null)
		  {
		  ManageFileClass mfc = new ManageFileClass();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  String path=request.getSession().getServletContext().getRealPath("/WEB-INF/files");
		  System.out.println("path="+path); String nowdate=sdf.format(new Date());
		  System.out.println("react>>classdataFilesInsert");
		  
		  for(MultipartFile uploadfile:classdatadto.getClassdata_files()) { String
		  filename=nowdate+"_"+uploadfile.getOriginalFilename();
		  mfc.fileUpload(filename,uploadfile, path, maxnum); ClassDataFilesDto cfdto =
		  new ClassDataFilesDto();
		  
		  cfdto.setClassdatafiles_classdata_num(maxnum);
		  cfdto.setClassdatafiles_classdata_filename(filename);
		  System.out.println("성공직전");
		  System.out.println(cfdto);
		  service2.insertClassDataFiles(cfdto);
		  		}
		  }
		 
		
	}

}
