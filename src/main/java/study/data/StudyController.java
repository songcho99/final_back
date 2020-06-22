package study.data;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import upload.util.SpringFileWrite;

@RestController
@CrossOrigin
public class StudyController {
	@Autowired
	private StudyServiceInter service;
	
	@RequestMapping(value = "/study/add", method = RequestMethod.POST)
	public void insertStudy(
				@ModelAttribute StudyDto dto, HttpServletRequest request
			) {
		StudyDto sdto = new StudyDto();
		String gather = "";
		
		sdto.setStudy_type(dto.getStudy_type());
		sdto.setStudy_subject(dto.getStudy_subject());
		sdto.setStudy_member_num(dto.getStudy_member_num());
		sdto.setStudy_startdate(dto.getStudy_startdate());
		sdto.setStudy_enddate(dto.getStudy_enddate());
		for(String s:dto.getStudy_gatherdayname())
			gather += s + ", ";
		gather = gather.substring(0, gather.length()-2);
		sdto.setStudy_gatherday(gather);
		sdto.setStudy_peoples(dto.getStudy_peoples());
		sdto.setStudy_level(dto.getStudy_level());
		sdto.setStudy_intr(dto.getStudy_intr());
		sdto.setStudy_goal(dto.getStudy_goal());
		sdto.setStudy_progress(dto.getStudy_progress());
		sdto.setStudy_address(dto.getStudy_address());
		sdto.setStudy_detailaddr(dto.getStudy_detailaddr());
		sdto.setStudy_writer(dto.getStudy_writer());
		
		SpringFileWrite sfw = new SpringFileWrite();
		MultipartFile file = dto.getUploadfile();
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		System.out.println("path="+path);
		String filename = sfw.writeFile(file, path);
		System.out.println("filename="+filename);
		sdto.setStudy_mainimage(filename);
		
		service.insertStudy(sdto);
	}
}
