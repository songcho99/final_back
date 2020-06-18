package study.data;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@CrossOrigin
public class StudyController {
	@Autowired
	private StudyServiceInter service;
	
	// 스터디 모임 추가
	@RequestMapping(value = "/study/add", method = RequestMethod.POST)
	public void insertStudy(
				@ModelAttribute StudyDto dto
			) {
//		StudyDto sdto = new StudyDto();
//		
//		sdto.setStudy_subject(dto.getStudy_type());
//		sdto.setStudy_subject(dto.getStudy_subject());
//		sdto.setStudy_member_num(1); // 테스트용 임의 멤버 num 값
		System.out.println(dto.getStudy_startdate());
		System.out.println(dto.getStudy_enddate());
		System.out.println(dto.getUploadfile().getOriginalFilename());
	}
}
